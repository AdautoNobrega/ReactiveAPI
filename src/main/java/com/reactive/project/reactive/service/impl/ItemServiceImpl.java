package com.reactive.project.reactive.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.reactive.project.reactive.dto.ItemDTO;
import com.reactive.project.reactive.model.Item;
import com.reactive.project.reactive.repository.ItemRepository;
import com.reactive.project.reactive.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ItemServiceImpl
 */
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Mono<List<ItemDTO>> findItems() {
        Mono<List<ItemDTO>> items = itemRepository.findAll().map(this::convertDto).collectList();
        return items;
    }

    private ItemDTO convertDto(final Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        return null;
    }

}