﻿using System;
using System.Collections.Generic;
using Com.Example.Common.VO.MessageQueue;

namespace Com.Example.Common.Services.Event
{
    public class EventHandlerService : IEventHandlerService
    {
        public void HandleGameEvent(List<RewardVO> rewardVos)
        {
            rewardVos.ForEach(vo => Console.WriteLine($"VO: {vo.RewardId}, {vo.Amount}"));
        }
    }
}