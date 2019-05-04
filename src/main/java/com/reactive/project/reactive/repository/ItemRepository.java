package com.reactive.project.reactive.repository;

import com.reactive.project.reactive.model.Item;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * ItemRepository
 */
public interface ItemRepository extends R2dbcRepository<Item, Long> {
    
}