using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Com.Example.Common.Network.Protobuf.Mission;
using Com.Example.Common.Network.Protobuf.Reward;
using Com.Example.Common.VO.MessageQueue;
using static Com.Example.Common.Network.Protobuf.Reward.RewardRequest.Types;

namespace Com.Example.Common.Services.Reward
{
    public interface IRewardService
    {
        Task<RewardResponse> GetRewardOnBoxFilledAsync(int level, BoxType boxType);
        
        RewardResponse GetRewardOnBoxFilled(int level, BoxType boxType);

        Task<RewardResponse> GenerateRandomEventOnLevelCleared(int level);

        ImmutableList<RewardVO> GetRewardFromQueueForPlayer(int playerId);
    }
}