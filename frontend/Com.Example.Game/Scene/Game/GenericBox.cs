using Godot;

namespace Com.Example.Game.Scene.Game
{
    public class GenericBox : KinematicBody2D
    {
        private const string MovableBoxGroupName = "GoodBox";

        private const string BoxCollisionDetectorName = "BoxCollisionDetector";

        private const float TweenDuration = 0.3F;

        private RayCast2D BoxCollisionDetector { get; set; }

        private Tween GenericBoxTween { get; set; }

        public override void _Ready()
        {
            BoxCollisionDetector = GetNode<RayCast2D>(BoxCollisionDetectorName);
            GenericBoxTween = GetNode<Tween>("BoxTween");
        }

        public static string GetMovableBoxGroup()
        {
            return MovableBoxGroupName;
        }

        public bool MoveBox(Vector2 movement)
        {
            if (GenericBoxTween.IsActive())
            {
                return false;
            }

            UpdateBoxCollisionDetector(movement);
            if (BoxCollisionDetector.IsColliding())
            {
                return false;
            }

            GenericBoxTween.InterpolateProperty(this, "position",
                Position, Position + movement,
                TweenDuration,
                Tween.TransitionType.Sine);

            GenericBoxTween.Start();
            return true;
        }

        private void UpdateBoxCollisionDetector(Vector2 movement)
        {
            BoxCollisionDetector.CastTo = movement;
            BoxCollisionDetector.ForceRaycastUpdate();
        }
    }
}