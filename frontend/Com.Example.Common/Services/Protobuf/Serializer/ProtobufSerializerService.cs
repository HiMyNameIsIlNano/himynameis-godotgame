using System;
using System.Collections.Concurrent;
using Google.Protobuf;

namespace Com.Example.Common.Network.Protobuf.Serializer
{
    public class ProtobufSerializerService : IProtobufSerializerService
    {
        private readonly ConcurrentDictionary<Type, MessageParser> parsers;

        public ProtobufSerializerService()
        {
            parsers = new ConcurrentDictionary<Type, MessageParser>();
        }

        public void RegisterSerializer(Type type, MessageParser parser)
        {
            if (!parsers.ContainsKey(type))
            {
                parsers.TryAdd(type, parser);
            }
        }

        public bool CanDeserialize(IMessage message)
        {
            Type type = message.GetType();
            return parsers.ContainsKey(type);
        }

        public object Deserialize(byte[] messageBytes, Type type)
        {
            if (!parsers.TryGetValue(type, out var parser))
            {
                throw new ArgumentException($"No parser found for the expected {type}");
            }

            return parser.ParseFrom(messageBytes);
        }
    }
}