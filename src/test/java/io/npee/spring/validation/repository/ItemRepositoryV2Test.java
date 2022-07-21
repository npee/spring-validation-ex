package io.npee.spring.validation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.npee.spring.validation.domain.ItemV2;
import io.npee.spring.validation.domain.PriceV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemRepositoryV2Test {

    @Autowired
    ItemRepositoryV2 itemRepository;

    @Test
    void create() {
        ItemV2 item = new ItemV2("itemA", new PriceV1(Boolean.TRUE, 5000, 10000));
        ItemV2 saved = itemRepository.save(item);
        assertEquals(item.getName(), saved.getName());
    }
}