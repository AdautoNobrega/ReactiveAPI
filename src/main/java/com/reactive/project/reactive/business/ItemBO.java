package com.reactive.project.reactive.business;

import java.util.List;

import com.reactive.project.reactive.dto.ItemDTO;
import com.reactive.project.reactive.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Mono;

/**
 * ItemBO
 */
public class ItemBO {

    @Autowired
    private ItemService itemService;

    public Mono<List<ItemDTO>> findAllItems() {
        return itemService.findItems();
    }
}