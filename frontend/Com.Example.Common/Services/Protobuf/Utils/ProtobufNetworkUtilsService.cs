using System;
using System.Net;
using Google.Protobuf;
using Google.Protobuf.Reflection;
using Google.Protobuf.WellKnownTypes;

namespace Com.Example.Common.Services.Protobuf.Utils
{
    public class ProtobufNetworkUtilsService : IProtobufNetworkUtilsService
    {
        public T UnpackResponse<T>(Any message, MessageDescriptor descriptor) where T : IMessage, new()
        {
            try
            {
                return message.Is(descriptor) ? message.Unpack<T>() : default;
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException)
            {
                Console.WriteLine(invalidProtocolBufferException);
                throw;
            }
        }
    }
}