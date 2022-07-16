package io.npee.spring.validation.service;

import io.npee.spring.validation.domain.Item;
import io.npee.spring.validation.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }
}
