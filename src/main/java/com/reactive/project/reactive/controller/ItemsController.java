package com.reactive.project.reactive.controller;

import java.util.List;

import com.reactive.project.reactive.business.ItemBO;
import com.reactive.project.reactive.dto.ItemDTO;
import com.reactive.project.reactive.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ItemsController
 */
@RestController
@RequestMapping("/item")
public class ItemsController {

    @Autowired
    private ItemBO itemBO;

    @GetMapping("/allMono")
    public Mono<List<ItemDTO>> bringAllItemsMono() {
        Mono<List<ItemDTO>> response = itemBO.findAllItemsMono();
        return response;
    }

    @GetMapping("/allFlux")
    public Flux<Item> bringAllItemsFlux() {
        Flux<Item> response = itemBO.findAllItemsFlux();
        return response;
    }

}