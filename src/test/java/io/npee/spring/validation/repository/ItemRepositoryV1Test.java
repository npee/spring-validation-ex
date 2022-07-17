package io.npee.spring.validation.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.npee.spring.validation.domain.ItemV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemRepositoryV1Test {

    @Autowired
    ItemRepositoryV1 itemRepository;

    @Test
    void create() {
        ItemV1 item = new ItemV1("itemA", 10000);
        ItemV1 saved = itemRepository.save(item);
        assertEquals(item.getName(), saved.getName());
    }
}