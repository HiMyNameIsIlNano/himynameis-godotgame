using System;
using Grpc.Core;

namespace Com.Example.Common.Network.Grpc
{
    public static class MessageQueueGrpcChannelSingleton
    {
        private const string Address = "localhost";

        private const int Port = 6566;

        private static readonly Lazy<Channel> GrpcChannel = new Lazy<Channel>(() =>
            new Channel($"{Address}:{Port}", ChannelCredentials.Insecure));

        public static Channel ChannelInstance => GrpcChannel.Value;
        
    }
}