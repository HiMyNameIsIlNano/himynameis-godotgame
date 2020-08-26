using System;

namespace Com.Example.Game.Scripts.GameStartup
{
    [Serializable]
    [AttributeUsage(AttributeTargets.Property)]
    public class InjectedPropertyAttribute : Attribute
    {
    }
}