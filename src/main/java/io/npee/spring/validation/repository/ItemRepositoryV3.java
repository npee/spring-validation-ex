package io.npee.spring.validation.repository;

import io.npee.spring.validation.domain.ItemV3;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV3 extends JpaRepository<ItemV3, Long> {
}
