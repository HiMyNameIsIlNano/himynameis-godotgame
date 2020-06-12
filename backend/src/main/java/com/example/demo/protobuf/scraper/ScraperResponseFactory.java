package com.example.demo.protobuf.scraper;

import com.example.demo.domain.scraper.ItemList;
import com.example.demo.domain.scraper.ListItem;
import com.example.demo.protobuf.ScraperProto.ItemListResponse;
import com.example.demo.protobuf.ScraperProto.ListItemDTO;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ScraperResponseFactory {

    public ItemListResponse toScrapeRecipeResponse(ItemList itemList) {
        return ItemListResponse.newBuilder()
                .setContext(itemList.getContext())
                .setType(itemList.getType())
                .addAllItemListElement(listItemDTOs(itemList.getItemListElement()))
                .setNumberOfItems(itemList.getNumberOfItems())
                .setTotalPages(itemList.getTotalPages())
                .build();
    }

    public Iterable<? extends ListItemDTO> listItemDTOs(List<ListItem> items) {
        return items.stream().map(this::listItemDTO)::iterator;
    }

    private ListItemDTO listItemDTO(ListItem item) {
        return ListItemDTO.newBuilder()
                .setType(item.getType())
                .setPosition(item.getPosition())
                .setUrl(item.getUrl())
                .build();
    }
}
