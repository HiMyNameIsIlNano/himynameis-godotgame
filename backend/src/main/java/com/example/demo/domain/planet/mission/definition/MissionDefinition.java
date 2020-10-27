package com.example.demo.domain.planet.mission.definition;

import com.example.demo.common.definition.BaseDefinition;
import com.example.demo.domain.planet.mission.model.Mission;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;

/** The definition of an {@link Mission}. See missions.json */
@DiscriminatorValue("missions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "category"})
public class MissionDefinition extends BaseDefinition {

    @JsonProperty("category")
    private String category;

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MissionDefinition)) {
            return false;
        }
        return Objects.equals(this, other);
    }
}
