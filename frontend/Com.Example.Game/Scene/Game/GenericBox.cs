using Godot;

public class GenericBox : KinematicBody2D
{
    
    private const string MovableBoxGroupName = "GoodBox";

    private const string BoxCollisionDetectorName = "BoxCollisionDetector";

    private RayCast2D BoxCollisionDetector { get; set; }

    public override void _Ready()
    {
        BoxCollisionDetector = GetNode<RayCast2D>(BoxCollisionDetectorName);
    }

    public static string GetMovableBoxGroup()
    {
        return MovableBoxGroupName;
    }

    public bool MoveBox(Vector2 movement)
    {
        UpdateBoxCollisionDetector(movement);
        if (BoxCollisionDetector.IsColliding())
        {
            return false;
        }

        Position += movement;
        return true;
    }

    private void UpdateBoxCollisionDetector(Vector2 movement)
    {
        BoxCollisionDetector.CastTo = movement;
        BoxCollisionDetector.ForceRaycastUpdate();
    }
}