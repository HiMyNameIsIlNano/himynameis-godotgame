using Com.Example.Common.Attributes;
using Com.Example.Common.Services.Reward;
using Com.Example.Game.Scripts.GameStartup;
using Godot;

namespace Com.Example.Game.Scene.Game
{
    public class GenericGoal : Area2D
    {
        [InjectedProperty] private IRewardService RewardService { set; get; }

        public bool Occupied { get; private set; }

        public override void _Ready()
        {
            InjectedPropertyResolver.Resolve(this);
        }

        public void _OnGoalBodyEntered(Node node)
        {
            if (!node.IsInGroup(GenericBox.GetMovableBoxGroup()))
            {
                return;
            }

            RewardService.GetRewardOnBoxFilled();
            Occupied = true;
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