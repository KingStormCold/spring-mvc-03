package com.example.repository;

import com.example.entity.CommentEntity;
import com.example.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByParentIdAndNews(long parentId, NewEntity newEntity);
    List<CommentEntity> findByParentIdNot(long parentId);
    List<CommentEntity> findByParentId(long parentId);
    List<CommentEntity> findByNews(NewEntity newEntity);
}
