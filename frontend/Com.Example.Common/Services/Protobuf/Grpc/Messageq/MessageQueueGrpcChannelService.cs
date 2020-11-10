using Com.Example.Common.Network.Grpc;
using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf.Grpc.Messageq
{
    public class MessageQueueGrpcChannelService : IMessageQueueGrpcChannelService
    {
        public Channel OpenOrGet()
        {
            return MessageQueueGrpcChannelSingleton.ChannelInstance;
        }

        public Channel CloseAsync()
        {
            Channel channelInstance = MessageQueueGrpcChannelSingleton.ChannelInstance;
            channelInstance.ShutdownAsync().Wait();
            return channelInstance;
        }
    }
}