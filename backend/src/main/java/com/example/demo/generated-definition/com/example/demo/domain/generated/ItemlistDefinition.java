
package com.example.demo.domain.generated;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@context",
    "@type",
    "itemListElement",
    "numberOfItems"
})
public class ItemlistDefinition {

    @JsonProperty("@context")
    private String context;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("itemListElement")
    private List<ItemListElementDefinition> itemListElement = new ArrayList<ItemListElementDefinition>();
    @JsonProperty("numberOfItems")
    private Integer numberOfItems;

    @JsonProperty("@context")
    public String getContext() {
        return context;
    }

    @JsonProperty("@context")
    public void setContext(String context) {
        this.context = context;
    }

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    @JsonProperty("@type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("itemListElement")
    public List<ItemListElementDefinition> getItemListElement() {
        return itemListElement;
    }

    @JsonProperty("itemListElement")
    public void setItemListElement(List<ItemListElementDefinition> itemListElement) {
        this.itemListElement = itemListElement;
    }

    @JsonProperty("numberOfItems")
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    @JsonProperty("numberOfItems")
    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.context == null)? 0 :this.context.hashCode()));
        result = ((result* 31)+((this.itemListElement == null)? 0 :this.itemListElement.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.numberOfItems == null)? 0 :this.numberOfItems.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemlistDefinition) == false) {
            return false;
        }
        ItemlistDefinition rhs = ((ItemlistDefinition) other);
        return (((((this.context == rhs.context)||((this.context!= null)&&this.context.equals(rhs.context)))&&((this.itemListElement == rhs.itemListElement)||((this.itemListElement!= null)&&this.itemListElement.equals(rhs.itemListElement))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.numberOfItems == rhs.numberOfItems)||((this.numberOfItems!= null)&&this.numberOfItems.equals(rhs.numberOfItems))));
    }

}
