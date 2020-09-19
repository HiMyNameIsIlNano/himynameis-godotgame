using System.Linq;
using Com.Example.Common.Attributes;
using Com.Example.Game.Scripts.GameStartup;
using Com.Example.Game.Scripts.Test;
using Godot;
using Godot.Collections;

namespace Com.Example.Game.Scripts.Game
{
    public class Player : KinematicBody2D
    {
        private const string PlayerCollisionDetectorName = "PlayerCollisionDetector";

        private const int TileSize = 16;
        private RayCast2D PlayerCollisionDetector { get; set; }

        [InjectedProperty] private ITestService TestService { get; set; }

        private static readonly Dictionary<string, Vector2> MovementMap = new Dictionary<string, Vector2>
        {
            {"ui_up", Vector2.Up * TileSize},
            {"ui_down", Vector2.Down * TileSize},
            {"ui_left", Vector2.Left * TileSize},
            {"ui_right", Vector2.Right * TileSize}
        };

        public override void _Ready()
        {
            InjectedPropertyResolver.Resolve(this);
            PlayerCollisionDetector = GetNode<RayCast2D>(PlayerCollisionDetectorName);
        }

        public override void _UnhandledInput(InputEvent @event)
        {
            Vector2 movement = TryGetPlayerMovement(@event, out bool isMovementEvent);
            if (!isMovementEvent)
            {
                return;
            }

            MovePlayer(movement);
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
            UpdatePlayerCollisionDetector(movement);
            bool playerPickedUpBox = DetectAndGetMovableBox(out GenericBox box);

            if (playerPickedUpBox)
            {
                bool boxMoved = box.MoveBox(movement);
                if (boxMoved)
                {
                    Position += movement;
                }
            }
            else
            {
                Position += movement;
            }
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