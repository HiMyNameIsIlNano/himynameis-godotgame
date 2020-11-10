using Com.Example.Common.VO.MessageQueue;

namespace Com.Example.Common.Services.Messageq
{
    public interface IMessageQueueConnectionService
    {
        CreatePlayerQueueResponseVo ConnectPlayerToMessageQueue(int playerId, string exchangeName, string routingKey, string queueName);
    }
}