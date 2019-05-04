package com.reactive.project.reactive.controller;

import java.util.List;

import com.reactive.project.reactive.business.ItemBO;
import com.reactive.project.reactive.dto.ItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * ItemsController
 */
@RestController("/item")
public class ItemsController {

    @Autowired
    private ItemBO itemBO;

    @GetMapping("/all")
    public ResponseEntity<Mono<List<ItemDTO>>> bringAllItems() {
        Mono<List<ItemDTO>> response = itemBO.findAllItems();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}