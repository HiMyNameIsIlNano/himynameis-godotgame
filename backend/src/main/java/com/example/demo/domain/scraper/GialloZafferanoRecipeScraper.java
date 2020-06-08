package com.example.demo.domain.scraper;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class GialloZafferanoRecipeScraper implements RecipeScraper<ItemList> {

	private static final String BASE_URL = "https://www.giallozafferano.it/ricerca-ricette/page%d/%s";

	@Override
	public ItemList extractSearchResult(String text, int pageIndex) throws IOException {
		List<String> itemList = getResultList(text, pageIndex);
		validateResult(itemList);
		return toItemList(itemList);
	}

	private List<String> getResultList(String text, int pageIndex) throws IOException {
		String urlWithParameters = String.format(BASE_URL, pageIndex, text);
		return Jsoup.connect(urlWithParameters).get()
			.select("script[type^=\"application/ld+json\"]").stream()
			.map(Element::html)
			.filter(element -> element.contains("\"@type\":\"ItemList\""))
			.collect(Collectors.toList());
	}

	private void validateResult(List<String> itemList) {
		if (itemList.isEmpty()) {
			throw new IllegalArgumentException("Found no result of type ItemList");
		}

		if (itemList.size() > 1) {
			throw new IllegalArgumentException("Found more than result of type ItemList");
		}
	}

	private ItemList toItemList(List<String> itemList) {
		return itemList.stream()
			.map(this::toJson)
			.findFirst()
			.orElseThrow();
	}

	private ItemList toJson(String item) {
		try {
			return new ObjectMapper().readValue(item, ItemList.class);
		} catch (IOException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
