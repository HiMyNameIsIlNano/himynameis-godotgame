using Com.Example.Common.Network.Protobuf.Mission;

namespace Com.Example.Common.Services.Reward
{
    public interface IRewardService
    {
        RewardResponse GetRewardOnBoxFilled();

        void GenerateRandomEventOnLevelCleared();
    }
}