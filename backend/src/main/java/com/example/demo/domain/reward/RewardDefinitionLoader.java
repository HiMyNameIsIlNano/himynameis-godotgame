package com.example.demo.domain.reward;

import com.example.demo.common.DefinitionLoaderService;
import com.example.demo.common.definition.AbstractDefinitionLoader;
import com.example.demo.domain.reward.definition.RewardDefinition;
import com.example.demo.domain.reward.definition.RewardDefinitionList;

@DefinitionLoaderService(forDefinition = RewardDefinition.class)
public class RewardDefinitionLoader
        extends AbstractDefinitionLoader<RewardDefinition, RewardDefinitionList> {

    public RewardDefinitionLoader() {
        super(RewardDefinition.class, RewardDefinitionList.class);
    }
}
