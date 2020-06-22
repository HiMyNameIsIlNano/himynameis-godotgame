package com.example.demo.domain.scraper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"@context", "@type", "itemListElement", "numberOfItems"})
public class ItemList {

    @JsonProperty("@context")
    private String context;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("itemListElement")
    private List<ListItem> itemListElement = new ArrayList<>();

    @JsonProperty("numberOfItems")
    private Integer numberOfItems;

    @JsonProperty("@context")
    public String getContext() {
        return context;
    }

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    @JsonProperty("itemListElement")
    public List<ListItem> getItemListElement() {
        return itemListElement;
    }

    @JsonProperty("itemListElement")
    public void setItemListElement(List<ListItem> itemListElement) {
        this.itemListElement = itemListElement;
    }

    @JsonProperty("numberOfItems")
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public Integer totalPages;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.context == null) ? 0 : this.context.hashCode()));
        result =
                ((result * 31)
                        + ((this.itemListElement == null) ? 0 : this.itemListElement.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result =
                ((result * 31)
                        + ((this.numberOfItems == null) ? 0 : this.numberOfItems.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemList) == false) {
            return false;
        }
        ItemList rhs = ((ItemList) other);
        return (((((this.context == rhs.context)
                                        || ((this.context != null)
                                                && this.context.equals(rhs.context)))
                                && ((this.itemListElement == rhs.itemListElement)
                                        || ((this.itemListElement != null)
                                                && this.itemListElement.equals(
                                                        rhs.itemListElement))))
                        && ((this.type == rhs.type)
                                || ((this.type != null) && this.type.equals(rhs.type))))
                && ((this.numberOfItems == rhs.numberOfItems)
                        || ((this.numberOfItems != null)
                                && this.numberOfItems.equals(rhs.numberOfItems))));
    }
}
