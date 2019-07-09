package com.example.service;

import com.example.dto.NewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
	Map<String, String> getCategories();
}
