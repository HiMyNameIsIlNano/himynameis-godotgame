using System;

namespace Com.Example.Common.Annotations
{
    [Serializable]
    [AttributeUsage(AttributeTargets.Property)]
    public class InjectedPropertyAttribute : Attribute
    {
    }
}