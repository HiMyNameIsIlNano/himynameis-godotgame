namespace Com.Example.Common.Services.Messageq.Api
{
    public interface IMessageQueueApiService
    {
        QueueMessage PopMessage(string queueName);
    }
}