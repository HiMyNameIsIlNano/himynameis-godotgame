using Com.Example.Common.Network.Grpc;
using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf
{
    public class GrpcChannelService : IGrpcChannelService
    {
        public Channel OpenOrGet()
        {
            return GrpcChannelSingleton.ChannelInstance;
        }

        public Channel CloseAsync()
        {
            // TODO: Is this safe?.
            return GrpcChannelSingleton.CloseAsync();
        }
    }
}