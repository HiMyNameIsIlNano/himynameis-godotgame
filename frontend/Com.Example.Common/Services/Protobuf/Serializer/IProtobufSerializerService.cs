using System;
using Google.Protobuf;

namespace Com.Example.Common.Network
{
    public interface IProtobufSerializerService
    {
        void RegisterSerializer(Type type, MessageParser parser);

        bool CanDeserialize(IMessage message);

        object Deserialize(byte[] messageBytes, Type type);
    }
}