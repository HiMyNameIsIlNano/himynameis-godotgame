package com.example.demo.protobuf.planet.mission;

import com.example.demo.BaseUnitTest;
import com.example.demo.domain.planet.mission.definition.MissionDefinition;
import com.example.demo.protobuf.MissionProto.MissionDTO;
import com.example.demo.protobuf.MissionProto.MissionDTO.CategoryEnum;
import com.example.demo.protobuf.MissionProto.MissionListResponse;
import com.example.demo.protobuf.MissionProto.MissionResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class MissionResponseFactoryUnitTest extends BaseUnitTest {

    private MissionResponseFactory missionResponseFactory;

    @BeforeEach
    public void setUp() {
        missionResponseFactory = new MissionResponseFactory();
    }

    @Test
    void expectNullPointerExceptionWhenMissionDefinitionListIsNull() {
        // noinspection ConstantConditions
        Assertions.assertThrows(
                NullPointerException.class,
                () -> missionResponseFactory.toMissionListResponse(null));
    }

    @Test
    void expectNullPointerExceptionWhenMissionIsNull() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> missionResponseFactory.toMissionListResponse(List.of(null)));
    }

    @Test
    void toEmptyMissionResponseList() {
        final MissionListResponse missionListResponse =
                missionResponseFactory.toMissionListResponse(Collections.emptyList());

        Assertions.assertNotNull(missionListResponse);
        Assertions.assertEquals(0L, missionListResponse.getMissionsCount());
    }

    @Test
    void toOneElementMissionResponseList() {
        final MissionDefinition missionDefinition = new MissionDefinition();
        missionDefinition.setId("test_id");
        missionDefinition.setCategory(CategoryEnum.BASIC);

        final MissionListResponse missionListResponse =
                missionResponseFactory.toMissionListResponse(
                        Collections.singletonList(missionDefinition));

        Assertions.assertNotNull(missionListResponse);
        Assertions.assertEquals(1L, missionListResponse.getMissionsCount());

        final MissionDTO missionToTest = missionListResponse.getMissions(0);
        Assertions.assertEquals("test_id", missionToTest.getId());
        Assertions.assertEquals(CategoryEnum.BASIC, missionToTest.getCategory());
    }

    @Test
    public void toNullMissionResponse() {
        // noinspection ConstantConditions
        Assertions.assertThrows(
                NullPointerException.class, () -> missionResponseFactory.toMissionResponse(null));
    }

    @Test
    public void toMissionResponse() {
        final MissionDefinition missionDefinition = new MissionDefinition();
        missionDefinition.setId("test_id");
        missionDefinition.setCategory(CategoryEnum.BASIC);

        final MissionResponse missionResponse =
                missionResponseFactory.toMissionResponse(missionDefinition);
        Assertions.assertNotNull(missionResponse);

        final MissionDTO missionToTest = missionResponse.getMission();
        Assertions.assertEquals("test_id", missionToTest.getId());
        Assertions.assertEquals(CategoryEnum.BASIC, missionToTest.getCategory());
    }
}
