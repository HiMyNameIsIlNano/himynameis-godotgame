using System;
using Grpc.Core;

namespace Com.Example.Common.Network.Grpc
{
    public static class GrpcChannelSingleton
    {
        private static readonly Lazy<Channel> GrpcChannel = new Lazy<Channel>(() =>
            new Channel("127.0.0.1:6565", ChannelCredentials.Insecure));

        public static Channel ChannelInstance => GrpcChannel.Value;

        public static Channel CloseAsync()
        {
            GrpcChannel.Value.ShutdownAsync().Wait();
            return GrpcChannel.Value;
        }
    }
}