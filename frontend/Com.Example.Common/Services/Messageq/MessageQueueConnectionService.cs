using System;
using Com.Example.Common.Services.Protobuf.Grpc;
using static ManageQueueGrpcService;

namespace Com.Example.Common.Services.Messageq
{
    public class MessageQueueConnectionService : IMessageQueueConnectionService
    {
        private readonly IGrpcChannelService _grpcChannelService;

        public MessageQueueConnectionService(IGrpcChannelService grpcChannelService)
        {
            _grpcChannelService = grpcChannelService;
        }

        public CreatePlayerQueueResponse ConnectPlayerToMessageQueue(int playerId, string exchangeName,
            string queueName)
        {
            Console.WriteLine($"Connecting Player ${playerId} to queue ${queueName}...");

            ManageQueueGrpcServiceClient queueGrpcClient =
                new ManageQueueGrpcServiceClient(_grpcChannelService.OpenOrGet());

            CreatePlayerQueueRequest createPlayerQueueRequest = new CreatePlayerQueueRequest
            {
                ExchangeName = exchangeName,
                PlayerId = playerId,
                QueueName = queueName
            };

            return queueGrpcClient.ConnectPlayerToQueue(createPlayerQueueRequest);
        }
    }
}