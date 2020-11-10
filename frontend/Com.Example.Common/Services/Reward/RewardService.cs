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

        private readonly RewardServiceClient _rewardServiceClient;

        public RewardService(IBackEndGrpcChannelService backEndGrpcChannelService)
        {
            _backEndGrpcChannelService = backEndGrpcChannelService;
            _rewardServiceClient = new RewardServiceClient(_backEndGrpcChannelService.OpenOrGet());
        }

        public async Task<RewardResponse> GetRewardOnBoxFilledAsync(int level, BoxType boxType)
        {
            RewardResponse rewardResponse =
                await _rewardServiceClient.GetRewardsOnGoalAsync(new RewardRequest {Level = level, BoxType = boxType});
            return rewardResponse;
        }

        public RewardResponse GetRewardOnBoxFilled(int level, BoxType boxType)
        {
            return _rewardServiceClient.GetRewardsOnGoal(new RewardRequest {Level = level, BoxType = boxType});
        }

        public async Task<RewardResponse> GenerateRandomEventOnLevelCleared(int level)
        {
            RewardResponse rewardResponse =
                await _rewardServiceClient.GetRewardsOnLevelClearedAsync(new RewardRequest {Level = level});
            return rewardResponse;
        }
    }
}