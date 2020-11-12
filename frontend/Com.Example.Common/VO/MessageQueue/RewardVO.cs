using System.Collections.Generic;
using System.Linq;
using Com.Example.Common.Network.Protobuf.Reward;

namespace Com.Example.Common.VO.MessageQueue
{
    public class RewardVO
    {
        public string RewardId { get; set; }

        public int Amount { get; set; }
        
        public static List<RewardVO> FromRewardResponse(RewardResponse response)
        {
            return response.Rewards
                .Select(dto => new RewardVO
                {
                    RewardId = dto.RewardId,
                    Amount = dto.Amount
                }).ToList();
        }
    }
}