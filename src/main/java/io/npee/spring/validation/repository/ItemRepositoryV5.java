package io.npee.spring.validation.repository;

import io.npee.spring.validation.domain.ItemV5;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV5 extends JpaRepository<ItemV5, Long> {
}
