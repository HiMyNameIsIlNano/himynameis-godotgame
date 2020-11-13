using System;
using System.Threading.Tasks;
using Com.Example.Common.Attributes;
using Com.Example.Common.Network.Protobuf.Reward;
using Com.Example.Common.Services.Event;
using Com.Example.Common.Services.Reward;
using Com.Example.Common.VO.MessageQueue;
using Com.Example.Game.Scripts.GameStartup;
using Godot;
using static Com.Example.Common.Network.Protobuf.Reward.RewardRequest.Types;

namespace Com.Example.Game.Scene.Game
{
    public class GenericGoal : Area2D
    {
        [InjectedProperty] private IRewardService RewardService { set; get; }
        
        [InjectedProperty] private IEventHandlerService EventHandlerService { set; get; }

        public bool Occupied { get; private set; }

        public override void _Ready()
        {
            InjectedPropertyResolver.Resolve(this);
        }

        public async void _OnGoalBodyEntered(Node node)
        {
            if (!node.IsInGroup(GenericBox.GetMovableBoxGroup()))
            {
                return;
            }

            Task<RewardResponse> rewardOnBoxFilled = RewardService.GetRewardOnBoxFilledAsync(1, BoxType.Blue);
            await rewardOnBoxFilled.ContinueWith(task => HandleRewards(rewardOnBoxFilled.Result));
            Occupied = true;
        }

        private void HandleRewards(RewardResponse rewardResponse)
        {
            EventHandlerService.HandleGameEvent(RewardVO.FromRewardResponse(rewardResponse));
        }

        public void _OnGoalBodyExited(Node node)
        {
            if (!node.IsInGroup(GenericBox.GetMovableBoxGroup()))
            {
                return;
            }

            Occupied = false;
        }
    }
}