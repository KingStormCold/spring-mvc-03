package com.example.controller.web.api;

import com.example.dto.CommentDTO;
import com.example.service.ICommentService;
import com.example.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/comment")
public class CommentAPI {

    @Autowired
    private ICommentService commentService;


    @PostMapping
    public ResponseEntity<CommentDTO> createNew(@RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.insert(commentDTO));
    }


}
