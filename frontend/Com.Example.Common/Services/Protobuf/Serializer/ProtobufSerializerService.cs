using System;
using System.Collections.Concurrent;
using Com.Example.Common.Network;
using Google.Protobuf;

namespace Com.Example.Common.Services.Protobuf.Serializer
{
    public class ProtobufSerializerService : IProtobufSerializerService
    {
        private readonly ConcurrentDictionary<Type, MessageParser> _parsers;

        public ProtobufSerializerService()
        {
            _parsers = new ConcurrentDictionary<Type, MessageParser>();
        }

        public void RegisterSerializer(Type type, MessageParser parser)
        {
            if (!_parsers.ContainsKey(type))
            {
                _parsers.TryAdd(type, parser);
            }
        }

        public bool CanDeserialize(IMessage message)
        {
            Type type = message.GetType();
            return _parsers.ContainsKey(type);
        }

        public object Deserialize(byte[] messageBytes, Type type)
        {
            if (!_parsers.TryGetValue(type, out var parser))
            {
                throw new ArgumentException($"No parser found for the expected {type}");
            }

            return parser.ParseFrom(messageBytes);
        }
    }
}