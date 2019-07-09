package com.example.service.impl;


import com.example.builder.CommentBuilder;
import com.example.constant.SystemConstant;
import com.example.converter.CommentConverter;
import com.example.dto.CommentDTO;
import com.example.entity.CommentEntity;
import com.example.entity.NewEntity;
import com.example.repository.CommentRepository;
import com.example.repository.NewRepository;
import com.example.repository.UserRepository;
import com.example.service.ICommentService;
import com.example.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentConverter commentConverter;

    @Override
    @Transactional
    public CommentDTO insert(CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent(commentDTO.getContent());
        commentEntity.setNews(newRepository.findOne(commentDTO.getNewId()));
        commentEntity.setUsers(userRepository.findOne(SecurityUtils.getPrincipal().getId()));
        commentEntity.setParentId(commentDTO.getParentId());
        commentEntity = commentRepository.save(commentEntity);
        return commentConverter.convertToDto(commentEntity);
    }

    @Override
    public List<CommentDTO> getAllCommentByNew(long newID) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        NewEntity newEntity = newRepository.findOne(newID);
        List<CommentEntity> commentEntities = commentRepository.findByParentIdAndNews(0, newEntity);
        commentEntities.forEach(item -> {
                    CommentDTO commentDTO = commentConverter.convertToDto(item);
                    commentDTO.setCol1(SystemConstant.COLUMN_BEFORE);
                    commentDTO.setCol2(SystemConstant.COLUMN_AFTER);
                    commentDTO.setDataLevel(SystemConstant.DATA_LEVEL);
                    CommentBuilder commentBuilder = new CommentBuilder.Builder()
                            .setCol1(SystemConstant.COLUMN_BEFORE)
                            .setCol2(SystemConstant.COLUMN_AFTER)
                            .setDataLevel(SystemConstant.DATA_LEVEL)
                            .setParentId(item.getId())
                            .build();
                    commentDTO.setSubComments(getSubCommentByNew(commentBuilder));
                    commentDTOS.add(commentDTO);
                }
        );
        return commentDTOS;
    }

    private List<CommentDTO> getSubCommentByNew(CommentBuilder commentBuilder) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        List<CommentEntity> commentEntities = commentRepository.findByParentId(commentBuilder.getParentId());
        for (CommentEntity item : commentEntities) {
            CommentDTO commentDTO = commentConverter.convertToDto(item);
            commentDTO.setCol1(commentBuilder.getCol1() + 1);
            commentDTO.setCol2(commentBuilder.getCol2() - 1);
            commentDTO.setDataLevel(commentBuilder.getDataLevel() + 1);
            CommentBuilder commentBuilder1 = new CommentBuilder.Builder()
                    .setCol1(commentBuilder.getCol1() + 1)
                    .setCol2(commentBuilder.getCol2() - 1)
                    .setDataLevel(commentBuilder.getDataLevel() + 1)
                    .setParentId(item.getId())
                    .build();
            commentDTO.setSubComments(getSubCommentByNew(commentBuilder1));
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }
}
