package com.reactive.project.reactive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.project.reactive.dto.ItemDTO;
import com.reactive.project.reactive.model.Item;
import com.reactive.project.reactive.repository.ItemRepository;
import com.reactive.project.reactive.service.ItemService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ItemServiceImpl
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Mono<List<ItemDTO>> findItemsMono() {
		return itemRepository.findAllItems().map(this::convertDto).collectList();
	}

	private ItemDTO convertDto(final Item item) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(item.getId());
		itemDTO.setDescricao(item.getDescricao());
		return itemDTO;
	}

	@Override
	public Flux<Item> findItemsFlux() {
		return itemRepository.findAllItems();
	}

}