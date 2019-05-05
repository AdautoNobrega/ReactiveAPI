package com.reactive.project.reactive.repository;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reactive.project.reactive.model.Item;

import reactor.core.publisher.Flux;

/**
 * ItemRepository
 */
public interface ItemRepository extends ReactiveCrudRepository<Item, Integer> {
    
	@Query("select * from Item")
	Flux<Item> findAllItems();
}