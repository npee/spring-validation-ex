package io.npee.spring.validation.service;

import io.npee.spring.validation.domain.ItemV5;
import io.npee.spring.validation.repository.ItemRepositoryV5;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImplV5 implements ItemService<ItemV5> {

    private final ItemRepositoryV5 itemRepository;

    @Override
    public ItemV5 createItem(ItemV5 item) {
        return itemRepository.save(item);
    }
}
