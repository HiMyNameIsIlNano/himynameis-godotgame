package com.example.demo.common.definition;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "definitions"})
public class BaseDefinitionList<T> {

    @JsonProperty("id")
    private String id;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("definitions")
    private Collection<T> definitions = new ArrayList<>();

    @JsonProperty("definitions")
    public Collection<T> getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void addDefinitions(Collection<T> definitions) {
        this.definitions.addAll(definitions);
    }

    public BaseDefinitionList(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof BaseDefinitionList)) {
            return false;
        }

        return Objects.equals(this, other);
    }
}
