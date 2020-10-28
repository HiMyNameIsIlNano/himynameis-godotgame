using System;
using Com.Example.Common.Attributes;
using Com.Example.Common.Network;
using Com.Example.Common.Network.Protobuf.Mission;
using Com.Example.Game.Scripts.GameStartup;
using Godot;

namespace Com.Example.Game.Scripts.GameAutoload
{
    public class ProtobufSerializerRegistrationAutoload : Node
    {
        [InjectedProperty] private IProtobufSerializerService ProtobufSerializerService { get; set; }

        public override void _Ready()
        {
            Console.WriteLine("Connecting to Messageq");
            InjectedPropertyResolver.Resolve(this);

            RegisterProtobufParsers();
        }

        private void RegisterProtobufParsers()
        {
            ProtobufSerializerService.RegisterSerializer(typeof(RewardResponse), RewardResponse.Parser);
        }
    }
}