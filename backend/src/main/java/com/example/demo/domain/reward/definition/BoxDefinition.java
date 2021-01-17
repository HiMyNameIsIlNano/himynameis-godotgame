package com.example.demo.domain.reward.definition;

import com.example.demo.common.definition.BaseDefinition;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("boxes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "boxType", "factor"})
@EqualsAndHashCode(callSuper = true)
public class BoxDefinition extends BaseDefinition {

    @JsonProperty("boxType")
    private String boxType;

    @JsonProperty("factor")
    private Integer factor;

    @JsonProperty("boxType")
    public String getBoxType() {
        return boxType;
    }

    @JsonProperty("boxType")
    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    @JsonProperty("factor")
    public Integer getFactor() {
        return factor;
    }

    @JsonProperty("factor")
    public void setFactor(Integer factor) {
        this.factor = factor;
    }
}
