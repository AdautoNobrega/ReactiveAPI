package com.reactive.project.reactive.business;

import java.util.List;

import com.reactive.project.reactive.dto.ItemDTO;
import com.reactive.project.reactive.model.Item;
import com.reactive.project.reactive.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ItemBO
 */
@Component
public class ItemBO {

    @Autowired
    private ItemService itemService;

    public Mono<List<ItemDTO>> findAllItemsMono() {
        return itemService.findItemsMono();
    }

	public Flux<Item> findAllItemsFlux() {
		return itemService.findItemsFlux();
	}
}