package com.example.demo.domain.planet.mission.definition;

import com.example.demo.common.definition.BaseDefinition;
import com.example.demo.protobuf.MissionProto.MissionDTO.CategoryEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("missions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "category"})
@EqualsAndHashCode(callSuper = true)
public class MissionDefinition extends BaseDefinition {

    @JsonProperty("category")
    private CategoryEnum category;

    @JsonProperty("category")
    public CategoryEnum getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
