using System.Threading.Tasks;
using Com.Example.Common.Network.Protobuf.Reward;
using Com.Example.Common.Services.Protobuf.Grpc.Backend;
using static Com.Example.Common.Network.Protobuf.Reward.Grpc.RewardService;
using static Com.Example.Common.Network.Protobuf.Reward.RewardRequest.Types;

namespace Com.Example.Common.Services.Reward
{
    class RewardService : IRewardService
    {
        private readonly IBackEndGrpcChannelService _backEndGrpcChannelService;

        public RewardService(IBackEndGrpcChannelService backEndGrpcChannelService)
        {
            _backEndGrpcChannelService = backEndGrpcChannelService;
        }

        public async Task<RewardResponse> GetRewardOnBoxFilled(int level, BoxType boxType)
        {
            RewardServiceClient client = new RewardServiceClient(_backEndGrpcChannelService.OpenOrGet());
            RewardResponse rewardResponse =
                await client.GetRewardsOnGoalAsync(new RewardRequest {Level = level, BoxType = boxType});
            return rewardResponse;
        }

        public async Task<RewardResponse> GenerateRandomEventOnLevelCleared(int level)
        {
            RewardServiceClient client = new RewardServiceClient(_backEndGrpcChannelService.OpenOrGet());
            RewardResponse rewardResponse =
                await client.GetRewardsOnLevelClearedAsync(new RewardRequest {Level = level});
            return rewardResponse;
        }
    }
}