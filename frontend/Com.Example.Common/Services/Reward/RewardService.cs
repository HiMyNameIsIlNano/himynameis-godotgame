using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Com.Example.Common.Network;
using Com.Example.Common.Network.Exchange;
using Com.Example.Common.Network.Protobuf.Reward;
using Com.Example.Common.Services.Messageq.Api;
using Com.Example.Common.Services.Messageq.Startup;
using Com.Example.Common.Services.Protobuf.Grpc.Backend;
using Com.Example.Common.Services.Protobuf.Utils;
using Com.Example.Common.VO.MessageQueue;
using static Com.Example.Common.Network.Protobuf.Reward.Grpc.RewardService;
using static Com.Example.Common.Network.Protobuf.Reward.RewardRequest.Types;

namespace Com.Example.Common.Services.Reward
{
    class RewardService : IRewardService
    {
        private readonly IBackEndGrpcChannelService _backEndGrpcChannelService;

        private readonly IMessageQueueApiService _messageQueueApiService;

        private readonly IMessageQueueConnectionService _messageQueueConnectionService;

        private readonly IProtobufNetworkUtilsService _protobufNetworkUtilsService;

        private readonly RewardServiceClient _rewardServiceClient;

        public RewardService(IBackEndGrpcChannelService backEndGrpcChannelService,
            IMessageQueueApiService messageQueueApiService,
            IMessageQueueConnectionService messageQueueConnectionService,
            IProtobufNetworkUtilsService protobufNetworkUtilsService)
        {
            _backEndGrpcChannelService = backEndGrpcChannelService;
            _messageQueueApiService = messageQueueApiService;
            _messageQueueConnectionService = messageQueueConnectionService;
            _protobufNetworkUtilsService = protobufNetworkUtilsService;
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

        public List<RewardVO> GetRewardFromQueueForPlayer(int playerId)
        {
            QueueDetailsWrapper queueDetailsWrapper = QueueDetailsWrapper.__Rewards;
            string playerQueueName = queueDetailsWrapper.PlayerQueueName(playerId);
            QueueMessage queueMessage = _messageQueueApiService.PopMessage(playerQueueName);
            RewardResponse rewardResponse =
                _protobufNetworkUtilsService.UnpackResponse<RewardResponse>(queueMessage.Message,
                    RewardResponse.Descriptor);
            return RewardVO.FromRewardResponse(rewardResponse);
        }
    }
}