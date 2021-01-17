package com.example.demo.domain.planet.mission;

import com.example.demo.common.DefinitionLoaderService;
import com.example.demo.common.definition.AbstractDefinitionLoader;
import com.example.demo.domain.planet.mission.definition.MissionDefinition;
import com.example.demo.domain.planet.mission.definition.MissionDefinitionList;

@DefinitionLoaderService(forDefinition = MissionDefinition.class)
public class MissionDefinitionLoader
        extends AbstractDefinitionLoader<MissionDefinition, MissionDefinitionList> {

    public MissionDefinitionLoader() {
        super(MissionDefinition.class, MissionDefinitionList.class);
    }
}
