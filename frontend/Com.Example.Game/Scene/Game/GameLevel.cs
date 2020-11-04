using System.Linq;
using Com.Example.Common.Attributes;
using Com.Example.Common.Services.Reward;
using Com.Example.Game.Scene.Game;
using Com.Example.Game.Scripts.GameStartup;
using Godot;
using Godot.Collections;

public class GameLevel : Node2D
{
    [InjectedProperty] private IRewardService RewardService { set; get; }

    private Node2D goals;

    private int levelGoals;

    private int stillFreeGoals;

    private bool gameEnd;

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
        gameEnd = stillFreeGoals <= 0;
        if (!gameEnd)
        {
            return;
        }

        RewardService.GenerateRandomEventOnLevelCleared(1);
        GetTree().ReloadCurrentScene();
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