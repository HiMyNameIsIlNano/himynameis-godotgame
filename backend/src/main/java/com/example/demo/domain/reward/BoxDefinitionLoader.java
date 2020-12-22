package com.example.demo.domain.reward;

import com.example.demo.common.DefinitionLoaderService;
import com.example.demo.common.definition.AbstractDefinitionLoader;
import com.example.demo.domain.reward.definition.BoxDefinition;
import com.example.demo.domain.reward.definition.BoxDefinitionList;

@DefinitionLoaderService(forDefinition = BoxDefinition.class)
public class BoxDefinitionLoader
        extends AbstractDefinitionLoader<BoxDefinition, BoxDefinitionList> {

    public BoxDefinitionLoader() {
        super(BoxDefinition.class, BoxDefinitionList.class);
    }
}
