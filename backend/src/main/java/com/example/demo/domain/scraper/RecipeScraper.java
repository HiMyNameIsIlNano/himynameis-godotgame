package com.example.demo.domain.scraper;

import java.io.IOException;

public interface RecipeScraper<T> {

    T extractSearchResult(String text, int pageIndex) throws IOException;
}
