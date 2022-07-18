package io.npee.spring.validation.service;

import io.npee.spring.validation.domain.ItemV2;
import io.npee.spring.validation.repository.ItemRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImplV2 implements ItemService<ItemV2> {

    private final ItemRepositoryV2 itemRepository;

    @Override
    public ItemV2 createItem(ItemV2 item) {
        return itemRepository.save(item);
    }
}
