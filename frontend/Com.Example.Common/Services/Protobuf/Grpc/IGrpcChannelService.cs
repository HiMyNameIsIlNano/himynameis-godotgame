using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf
{
    public interface IGrpcChannelService
    {
        Channel OpenOrGet();
        
        Channel CloseAsync();
    }
}