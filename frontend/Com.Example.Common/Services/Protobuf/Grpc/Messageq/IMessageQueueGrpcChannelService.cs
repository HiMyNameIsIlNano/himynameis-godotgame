using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf.Grpc.Messageq
{
    public interface IMessageQueueGrpcChannelService
    {
        Channel OpenOrGet();

        Channel CloseAsync();
    }
}