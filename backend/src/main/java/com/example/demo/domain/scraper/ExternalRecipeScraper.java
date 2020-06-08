package com.example.demo.domain.scraper;

import com.example.demo.protobuf.scraper.ScraperResponseFactory;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/external-recipe")
@RestController
@RequiredArgsConstructor
public class ExternalRecipeScraper {

	private final GialloZafferanoRecipeScraper gialloZafferanoRecipeScraper;

	private final ScraperResponseFactory scraperResponseFactory;

	@GetMapping("/find/{pageIndex}/{searchText}")
	public void getExternalRecipe(@PathVariable(name = "searchText") String text, @PathVariable int pageIndex) {
		try {
			ItemList recipeList = gialloZafferanoRecipeScraper.extractSearchResult(text, pageIndex);
			scraperResponseFactory.toScrapeRecipeResponse(recipeList);
		} catch (IOException e) {
			log.info("Page not found. {}", e.getMessage());
		}
	}

}
