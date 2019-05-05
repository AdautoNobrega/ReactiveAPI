package com.reactive.project.reactive.service;

import java.util.List;

import com.reactive.project.reactive.dto.ItemDTO;
import com.reactive.project.reactive.model.Item;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ItemService
 */
@Service
public interface ItemService {

	Mono<List<ItemDTO>> findItemsMono();

	Flux<Item> findItemsFlux();

}