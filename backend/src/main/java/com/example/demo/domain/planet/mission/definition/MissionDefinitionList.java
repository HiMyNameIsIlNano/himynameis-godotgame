package com.example.demo.domain.planet.mission.definition;

import com.example.demo.common.definition.BaseDefinitionList;
import lombok.NoArgsConstructor;

/**
 * A wrapper class to be able to serialize/desirialize objects of type {@link MissionDefinition} in
 * an easier way.
 */
@NoArgsConstructor
public class MissionDefinitionList extends BaseDefinitionList<MissionDefinition> {}
