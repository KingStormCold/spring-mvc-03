package com.example.service;

import com.example.dto.CommentDTO;

import java.util.List;

public interface ICommentService {
    CommentDTO insert(CommentDTO commentDTO);
    List<CommentDTO> getAllCommentByNew(long newID);
}
