using Com.Example.Common.Network.Exchange;
using RabbitMQ.Client;

namespace Com.Example.Common.Services.Socket
{
    public static class AsyncCommunicationFactory
    {
        private const string FrontEndNotificationQueueName = "front-end-notification";
        
        public static void CreateQueuesAndBindToExchange()
        {
            // var factory = new ConnectionFactory() { HostName = "localhost" };
            var factory = new ConnectionFactory();
            using (var connection = factory.CreateConnection())
            {
                using (var channel = connection.CreateModel())
                {
                    channel.QueueDeclare(queue: FrontEndNotificationQueueName, durable: false, exclusive: false, autoDelete: false,
                        arguments: null);
                    channel.QueueBind(FrontEndNotificationQueueName, ExchangeNameConstants.SocketServerPushMessage, "");

                    /*string message = "Hello World!";
                    var body = Encoding.UTF8.GetBytes(message);
    
                    channel.BasicPublish(exchange: "", routingKey: "hello", basicProperties: null, body: body);*/
                }
            }
        }
    }
}