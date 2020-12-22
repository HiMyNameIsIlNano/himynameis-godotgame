package com.example.demo.domain.reward.definition;

import com.example.demo.common.definition.BaseDefinition;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import java.util.ArrayList;
import java.util.List;

@DiscriminatorValue("rewards")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "assignable_resources"})
@EqualsAndHashCode(callSuper = true)
public class RewardDefinition extends BaseDefinition {

    @JsonProperty("assignable_resources")
    private List<AssignableResourceDefinition> assignableResources = new ArrayList<>();

    @JsonProperty("assignable_resources")
    public List<AssignableResourceDefinition> getAssignableResources() {
        return assignableResources;
    }

    @JsonProperty("assignable_resources")
    public void setAssignableResources(List<AssignableResourceDefinition> assignableResources) {
        this.assignableResources = assignableResources;
    }
}
