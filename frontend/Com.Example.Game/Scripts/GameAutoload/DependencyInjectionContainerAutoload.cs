using System;
using Com.Example.Common.DependencyInjection;
using Godot;

namespace Com.Example.Game.Scripts.GameAutoload
{
    public class DependencyInjectionContainerAutoload : Node
    {
        public override void _Ready()
        {
            Console.WriteLine("Creating the Dependency Injection Container");
            DependencyInjectionFactory.Build();
        }
    }
}