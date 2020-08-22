using System;
using Godot;

namespace Com.Example.Game.Scripts.TitleScreen.FadeIn
{
    public class FadeIn : ColorRect
    {
        [Signal]
        delegate void FadeFinished();

        private const string FADE_IN_FINISHED_SIGNAL = "FadeFinished";

        private const string FADE_IN_ANIMATION = "FadeIn";

        public void PlayFadeIn()
        {
            if (!HasNode("AnimationPlayer"))
            {
                throw new NotSupportedException();
            }

            AnimationPlayer animationPlayer = (AnimationPlayer) GetNode("AnimationPlayer");
            animationPlayer.Play(FADE_IN_ANIMATION);
        }

        public void OnAnimationPlayerAnimationFinished(string animationName)
        {
            if (!FADE_IN_ANIMATION.Equals(animationName))
            {
                throw new NotSupportedException();
            }

            EmitSignal(FADE_IN_FINISHED_SIGNAL);
        }
    }
}