using System.Diagnostics;
using Com.Example.Common.Attributes;
using Com.Example.Common.DependencyInjection;
using Com.Example.Common.Services.AnotherTest;
using Com.Example.Common.Services.BaseService;
using Com.Example.Game.Scripts.GameStartup;
using Com.Example.Game.Scripts.Test;
using Godot;

namespace Com.Example.Game.Scripts.Game
{
    public class BackButton : Button
    {
        [Export] private string _sceneToLoad = "res://Dummy.tscn";

        // TODO: try to make the annotation processor work with private fields as well
        [InjectedProperty] public ITestService TestService { get; set; }

        [InjectedProperty] public IAnotherTestService AnotherTestService { get; set; }
        
        [InjectedProperty] public IConcreteService ConcreteService { get; set; }
        
        public BackButton()
        {
            InjectedPropertyResolver.Resolve( this);
        }

        public void OnButtonPressed()
        {
            Debug.Assert(TestService != null, "TestService IS null");
            Debug.Assert(AnotherTestService != null, "AnotherTestService IS null");

            TestService.DoSomething();
            AnotherTestService.DoAnotherThing();
            ConcreteService.DoConcreteStuff();
            GetTree().ChangeScene(_sceneToLoad);
        }
    }
}