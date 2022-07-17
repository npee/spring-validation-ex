package io.npee.spring.validation.service;

import io.npee.spring.validation.domain.ItemV1;

public interface ItemService<T> {
    T createItem(T item);
}
