package com.example.converter;

import com.example.dto.CommentDTO;
import com.example.entity.CommentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CommentDTO convertToDto(CommentEntity entity) {
        CommentDTO result = modelMapper.map(entity, CommentDTO.class);
        return result;
    }

    public CommentEntity convertToEntity(CommentDTO dto) {
        CommentEntity result = modelMapper.map(dto, CommentEntity.class);
        return result;
    }
}
