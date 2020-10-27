using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf.Grpc.Backend
{
    public interface IBackEndGrpcChannelService
    {
        Channel OpenOrGet();

        Channel CloseAsync();
    }
}