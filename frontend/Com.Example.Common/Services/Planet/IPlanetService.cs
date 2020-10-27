using System.Threading.Tasks;
using Com.Example.Common.Network.Protobuf.Planet;

namespace Com.Example.Common.Services.Planet
{
    public interface IPlanetService
    {
        Task<PlanetResearchResponse> GetAllMissions();
    }
}