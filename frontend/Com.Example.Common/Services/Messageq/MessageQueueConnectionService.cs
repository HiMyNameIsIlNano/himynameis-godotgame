using System;
using Com.Example.Common.Services.Protobuf.Grpc.Messageq;
using Com.Example.Game.Scripts.GameStartup;
using static ManageQueueGrpcService;

namespace Com.Example.Common.Services.Messageq
{
    public class MessageQueueConnectionService : IMessageQueueConnectionService
    {
        
        private readonly IMessageQueueGrpcChannelService _messageQueueGrpcChannelService;

        public MessageQueueConnectionService(IMessageQueueGrpcChannelService messageQueueGrpcChannelService)
        {
            _messageQueueGrpcChannelService = messageQueueGrpcChannelService;
        }

        public CreatePlayerQueueResponse ConnectPlayerToMessageQueue(int playerId, string exchangeName,
            string queueName)
        {
            Console.WriteLine($"Connecting Player ${playerId} to queue ${queueName}...");

            ManageQueueGrpcServiceClient queueGrpcClient =
                new ManageQueueGrpcServiceClient(_messageQueueGrpcChannelService.OpenOrGet());

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