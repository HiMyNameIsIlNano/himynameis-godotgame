﻿using Com.Example.Common.Network.Grpc;
using Grpc.Core;

namespace Com.Example.Common.Services.Protobuf.Grpc.Backend
{
    public class BackEndGrpcChannelService : IBackEndGrpcChannelService
    {
        public Channel OpenOrGet()
        {
            return BackEndQueueGrpcChannelSingleton.ChannelInstance;
        }

        public Channel CloseAsync()
        {
            Channel channelInstance = BackEndQueueGrpcChannelSingleton.ChannelInstance;
            channelInstance.ShutdownAsync().Wait();
            return channelInstance;
        }
    }
}