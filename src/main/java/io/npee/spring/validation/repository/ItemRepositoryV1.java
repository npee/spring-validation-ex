package io.npee.spring.validation.repository;

import io.npee.spring.validation.domain.ItemV1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV1 extends JpaRepository<ItemV1, Long> {
}
