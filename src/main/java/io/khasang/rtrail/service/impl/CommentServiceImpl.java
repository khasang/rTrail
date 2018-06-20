package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.CommentDao;
import io.khasang.rtrail.dto.CommentDTO;
import io.khasang.rtrail.entity.Comment;
import io.khasang.rtrail.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private CommentDTO commentDTO;

    @Override
    public CommentDTO addComment(Comment comment) {
        return commentDTO.getCommentDTO(commentDao.create(comment));
    }

    @Override
    public CommentDTO getCommentById(long id) {
        return commentDTO.getCommentDTO(commentDao.getById(id));
    }

    @Override
    public List<CommentDTO> getAllComments() {
        return commentDTO.getList(commentDao.getList());
    }

    @Override
    public CommentDTO deleteComment(long id) {
        CommentDTO commentForDelete = getCommentById(id);
        return commentDTO.getCommentDTO(commentDao.delete(commentDao.getById(id)));
    }

    @Override
    public List<CommentDTO> getCommentsByName(String name) {
        return commentDTO.getList(commentDao.getByName(name));
    }

    @Override
    public CommentDTO updateComment(Comment comment) {
        return commentDTO.getCommentDTO(commentDao.update(comment));
    }
}
