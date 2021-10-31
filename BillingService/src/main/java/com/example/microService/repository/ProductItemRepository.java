package com.example.microService.repository;
import com.example.microService.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;


@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem ,Long> {
public Collection<ProductItem> findByBillId(Long id);
}

