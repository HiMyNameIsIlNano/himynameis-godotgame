using System;
using Grpc.Core;

namespace Com.Example.Common.Network.Grpc
{
    public static class GrpcChannelSingleton
    {
        private const string Address = "localhost";
        
        private const int Port = 6566;
        
        private static readonly Lazy<Channel> GrpcChannel = new Lazy<Channel>(() =>
            new Channel($"{Address}:{Port}", ChannelCredentials.Insecure));

        public static Channel ChannelInstance => GrpcChannel.Value;

        public static Channel CloseAsync()
        {
            GrpcChannel.Value.ShutdownAsync().Wait();
            return GrpcChannel.Value;
        }
    }
}