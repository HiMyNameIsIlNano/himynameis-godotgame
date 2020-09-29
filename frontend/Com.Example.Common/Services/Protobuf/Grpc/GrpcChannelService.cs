using Com.Example.Common.Network.Grpc;
using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf.Grpc
{
    public class GrpcChannelService : IGrpcChannelService
    {
        public Channel OpenOrGet()
        {
            return GrpcChannelSingleton.ChannelInstance;
        }

        public Channel CloseAsync()
        {
            return GrpcChannelSingleton.CloseAsync();
        }
    }
}