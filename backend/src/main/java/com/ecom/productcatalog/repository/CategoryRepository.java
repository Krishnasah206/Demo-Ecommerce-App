package com.ecom.productcatalog.repository;

import com.ecom.productcatalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
