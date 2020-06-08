
package com.example.demo.domain.scraper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"@type",
	"position",
	"url"
})
public class ListItem {

	@JsonProperty("@type")
	private String type;

	@JsonProperty("position")
	private Integer position;

	@JsonProperty("url")
	private String url;

	@JsonProperty("@type")
	public String getType() {
		return type;
	}

	@JsonProperty("position")
	public Integer getPosition() {
		return position;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = ((result * 31) + ((this.position == null) ? 0 : this.position.hashCode()));
		result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
		result = ((result * 31) + ((this.url == null) ? 0 : this.url.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ListItem) == false) {
			return false;
		}
		ListItem rhs = ((ListItem) other);
		return ((((this.position == rhs.position) || ((this.position != null) && this.position.equals(rhs.position))) && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type)))) && ((this.url == rhs.url) || ((this.url != null) && this.url.equals(rhs.url))));
	}

}
