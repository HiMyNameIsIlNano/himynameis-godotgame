using System.Threading.Tasks;
using Com.Example.Common.Network.Protobuf.Planet;
using Com.Example.Common.Network.Protobuf.Planet.Grpc;
using Com.Example.Common.Services.Protobuf.Grpc.Backend;
using Google.Protobuf.WellKnownTypes;

namespace Com.Example.Common.Services.Planet
{
    class PlanetService : IPlanetService
    {
        private readonly IBackEndGrpcChannelService _backEndGrpcChannelService;

        public PlanetService(IBackEndGrpcChannelService backEndGrpcChannelService)
        {
            _backEndGrpcChannelService = backEndGrpcChannelService;
        }

        public async Task<PlanetResearchResponse> GetAllMissions()
        {
            PlanetGrpcService.PlanetGrpcServiceClient client =
                new PlanetGrpcService.PlanetGrpcServiceClient(_backEndGrpcChannelService.OpenOrGet());
            PlanetResearchResponse researchResponse = await client.FindAllAsync(new Empty());
            return researchResponse;
        }
    }
}