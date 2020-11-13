using Google.Protobuf;
using Google.Protobuf.Reflection;
using Google.Protobuf.WellKnownTypes;

namespace Com.Example.Common.Services.Protobuf.Utils
{
    public interface IProtobufNetworkUtilsService
    {
        T UnpackResponse<T>(Any message, MessageDescriptor descriptor) where T : IMessage, new();
    }
}