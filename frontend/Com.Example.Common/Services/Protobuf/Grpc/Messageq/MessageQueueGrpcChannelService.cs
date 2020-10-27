using Com.Example.Common.Network.Grpc;
using Com.Example.Common.Services.Protobuf.Grpc.Messageq;
using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf.Grpc
{
    public class MessageQueueGrpcChannelService : IMessageQueueGrpcChannelService
    {
        public Channel OpenOrGet()
        {
            return MessageQueueGrpcChannelSingleton.ChannelInstance;
        }

        public Channel CloseAsync()
        {
            return MessageQueueGrpcChannelSingleton.CloseAsync();
        }
    }
}