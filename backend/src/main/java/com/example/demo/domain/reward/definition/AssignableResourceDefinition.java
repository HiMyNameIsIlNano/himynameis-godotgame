package com.example.demo.domain.reward.definition;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("assignable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "from_level_greater_or_equal_to",
    "to_level_smaller_or_equal_to",
    "awarded_resource_id",
    "for_object_id",
    "amount",
})
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class AssignableResourceDefinition {

    @JsonProperty("from_level_greater_or_equal_to")
    private Integer fromLevelGreaterOrEqualTo;

    @JsonProperty("to_level_smaller_or_equal_to")
    private Integer toLevelSmallerOrEqualTo;

    @JsonProperty("awarded_resource_id")
    private String awardedResourceId;

    @JsonProperty("for_object_id")
    private String forObjectId;

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("from_level_greater_or_equal_to")
    public Integer getFromLevelGreaterOrEqualTo() {
        return fromLevelGreaterOrEqualTo;
    }

    @JsonProperty("from_level_greater_or_equal_to")
    public void setFromLevelGreaterOrEqualTo(Integer fromLevelGreaterOrEqualTo) {
        this.fromLevelGreaterOrEqualTo = fromLevelGreaterOrEqualTo;
    }

    @JsonProperty("to_level_smaller_or_equal_to")
    public Integer getToLevelSmallerOrEqualTo() {
        return toLevelSmallerOrEqualTo;
    }

    @JsonProperty("to_level_smaller_or_equal_to")
    public void setToLevelSmallerOrEqualTo(Integer toLevelSmallerOrEqualTo) {
        this.toLevelSmallerOrEqualTo = toLevelSmallerOrEqualTo;
    }

    @JsonProperty("awarded_resource_id")
    public String getAwardedResourceId() {
        return awardedResourceId;
    }

    @JsonProperty("awarded_resource_id")
    public void setAwardedResourceId(String awardedResourceId) {
        this.awardedResourceId = awardedResourceId;
    }

    @JsonProperty("for_object_id")
    public String getForObjectId() {
        return forObjectId;
    }

    @JsonProperty("for_object_id")
    public void setForObjectId(String forObjectId) {
        this.forObjectId = forObjectId;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
