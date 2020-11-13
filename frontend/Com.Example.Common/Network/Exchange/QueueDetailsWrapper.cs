using System.Collections.Generic;

namespace Com.Example.Common.Network.Exchange
{
    public class QueueDetailsWrapper
    {
        public static readonly QueueDetailsWrapper __Rewards =
            new QueueDetailsWrapper("rewards.push-notification.exchange", "rewards.push-notification.queue", "");

        public static IEnumerable<QueueDetailsWrapper> Values
        {
            get { yield return __Rewards; }
        }

        public string PlayerQueueName(int playerId)
        {
            return $"{playerId}.{this.QueueNameSuffix}";
        }

        public string ExchangeName { get; private set; }
        public string QueueNameSuffix { get; private set; }
        public string RoutingKey { get; private set; }

        QueueDetailsWrapper(string exchangeName, string queueNameSuffix, string routingKey) =>
            (ExchangeName, QueueNameSuffix, RoutingKey) = (exchangeName, queueNameSuffix, routingKey);
    }
}