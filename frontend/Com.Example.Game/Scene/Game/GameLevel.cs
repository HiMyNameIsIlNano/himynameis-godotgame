using System.Linq;
using Com.Example.Common.Attributes;
using Com.Example.Game.Scripts.GameStartup;
using Com.Example.Game.Scripts.Test;
using Godot;
using Godot.Collections;

public class GameLevel : Node2D
{
    private Node2D goals;

    private int levelGoals;

    private int stillFreeGoals;

    private bool gameEnd;

    [InjectedProperty] private ITestService TestService { get; set; }

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

        TestService.DoTerminate();
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