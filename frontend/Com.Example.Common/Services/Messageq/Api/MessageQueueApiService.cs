using Com.Example.Common.Services.Protobuf.Grpc.Messageq;
using static QueueActionsGrpcService;

namespace Com.Example.Common.Services.Messageq.Api
{
    public class MessageQueueApiService : IMessageQueueApiService
    {
        private readonly IMessageQueueGrpcChannelService _messageQueueGrpcChannelService;

        private readonly QueueActionsGrpcServiceClient _queueActionsClient;

        public MessageQueueApiService(IMessageQueueGrpcChannelService messageQueueGrpcChannelService)
        {
            _messageQueueGrpcChannelService = messageQueueGrpcChannelService;
            _queueActionsClient = new QueueActionsGrpcServiceClient(_messageQueueGrpcChannelService.OpenOrGet());
        }

        public QueueMessage PopMessage(string queueName)
        {
            PopMessageRequest popMessageRequest = new PopMessageRequest
            {
                QueueName = queueName
            };

            // TODO: Manage Exceptions
            return _queueActionsClient.PopMessage(popMessageRequest);
        }
    }
}