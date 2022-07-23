package io.npee.spring.validation.controller;

import io.npee.spring.validation.domain.ItemV5;
import io.npee.spring.validation.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v5")
@RequiredArgsConstructor
public class ItemControllerV5 {

    private final ItemService<ItemV5> itemService;

    @PostMapping("/item-v1")
    public ResponseEntity<ItemV5> addItemV1(@RequestBody ItemV5 item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

    @PostMapping("/item-v2")
    public ResponseEntity<ItemV5> addItemV2(@RequestBody @Validated ItemV5 item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

}
