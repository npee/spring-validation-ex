package io.npee.spring.validation.service;

import io.npee.spring.validation.domain.ItemV1;
import io.npee.spring.validation.repository.ItemRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceV1Impl implements ItemServiceV1 {

    private final ItemRepositoryV1 itemRepository;

    @Override
    public ItemV1 createItem(ItemV1 item) {
        return itemRepository.save(item);
    }
}
