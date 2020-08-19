using Godot;

namespace Com.Example.Game.Scripts.Game
{
    public class BackButton : Button
    {
        [Export] private string _sceneToLoad = "res://Dummy.tscn";
        
        public void OnButtonPressed()
        {
            GetTree().ChangeScene(_sceneToLoad);
        }
    }
}