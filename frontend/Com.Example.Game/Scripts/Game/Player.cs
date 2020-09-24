using System.Linq;
using Com.Example.Game.Scene.Game;
using Godot;
using Godot.Collections;

namespace Com.Example.Game.Scripts.Game
{
    public class Player : KinematicBody2D
    {
        private const string PlayerCollisionDetectorName = "PlayerCollisionDetector";

        private const int TileSize = 16;

        private const float TweenDuration = 0.3F;

        private Tween _playerTween;

        private RayCast2D PlayerCollisionDetector { get; set; }

        private static readonly Dictionary<string, Vector2> MovementMap = new Dictionary<string, Vector2>
        {
            {"ui_up", Vector2.Up * TileSize},
            {"ui_down", Vector2.Down * TileSize},
            {"ui_left", Vector2.Left * TileSize},
            {"ui_right", Vector2.Right * TileSize}
        };

        public override void _Ready()
        {
            PlayerCollisionDetector = GetNode<RayCast2D>(PlayerCollisionDetectorName);
            _playerTween = GetNode<Tween>("PlayerTween");
        }

        public override void _UnhandledInput(InputEvent @event)
        {
            ChekIfPlayerResetLevelEvent(@event);
            Vector2 movement = TryGetPlayerMovement(@event, out bool isMovementEvent);
            if (!isMovementEvent)
            {
                return;
            }

            MovePlayer(movement);
        }

        private void ChekIfPlayerResetLevelEvent(InputEvent @event)
        {
            if (@event.IsActionPressed("reset"))
            {
                GetTree().ReloadCurrentScene();
            }
        }

        private static Vector2 TryGetPlayerMovement(InputEvent @event, out bool directionFound)
        {
            directionFound = false;
            string directionKey = MovementMap.Keys.FirstOrDefault(direction => @event.IsActionPressed(direction));

            if (directionKey == null)
            {
                return default;
            }

            MovementMap.TryGetValue(directionKey, out Vector2 directionVector);
            directionFound = directionVector != default;
            return directionVector;
        }

        private void MovePlayer(Vector2 movement)
        {
            if (_playerTween.IsActive())
            {
                return;
            }

            UpdatePlayerCollisionDetector(movement);

            _playerTween.InterpolateProperty(this, "position",
                Position, Position + movement,
                TweenDuration,
                Tween.TransitionType.Sine);

            UpdateMovableObjectPositions(movement);
        }

        private void UpdateMovableObjectPositions(Vector2 movement)
        {
            bool playerPickedUpBox = DetectAndGetMovableBox(out GenericBox box);
            if (!playerPickedUpBox)
            {
                UpdatePlayerPosition();
                return;
            }

            bool boxMoved = box.MoveBox(movement);
            if (boxMoved)
            {
                _playerTween.Start();
            }
        }

        private void UpdatePlayerPosition()
        {
            if (IsPlayerCollidingWithAnyObject())
            {
                return;
            }

            _playerTween.Start();
        }

        private bool DetectAndGetMovableBox(out GenericBox box)
        {
            box = null;
            if (!IsPlayerCollidingWithAnyObject())
            {
                return false;
            }

            bool isMovableBoxPickUp = IsMovableBoxPickUp(out GenericBox genericBox);
            box = genericBox;
            return isMovableBoxPickUp;
        }

        private bool IsPlayerCollidingWithAnyObject()
        {
            return PlayerCollisionDetector.IsColliding();
        }

        private bool IsMovableBoxPickUp(out GenericBox box)
        {
            box = null;
            Object collidingObject = PlayerCollisionDetector.GetCollider();

            if (collidingObject == null || !(collidingObject is GenericBox genericBox))
            {
                return false;
            }

            box = genericBox;
            return genericBox.IsInGroup(GenericBox.GetMovableBoxGroup());
        }

        private void UpdatePlayerCollisionDetector(Vector2 movement)
        {
            PlayerCollisionDetector.CastTo = movement;
            PlayerCollisionDetector.ForceRaycastUpdate();
        }
    }
}