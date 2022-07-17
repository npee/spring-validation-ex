package io.npee.spring.validation.controller;

import io.npee.spring.validation.domain.ItemV1;

import io.npee.spring.validation.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
public class ItemControllerV1 {

    private final ItemService<ItemV1> itemService;

    @PostMapping
    public ResponseEntity<ItemV1> addItemV1(@RequestBody ItemV1 item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

}
