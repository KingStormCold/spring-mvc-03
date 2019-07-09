package com.example.repository;

import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	Page<NewEntity> findByTitleContainingIgnoreCase(String searchValue, Pageable pageable);
	long countByTitleContainingIgnoreCase(String searchValue);
	Page<NewEntity> findByCategoryAndTitleContainingIgnoreCase(CategoryEntity category, String title, Pageable pageable);
	long countByCategoryAndTitleContainingIgnoreCase(CategoryEntity category, String title);
	Page<NewEntity> findByCategory(CategoryEntity category, Pageable pageable);
	long countByCategory(CategoryEntity category);
}
