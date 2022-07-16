package io.npee.spring.validation.controller;

import io.npee.spring.validation.domain.Item;
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
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

}
