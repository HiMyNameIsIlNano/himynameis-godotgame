using System;
using System.Linq;
using Com.Example.Common.Attributes;
using Com.Example.Common.Network.Exchange;
using Com.Example.Common.Services.Messageq.Startup;
using Com.Example.Game.Scripts.GameStartup;
using Godot;

namespace Com.Example.Game.Scripts.GameAutoload
{
    public class RabbitMqMessagingConnectionAutoload : Node
    {
        [InjectedProperty] private IMessageQueueConnectionService MessageQueueConnectionService { get; set; }

        public override void _Ready()
        {
            InjectedPropertyResolver.Resolve(this);
            CreateQueuesAndBindToExchangeForPlayerId(54321);
        }

        private void CreateQueuesAndBindToExchangeForPlayerId(int playerId)
        {
            QueueDetailsWrapper.Values.ToList().ForEach(queue => CreateQueueForPlayer(queue, playerId));
        }

        private void CreateQueueForPlayer(QueueDetailsWrapper queue, int playerId)
        {
            try
            {
                MessageQueueConnectionService.ConnectPlayerToMessageQueue(playerId, queue.ExchangeName,
                    queue.RoutingKey,
                    queue.PlayerQueueName(playerId));
            }
            catch (Exception e)
            {
                // TODO: EXCEPTION HANDLING
                Console.WriteLine(e);
                throw;
            }
        }
    }
}