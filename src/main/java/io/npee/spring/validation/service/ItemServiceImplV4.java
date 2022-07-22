package io.npee.spring.validation.service;

import io.npee.spring.validation.domain.ItemV4;
import io.npee.spring.validation.repository.ItemRepositoryV4;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImplV4 implements ItemService<ItemV4> {

    private final ItemRepositoryV4 itemRepository;

    @Override
    public ItemV4 createItem(ItemV4 item) {
        return itemRepository.save(item);
    }
}
