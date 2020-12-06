using System;
using Grpc.Core;

namespace Com.Example.Common.Network.Grpc
{
    public static class BackEndQueueGrpcChannelSingleton
    {
        #if LOCAL
            private const string Address = "localhost";
            private const int Port = 6565;
        #elif REMOTE
            private const string Address = "https://some.url.com";
            private const int Port = 6565;
        #endif

        private static readonly Lazy<Channel> GrpcChannel = new Lazy<Channel>(() =>
            new Channel($"{Address}:{Port}", ChannelCredentials.Insecure));

        public static Channel ChannelInstance => GrpcChannel.Value;
        
    }
}