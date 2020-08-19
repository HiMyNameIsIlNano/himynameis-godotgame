using Godot;

public class MenuButton : Button
{
    [Export] private string _sceneToLoad = "res://Dummy.tscn";

    public string GetSceneToLoad()
    {
        return _sceneToLoad;
    }
}