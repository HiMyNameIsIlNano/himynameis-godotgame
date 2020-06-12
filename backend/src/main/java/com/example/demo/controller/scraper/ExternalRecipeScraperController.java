package com.example.demo.controller.scraper;

import com.example.demo.domain.scraper.GialloZafferanoRecipeService;
import com.example.demo.domain.scraper.ItemList;
import com.example.demo.protobuf.ScraperProto.ItemListResponse;
import com.example.demo.protobuf.scraper.ScraperResponseFactory;
import com.google.protobuf.util.JsonFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RequestMapping("/external-recipe")
@RestController
@RequiredArgsConstructor
public class ExternalRecipeScraperController {

    private final GialloZafferanoRecipeService gialloZafferanoRecipeService;

    private final ScraperResponseFactory scraperResponseFactory;

    @GetMapping("/find/{pageIndex}/{searchText}")
    public ItemListResponse getExternalRecipe(@PathVariable(name = "searchText") String text, @PathVariable int pageIndex) {
        try {
            ItemList recipeList = gialloZafferanoRecipeService.extractSearchResult(text, pageIndex);
            ItemListResponse itemListResponse = scraperResponseFactory.toScrapeRecipeResponse(recipeList);
            log.info(JsonFormat.printer().print(itemListResponse));
            return itemListResponse;
        } catch (IOException e) {
            log.info("Page not found. {}", e.getMessage());
        }

        return null;
    }

}
