package io.npee.spring.validation.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.npee.spring.validation.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void create() {
        Item item = new Item("itemA", 10000);
        Item saved = itemRepository.save(item);
        assertEquals(item.getName(), saved.getName());
    }
}