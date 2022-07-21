package io.npee.spring.validation.controller;

import io.npee.spring.validation.domain.ItemV3;
import io.npee.spring.validation.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
@RequiredArgsConstructor
public class ItemControllerV3 {

    private final ItemService<ItemV3> itemService;

    @PostMapping("/item-v1")
    public ResponseEntity<ItemV3> addItemV1(@RequestBody ItemV3 item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

    @PostMapping("/item-v2")
    public ResponseEntity<ItemV3> addItemV2(@RequestBody @Validated ItemV3 item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

}
