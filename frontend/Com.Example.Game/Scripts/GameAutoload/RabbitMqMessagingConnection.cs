using System;
using Com.Example.Common.Services.Socket;
using Godot;

namespace Com.Example.Game.Scripts.GameAutoload
{
    public class RabbitMqMessagingConnection : Node
    {
        public override void _Ready()
        {
            Console.WriteLine("Starting New SoSe");
            AsyncCommunicationFactory.CreateQueuesAndBindToExchangeForPlayerId(54321);
        }
    }
}