package io.npee.spring.validation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.npee.spring.validation.domain.ItemV3;
import io.npee.spring.validation.domain.PriceV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemRepositoryV3Test {

    @Autowired
    ItemRepositoryV3 itemRepository;

    @Test
    void create() {
        ItemV3 item = new ItemV3("itemA", new PriceV1(Boolean.TRUE, 5000, 10000), new PriceV1(Boolean.TRUE, 500, 1000));
        ItemV3 saved = itemRepository.save(item);
        assertEquals(item.getName(), saved.getName());
    }
}