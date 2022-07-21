package io.npee.spring.validation.service;

import io.npee.spring.validation.domain.ItemV3;
import io.npee.spring.validation.repository.ItemRepositoryV3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImplV3 implements ItemService<ItemV3> {

    private final ItemRepositoryV3 itemRepository;

    @Override
    public ItemV3 createItem(ItemV3 item) {
        return itemRepository.save(item);
    }
}
