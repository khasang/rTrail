package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.CommentDao;
import io.khasang.rtrail.entity.Comment;
import io.khasang.rtrail.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment addComment(Comment comment) {
        return commentDao.create(comment);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentDao.getById(id);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentDao.getList();
    }

    @Override
    public Comment deleteComment(long id) {
        Comment commentForDelete = getCommentById(id);
        return commentDao.delete(commentForDelete);
    }

    @Override
    public List<Comment> getCommentsByName(String name) {
        return commentDao.getByName(name);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentDao.update(comment);
    }
}
