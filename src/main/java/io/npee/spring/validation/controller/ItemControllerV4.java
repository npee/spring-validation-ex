package io.npee.spring.validation.controller;

import io.npee.spring.validation.domain.ItemV4;
import io.npee.spring.validation.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4")
@RequiredArgsConstructor
public class ItemControllerV4 {

    private final ItemService<ItemV4> itemService;

    @PostMapping("/item-v1")
    public ResponseEntity<ItemV4> addItemV1(@RequestBody ItemV4 item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

    @PostMapping("/item-v2")
    public ResponseEntity<ItemV4> addItemV2(@RequestBody @Validated ItemV4 item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

}
