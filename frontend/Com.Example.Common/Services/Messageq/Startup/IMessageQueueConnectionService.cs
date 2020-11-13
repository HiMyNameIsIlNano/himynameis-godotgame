using Com.Example.Common.VO.MessageQueue;

namespace Com.Example.Common.Services.Messageq.Startup
{
    public interface IMessageQueueConnectionService
    {
        CreatePlayerQueueResponseVO ConnectPlayerToMessageQueue(int playerId, string exchangeName, string routingKey, string queueName);
        
    }
}