using Com.Example.Game.Scripts.TitleScreen.FadeIn;
using Godot;
using Godot.Collections;

namespace Com.Example.Game.Scripts.GameStartup
{
    public class TitleScreenSceneInitializer : Control
    {
        private string scenePathToLoad;

        public override void _Ready()
        {
            ConnectButtonsToScene();
        }

        private void ConnectButtonsToScene()
        {
            foreach (MenuButton menuButton in GetNode("Menu/CenterRow/Buttons").GetChildren())
            {
                menuButton.Connect("pressed", this, "OnButtonPressed",
                    new Array() {menuButton.GetSceneToLoad()});
            }
        }

        private void OnButtonPressed(string sceneToLoad)
        {
            if (!HasNode("FadeIn"))
            {
                return;
            }

            scenePathToLoad = sceneToLoad;
            PlayFadeInEffect();
        }

        private void PlayFadeInEffect()
        {
            FadeIn fadeIn = (FadeIn) GetNode("FadeIn");
            fadeIn.Show();
            fadeIn.PlayFadeIn();
        }

        public void OnFadeInFadeFinished()
        {
            GetTree().ChangeScene(scenePathToLoad);
        }
    }
}