package io.npee.spring.validation.repository;

import io.npee.spring.validation.domain.ItemV1;
import io.npee.spring.validation.domain.ItemV2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV2 extends JpaRepository<ItemV2, Long> {
}
