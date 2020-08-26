﻿using System;
using System.Threading.Tasks;
using Com.Example.Common.Services.Protobuf;
using Google.Protobuf.WellKnownTypes;
using static SocketServerGrpcService;

namespace Com.Example.Common.Services.Socket
{
    public class SocketServerService : ISocketServerService
    {
        private readonly IGrpcChannelService _grpcChannelService;

        public SocketServerService(IGrpcChannelService grpcChannelService)
        {
            _grpcChannelService = grpcChannelService;
        }

        public async Task ClientCanConnectToServer()
        {
            Console.WriteLine("Signaling the Back End can connect to Server");
            SocketServerGrpcServiceClient client = new SocketServerGrpcServiceClient(_grpcChannelService.OpenOrGet());
            await client.ConnectToServerAsync(new Empty());
        }
    }
}