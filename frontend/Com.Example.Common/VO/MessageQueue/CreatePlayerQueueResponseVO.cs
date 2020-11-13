namespace Com.Example.Common.VO.MessageQueue
{
    public class CreatePlayerQueueResponseVO
    {
        public string ExchangeName { get; private set; }

        public string QueueName { get; private set; }

        public int PlayerId { get; private set; }
        
        public static CreatePlayerQueueResponseVO FromCreatePlayerQueueResponse(CreatePlayerQueueResponse response)
        {
            return new CreatePlayerQueueResponseVO
            {
                ExchangeName = response.ExchangeName,
                QueueName = response.QueueName,
                PlayerId = response.PlayerId
            };
        }
    }
}