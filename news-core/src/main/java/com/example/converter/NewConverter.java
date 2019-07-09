package com.example.converter;

import com.example.dto.NewDTO;
import com.example.entity.NewEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {

	@Autowired
	private ModelMapper modelMapper;

	public NewDTO convertToDto(NewEntity entity) {
		NewDTO result = modelMapper.map(entity, NewDTO.class);
		return result;
	}

	public NewEntity convertToEntity(NewDTO dto) {
		NewEntity result = modelMapper.map(dto, NewEntity.class);
		return result;
	}
}
