using Com.Example.Common.Attributes;
using Godot;

namespace Com.Example.Game.Scripts.TitleScreen.Buttons
{
    public class BackButton : Button
    {
        [Export] private string _sceneToLoad = "res://Dummy.tscn";

        public override void _Ready()
        {
            InjectedPropertyResolver.Resolve(this);
        }

        public void OnButtonPressed()
        {
            GetTree().ChangeScene(_sceneToLoad);
        }
    }
}