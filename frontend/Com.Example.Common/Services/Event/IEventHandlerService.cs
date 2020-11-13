using System.Collections.Generic;
using System.ComponentModel;
using Com.Example.Common.VO.MessageQueue;

namespace Com.Example.Common.Services.Event
{
    public interface IEventHandlerService
    {
        void HandleGameEvent(List<RewardVO> rewardVos);
    }
}