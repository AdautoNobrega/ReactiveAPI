package com.reactive.project.reactive.service;

import java.util.List;

import com.reactive.project.reactive.dto.ItemDTO;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

/**
 * ItemService
 */
@Service
public interface ItemService {

    Mono<List<ItemDTO>> findItems();

}