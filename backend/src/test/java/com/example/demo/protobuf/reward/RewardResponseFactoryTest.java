package com.example.demo.protobuf.reward;

import com.example.demo.BaseUnitTest;
import com.example.demo.domain.reward.CalculationResult;
import com.example.demo.protobuf.RewardProto.RewardDTO;
import com.example.demo.protobuf.RewardProto.RewardResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RewardResponseFactoryTest extends BaseUnitTest {

    private RewardResponseFactory rewardResponseFactory;

    @BeforeEach
    public void setUp() {
        rewardResponseFactory = new RewardResponseFactory();
    }

    @Test
    void expectNullPointerExceptionWhenNullRewards() {
        // noinspection ConstantConditions
        Assertions.assertThrows(
                NullPointerException.class,
                () -> rewardResponseFactory.toRewardResponseFromDTOs(null));
    }

    @Test
    void toEmptyRewardResponse() {
        final RewardResponse rewardResponse =
                rewardResponseFactory.toRewardResponseFromDTOs(List.of());
        Assertions.assertNotNull(rewardResponse);
        Assertions.assertEquals(0L, rewardResponse.getRewardsCount());
    }

    @Test
    void toSingleElementRewardResponse() {
        final RewardDTO rewardDTO =
                RewardDTO.newBuilder().setAmount(1).setRewardId("test_reward_id").build();

        final RewardResponse rewardResponse =
                rewardResponseFactory.toRewardResponseFromDTOs(List.of(rewardDTO));
        Assertions.assertNotNull(rewardResponse);
        Assertions.assertEquals(1L, rewardResponse.getRewardsCount());

        final RewardDTO rewardToTest = rewardResponse.getRewards(0);
        Assertions.assertEquals(1L, rewardToTest.getAmount());
        Assertions.assertEquals("test_reward_id", rewardToTest.getRewardId());
    }

    @Test
    void toRewardResponse() {
        final RewardDTO rewardDTO1 =
                RewardDTO.newBuilder().setAmount(1).setRewardId("test_reward_id1").build();

        final RewardDTO rewardDTO2 =
                RewardDTO.newBuilder().setAmount(1).setRewardId("test_reward_id2").build();

        final RewardResponse rewardResponse =
                rewardResponseFactory.toRewardResponseFromDTOs(List.of(rewardDTO1, rewardDTO2));
        Assertions.assertNotNull(rewardResponse);
        Assertions.assertEquals(2L, rewardResponse.getRewardsCount());

        final RewardDTO rewardToTest1 = rewardResponse.getRewards(0);
        Assertions.assertEquals(1L, rewardToTest1.getAmount());
        Assertions.assertEquals("test_reward_id1", rewardToTest1.getRewardId());

        final RewardDTO rewardToTest2 = rewardResponse.getRewards(1);
        Assertions.assertEquals(1L, rewardToTest2.getAmount());
        Assertions.assertEquals("test_reward_id2", rewardToTest2.getRewardId());
    }

    @Test
    void expectNullPointerExceptionWhenNullRewardId() {
        // noinspection ConstantConditions
        Assertions.assertThrows(
                NullPointerException.class, () -> rewardResponseFactory.toRewardDTO(null, 1));
    }

    @Test
    void toRewardDTO() {
        final RewardDTO rewardDTO = rewardResponseFactory.toRewardDTO("test_reward_id", 1);
        Assertions.assertNotNull(rewardDTO);
        Assertions.assertEquals(1L, rewardDTO.getAmount());
        Assertions.assertEquals("test_reward_id", rewardDTO.getRewardId());
    }

    @Test
    void expectNullPointerExceptionWhenNullRewardDTOList() {
        // noinspection ConstantConditions
        Assertions.assertThrows(
                NullPointerException.class,
                () -> rewardResponseFactory.toRewardResponseFromDTOs(null));
    }

    @Test
    void toSingleElementRewardDTOList() {
        final CalculationResult calculationResult =
                new CalculationResult("awarded.test_resource_1", 1);

        final RewardResponse rewardResponse =
                rewardResponseFactory.toRewardResponseFromCalculationResults(
                        List.of(calculationResult));
        Assertions.assertNotNull(rewardResponse);
        Assertions.assertNotNull(rewardResponse.getRewardsList());
        Assertions.assertEquals(1, rewardResponse.getRewardsList().size());

        final RewardDTO rewardDTO1 = rewardResponse.getRewardsList().get(0);
        Assertions.assertNotNull(rewardDTO1);
        Assertions.assertEquals("awarded.test_resource_1", rewardDTO1.getRewardId());
        Assertions.assertEquals(1, rewardDTO1.getAmount());
    }

    @Test
    void toRewardDTOList() {
        final CalculationResult calculationResult1 =
                new CalculationResult("awarded.test_resource_1", 1);
        final CalculationResult calculationResult2 =
                new CalculationResult("awarded.test_resource_2", 2);

        final RewardResponse rewardResponse =
                rewardResponseFactory.toRewardResponseFromCalculationResults(
                        List.of(calculationResult1, calculationResult2));
        Assertions.assertNotNull(rewardResponse);
        Assertions.assertNotNull(rewardResponse.getRewardsList());
        Assertions.assertEquals(2, rewardResponse.getRewardsList().size());

        final RewardDTO rewardDTO1 = rewardResponse.getRewardsList().get(0);
        Assertions.assertNotNull(rewardDTO1);
        Assertions.assertEquals("awarded.test_resource_1", rewardDTO1.getRewardId());
        Assertions.assertEquals(1, rewardDTO1.getAmount());

        final RewardDTO rewardDTO2 = rewardResponse.getRewardsList().get(1);
        Assertions.assertNotNull(rewardDTO2);
        Assertions.assertEquals("awarded.test_resource_2", rewardDTO2.getRewardId());
        Assertions.assertEquals(2, rewardDTO2.getAmount());
    }
}
