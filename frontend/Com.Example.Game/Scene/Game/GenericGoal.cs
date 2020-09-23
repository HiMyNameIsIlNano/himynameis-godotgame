using Com.Example.Common.Attributes;
using Com.Example.Game.Scene.Game;
using Com.Example.Game.Scripts.GameStartup;
using Com.Example.Game.Scripts.Test;
using Godot;

public class GenericGoal : Area2D
{
    [InjectedProperty] private ITestService TestService { get; set; }

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

        TestService.DoSomething();
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