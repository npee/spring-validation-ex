package io.npee.spring.validation.repository;

import io.npee.spring.validation.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
