package com.example.service;

import com.example.dto.HomeDTO;
import com.example.dto.NewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface INewService {
	List<NewDTO> getAll();
	List<NewDTO> getNews(String searchValue, Pageable pageable);
	int getTotalItems(String searchValue);
	NewDTO insert(NewDTO newDTO);
	NewDTO update(NewDTO updateNew, long id);
	NewDTO findNewById(long id);
	void deleteNew(long[] ids);
	HomeDTO getHomeDetail();
	NewDTO getNewByCategory(NewDTO model);
	NewDTO getNewDetail(long id);
}
