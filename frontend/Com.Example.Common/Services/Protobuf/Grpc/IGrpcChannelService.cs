using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf.Grpc
{
    public interface IGrpcChannelService
    {
        Channel OpenOrGet();

        Channel CloseAsync();
    }
}