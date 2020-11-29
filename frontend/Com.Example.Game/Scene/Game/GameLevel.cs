using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Linq;
using System.Threading.Tasks;
using Com.Example.Common.Annotations;
using Com.Example.Common.Attributes;
using Com.Example.Common.Network.Protobuf.Reward;
using Com.Example.Common.Services.Event;
using Com.Example.Common.Services.Reward;
using Com.Example.Common.VO.MessageQueue;
using Com.Example.Game.Scene.Game;
using Com.Example.Game.Scripts.GameStartup;
using Godot;
using Array = Godot.Collections.Array;

public class GameLevel : Node2D
{
    [InjectedProperty] private IRewardService RewardService { set; get; }
    
    [InjectedProperty] private IEventHandlerService EventHandlerService { set; get; }

    private Node2D goals;

    private int levelGoals;

    private int stillFreeGoals;

    public override void _Ready()
    {
        goals = GetNode<Node2D>("Goals");
        levelGoals = goals.GetChildCount();
        stillFreeGoals = levelGoals;
        InjectedPropertyResolver.Resolve(this);
    }

    public override void _Process(float delta)
    {
        UpdateFreeGoalsAmount();
        CheckIfGameEnded();
    }

    private void CheckIfGameEnded()
    {
        if (stillFreeGoals > 0)
        {
            return;
        }

        Task<RewardResponse> randomEventOnLevelCleared = RewardService.GenerateRandomEventOnLevelCleared(1);
        randomEventOnLevelCleared.ContinueWith(task => HandleRewards(randomEventOnLevelCleared.Result));
        
        ImmutableList<RewardVO> rewardVos = RewardService.GetRewardFromQueueForPlayer(54321);
        EventHandlerService.HandleGameEvent(rewardVos);
        
        GetTree().ReloadCurrentScene();
    }

    private void HandleRewards(RewardResponse rewardResponse)
    {
        EventHandlerService.HandleGameEvent(RewardVO.FromRewardResponse(rewardResponse));
    }

    private void UpdateFreeGoalsAmount()
    {
        if (stillFreeGoals <= 0)
        {
            return;
        }

        Array allGoals = goals.GetChildren();
        int occupiedGoals = allGoals.Cast<GenericGoal>()
            .Count(goal => goal.Occupied);

        stillFreeGoals = levelGoals - occupiedGoals;
    }
}