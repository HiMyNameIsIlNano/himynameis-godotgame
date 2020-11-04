using System;
using Com.Example.Common.Attributes;
using Com.Example.Common.Services.Messageq;
using Com.Example.Game.Scripts.GameStartup;
using Godot;

namespace Com.Example.Game.Scripts.GameAutoload
{
    public class RabbitMqMessagingConnectionAutoload : Node
    {
        private const string MessageQueueExchangeName = "push-notification";

        private const string FrontEndNotificationQueueName = "push-notification-queue";

        [InjectedProperty] private IMessageQueueConnectionService MessageQueueConnectionService { get; set; }

        public override void _Ready()
        {
            Console.WriteLine("Connecting to Messageq");
            InjectedPropertyResolver.Resolve(this);

            CreateQueuesAndBindToExchangeForPlayerId(54321);
        }

        private void CreateQueuesAndBindToExchangeForPlayerId(int playerId)
        {
            string queueName = $"{playerId}.{FrontEndNotificationQueueName}";
            MessageQueueConnectionService.ConnectPlayerToMessageQueue(playerId, MessageQueueExchangeName, queueName);
        }
    }
}