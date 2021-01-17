package com.example.demo.domain.reward;

import com.example.demo.BaseUnitTest;
import com.example.demo.domain.reward.definition.BoxDefinition;
import com.example.demo.domain.reward.definition.RewardDefinition;
import com.example.demo.protobuf.RewardProto.RewardRequest.BoxType;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

class RewardServiceUnitTest extends BaseUnitTest {

    private RewardService rewardService;

    @Mock private ApplicationEventPublisher applicationEventPublisher;

    @Mock private RewardDefinitionLoader rewardDefinitionLoader;

    @Mock private BoxDefinitionLoader boxDefinitionLoader;

    private static Stream<Arguments> generateRewardsDtoOnRedBoxOccupiedData() {
        return Stream.of(arguments(1, -2), arguments(2, -2), arguments(3, -4), arguments(4, -4));
    }

    private static Stream<Arguments> generateRewardsDtoOnGreenBoxOccupiedData() {
        return Stream.of(arguments(1, 2), arguments(2, 2), arguments(3, 4), arguments(4, 4));
    }

    private static Stream<Arguments> generateRewardsDtoOnBlueBoxOccupiedData() {
        return Stream.of(arguments(1, 4), arguments(2, 4), arguments(3, 8), arguments(4, 8));
    }

    private static Stream<Arguments> generateRewardDtoOnLevelClearedData() {
        return Stream.of(arguments(1, 1), arguments(2, 2), arguments(3, 6), arguments(4, 8));
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        rewardService =
                new RewardService(
                        applicationEventPublisher, rewardDefinitionLoader, boxDefinitionLoader);
    }

    @ParameterizedTest
    @MethodSource("generateRewardsDtoOnRedBoxOccupiedData")
    void generateRewardsDtoOnRedBoxOccupied(int level, int expectedAmount) {
        final BoxDefinition redBoxDefinition = getRedBoxDefinition();
        mockLoadBoxDefinitionByFunction(redBoxDefinition);
        mockRewardForOccupiedBox(redBoxDefinition);

        Collection<CalculationResult> calculationResult =
                rewardService.generateRewardsDtoOnBoxOccupied(BoxType.RED, level);

        assertNotNull(calculationResult);
        assertEquals(1L, calculationResult.size());
        final CalculationResult calculationResultToTest = new ArrayList<>(calculationResult).get(0);
        assertEquals("resource.coins.silver", calculationResultToTest.resourceId());
        assertEquals(expectedAmount, calculationResultToTest.amount());
    }

    @NotNull
    private BoxDefinition getRedBoxDefinition() {
        return RewardTestDataHelper.getBoxDefinition("box.red", BoxType.RED, -1);
    }

    private void mockLoadBoxDefinitionByFunction(final BoxDefinition boxDefinition) {
        when(boxDefinitionLoader.loadByFunction(any())).thenReturn(boxDefinition);
    }

    private void mockRewardForOccupiedBox(BoxDefinition boxDefinition) {
        final RewardDefinition rewardDefinition =
                RewardTestDataHelper.getRewardDefinitionForOccupiedBox(boxDefinition);

        when(rewardDefinitionLoader.loadById(anyString())).thenReturn(rewardDefinition);
    }

    @ParameterizedTest
    @MethodSource("generateRewardsDtoOnBlueBoxOccupiedData")
    void generateRewardsDtoOnBlueBoxOccupied(final int level, final int expectedAmount) {
        final BoxDefinition blueBoxDefinition = getBlueBoxDefinition();
        mockLoadBoxDefinitionByFunction(blueBoxDefinition);
        mockRewardForOccupiedBox(blueBoxDefinition);

        Collection<CalculationResult> calculationResult =
                rewardService.generateRewardsDtoOnBoxOccupied(BoxType.BLUE, level);

        assertNotNull(calculationResult);
        assertEquals(1L, calculationResult.size());

        final CalculationResult calculationResultToTest = new ArrayList<>(calculationResult).get(0);
        assertEquals("resource.coins.silver", calculationResultToTest.resourceId());
        assertEquals(expectedAmount, calculationResultToTest.amount());
    }

    @NotNull
    private BoxDefinition getBlueBoxDefinition() {
        return RewardTestDataHelper.getBoxDefinition("box.blue", BoxType.BLUE, 2);
    }

    @ParameterizedTest
    @MethodSource("generateRewardsDtoOnGreenBoxOccupiedData")
    void generateRewardsDtoOnGreenBoxOccupied(final int level, final int expectedAmount) {
        final BoxDefinition greenBoxDefinition = getGreenBoxDefinition();
        mockLoadBoxDefinitionByFunction(greenBoxDefinition);
        mockRewardForOccupiedBox(greenBoxDefinition);

        Collection<CalculationResult> calculationResult =
                rewardService.generateRewardsDtoOnBoxOccupied(BoxType.GREEN, level);

        assertNotNull(calculationResult);
        assertEquals(1L, calculationResult.size());
        final CalculationResult calculationResultToTest = new ArrayList<>(calculationResult).get(0);
        assertEquals("resource.coins.silver", calculationResultToTest.resourceId());
        assertEquals(expectedAmount, calculationResultToTest.amount());
    }

    @NotNull
    private BoxDefinition getGreenBoxDefinition() {
        return RewardTestDataHelper.getBoxDefinition("box.green", BoxType.GREEN, 1);
    }

    @ParameterizedTest
    @MethodSource("generateRewardDtoOnLevelClearedData")
    void generateRewardDtoOnLevelCleared(final int level, final int expectedAmount) {
        mockRewardForLevelCleared();

        final Collection<CalculationResult> calculationResult =
                rewardService.generateRewardDtoOnLevelCleared(level);

        assertNotNull(calculationResult);
        assertEquals(1L, calculationResult.size());
        final CalculationResult calculationResultToTest = new ArrayList<>(calculationResult).get(0);
        assertEquals("resource.coins.silver", calculationResultToTest.resourceId());
        assertEquals(expectedAmount, calculationResultToTest.amount());
    }

    private void mockRewardForLevelCleared() {
        final RewardDefinition rewardDefinition = RewardTestDataHelper.getRewardDefinition();

        when(rewardDefinitionLoader.loadById(anyString())).thenReturn(rewardDefinition);
    }
}
