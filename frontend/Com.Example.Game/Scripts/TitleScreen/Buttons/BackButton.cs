using System.Diagnostics;
using Com.Example.Common.Attributes;
using Com.Example.Game.Scripts.GameStartup;
using Com.Example.Game.Scripts.Test;
using Godot;

namespace Com.Example.Game.Scripts.Game
{
    public class BackButton : Button
    {
        [Export] private string _sceneToLoad = "res://Dummy.tscn";

        [InjectedProperty] private ITestService TestService { get; set; }

        public override void _Ready()
        {
            InjectedPropertyResolver.Resolve(this);
        }

        public void OnButtonPressed()
        {
            Debug.Assert(TestService != null, "TestService IS null");
            TestService.DoSomething();
            GetTree().ChangeScene(_sceneToLoad);
        }
    }
}