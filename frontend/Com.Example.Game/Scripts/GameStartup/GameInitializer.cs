using System;
using Autofac;
using Com.Example.Common.DependencyInjection;
using Godot;

namespace Com.Example.Game.Scripts.GameStartup
{
    public class GameInitializer : Node
    {
        
        public override void _Ready()
        {
            Console.WriteLine("Creating the Beans Container");
            DependencyInjectionFactory.Build();
            
            Console.WriteLine("Startup SoSe");
            // Call SocketServerStartup
        }
    }
}