namespace Com.Example.Common.VO.MessageQueue
{
    public class CreatePlayerQueueResponseVo
    {
        public string ExchangeName { get; private set; }

        public string QueueName { get; private set; }

        public int PlayerId { get; private set; }

        public bool Created { get; private set; }

        public string ErrorMessage { get; private set; }

        public static CreatePlayerQueueResponseVo ToCreatePlayerQueueResponseVo(CreatePlayerQueueResponse response)
        {
            return new CreatePlayerQueueResponseVo
            {
                Created = response.Created,
                ExchangeName = response.ExchangeName,
                QueueName = response.QueueName,
                ErrorMessage = response.ErrorMessage,
                PlayerId = response.PlayerId
            };
        }
    }
}