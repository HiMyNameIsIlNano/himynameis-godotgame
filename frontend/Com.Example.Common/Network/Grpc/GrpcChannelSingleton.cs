using System;
using Grpc.Core;

namespace Com.Example.Common.Network.Grpc
{
    public static class GrpcChannelSingleton
    {
        private static readonly Lazy<Channel> grpcChannel = new Lazy<Channel>(() =>
            new Channel("127.0.0.1:6565", ChannelCredentials.Insecure));

        public static Channel ChannelInstance => grpcChannel.Value;

        public static Channel CloseAsync()
        {
            grpcChannel.Value.ShutdownAsync().Wait();
            return grpcChannel.Value;
        }
    }
}