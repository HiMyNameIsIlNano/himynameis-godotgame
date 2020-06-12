package com.example.demo.domain.scraper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class GialloZafferanoRecipeService implements RecipeScraper<ItemList> {

    private static final String BASE_URL = "https://www.giallozafferano.it/ricerca-ricette/page%d/%s";

    @Override
    public ItemList extractSearchResult(String text, int pageIndex) throws IOException {
        Document httpDocument = getHttpDocument(text, pageIndex);
        return getRecipeListFromHttpDocument(httpDocument);
    }

    private int getTotalPages(Document httpDocument) {
        Element totalPagesElement = httpDocument.selectFirst("span[class*=\"total-pages\"]");
        if (totalPagesElement != null) {
            return Integer.parseInt(totalPagesElement.html());
        }

        totalPagesElement = httpDocument
                .select("div[class^=\"gz-pages\"]")
                .select("a:last-of-type")
                .first();

        return Integer.parseInt(totalPagesElement.html());
    }

    private Document getHttpDocument(String text, int pageIndex) throws IOException {
        String urlWithParameters = String.format(BASE_URL, pageIndex, text);
        return Jsoup.connect(urlWithParameters).get();
    }

    private ItemList getRecipeListFromHttpDocument(Document document) {
        int totalPages = getTotalPages(document);
        List<String> recipeList = document
                .select("script[type^=\"application/ld+json\"]").stream()
                .map(Element::html)
                .filter(element -> element.contains("\"@type\":\"ItemList\""))
                .collect(Collectors.toList());

        return validateAndGetItemList(totalPages, recipeList);
    }

    private ItemList validateAndGetItemList(int totalPages, List<String> itemList) {
        validateItemList(itemList);
        return toJson(totalPages, itemList.get(0));
    }

    private void validateItemList(List<String> itemList) {
        if (itemList.isEmpty()) {
            throw new IllegalArgumentException("Found no result of type ItemList");
        }

        if (itemList.size() > 1) {
            throw new IllegalArgumentException("Found more than result of type ItemList");
        }
    }

    private ItemList toJson(int totalPages, String item) {
        try {
            ItemList itemList = new ObjectMapper().readValue(item, ItemList.class);
            itemList.setTotalPages(totalPages);
            return itemList;
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
