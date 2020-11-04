using System.Threading.Tasks;
using Com.Example.Common.Network.Protobuf.Planet;
using Com.Example.Common.Services.Protobuf.Grpc.Backend;
using Google.Protobuf.WellKnownTypes;
using static Com.Example.Common.Network.Protobuf.Planet.Grpc.PlanetService;

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
            PlanetServiceClient client = new PlanetServiceClient(_backEndGrpcChannelService.OpenOrGet());
            PlanetResearchResponse researchResponse = await client.FindAllAsync(new Empty());
            return researchResponse;
        }
    }
}