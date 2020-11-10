using System;
using Com.Example.Common.Services.Protobuf.Grpc.Messageq;
using Com.Example.Common.VO.MessageQueue;
using static ManageQueueGrpcService;

namespace Com.Example.Common.Services.Messageq
{
    public class MessageQueueConnectionService : IMessageQueueConnectionService
    {
        private readonly IMessageQueueGrpcChannelService _messageQueueGrpcChannelService;

        private readonly ManageQueueGrpcServiceClient _queueGrpcClient;

        public MessageQueueConnectionService(IMessageQueueGrpcChannelService messageQueueGrpcChannelService)
        {
            _messageQueueGrpcChannelService = messageQueueGrpcChannelService;
            _queueGrpcClient = new ManageQueueGrpcServiceClient(_messageQueueGrpcChannelService.OpenOrGet());
        }

        public CreatePlayerQueueResponseVo ConnectPlayerToMessageQueue(int playerId, string exchangeName,
            string routingKey, string queueName)
        {
            Console.WriteLine($"Connecting Player ${playerId} to queue ${queueName}...");

            CreatePlayerQueueRequest createPlayerQueueRequest = new CreatePlayerQueueRequest
            {
                ExchangeName = exchangeName,
                PlayerId = playerId,
                QueueName = queueName,
                RoutingKey = routingKey
            };

            CreatePlayerQueueResponse createPlayerQueueResponse =
                _queueGrpcClient.ConnectPlayerToQueue(createPlayerQueueRequest);

            return CreatePlayerQueueResponseVo.ToCreatePlayerQueueResponseVo(createPlayerQueueResponse);
        }
    }
}