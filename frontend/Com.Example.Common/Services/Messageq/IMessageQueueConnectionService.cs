namespace Com.Example.Common.Services.Messageq
{
    public interface IMessageQueueConnectionService
    {
        CreatePlayerQueueResponse ConnectPlayerToMessageQueue(int playerId, string exchangeName, string queueName);
    }
}