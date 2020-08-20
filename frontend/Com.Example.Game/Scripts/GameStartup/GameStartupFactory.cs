using Com.Example.Common.DependencyInjection;
using Com.Example.Game.Scripts.TitleScreen.FadeIn;
using Godot;
using Godot.Collections;

namespace Com.Example.Game.Scripts.GameStartup
{
    public class GameStartupFactory : Control
    {
        private string _scenePathToLoad;

        public override void _Ready()
        {
            DependencyInjectionFactory.Build();
            ConnectButtonsToScene();
        }

        private void ConnectButtonsToScene()
        {
            foreach (MenuButton menuButton in GetNode("Menu/CenterRow/Buttons").GetChildren())
            {
                menuButton.Connect("pressed", this, "OnButtonPressed", new Array() {menuButton.GetSceneToLoad()});
            }
        }

        private void OnButtonPressed(string sceneToLoad)
        {
            if (!HasNode("FadeIn"))
            {
                return;
            }

            _scenePathToLoad = sceneToLoad;
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
            GetTree().ChangeScene(_scenePathToLoad);
        }
    }
}