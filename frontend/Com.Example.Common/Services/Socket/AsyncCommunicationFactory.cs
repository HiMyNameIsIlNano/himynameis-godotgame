using Com.Example.Common.Network.Exchange;
using RabbitMQ.Client;

namespace Com.Example.Common.Services.Socket
{
    public static class AsyncCommunicationFactory
    {
        private const string FrontEndNotificationQueueName = "queued.push-notification";

        private const string HostName = "localhost";

        private const int Port = 5672;

        private const string Password = "sose-pwd";

        private const string UserName = "sose-admin";

        public static void CreateQueuesAndBindToExchangeForPlayerId(int playerId)
        {
            var factory = new ConnectionFactory()
            {
                HostName = HostName, Port = Port, Password = Password, UserName = UserName
            };
            
            using (var connection = factory.CreateConnection())
            {
                using (var channel = connection.CreateModel())
                {
                    string queueName = $"{playerId}.{FrontEndNotificationQueueName}";
                    
                    channel.QueueDeclare(queueName, false, false,
                        false,
                        false,
                        false,
                        null);

                    channel.QueueBind(queueName,
                        ExchangeNameConstants.SocketServerPushMessage,
                        "",
                        false,
                        null);

                    /*string message = "Hello World!";
                    var body = Encoding.UTF8.GetBytes(message);
    
                    channel.BasicPublish(exchange: "", routingKey: "hello", basicProperties: null, body: body);*/
                }
            }
        }
    }
}