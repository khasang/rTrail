package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Comment;

import java.util.List;

public interface CommentService {
    /**
     * method for add comment
     *
     * @param comment - new comment for creation
     * @return created comment
     */
    Comment addComment(Comment comment);

    /**
     * method for getting comment
     *
     * @param id - comment's id for getting
     * @return comment by id
     */
    Comment getCommentById(long id);

    /**
     * method for getting all comments
     *
     * @return all comments
     */
    List<Comment> getAllComments();

    /**
     * method for deletion comment
     *
     * @param id - comment's id for delete
     * @return deleted comment
     */
    Comment deleteComment(long id);

    /**
     * method for getting comments by name
     *
     * @param name = filter
     * @return comments by name
     */
    List<Comment> getCommentsByName(String name);

    /**
     * method for getting comments by name
     *
     *
     * @return comments by name
     */
    Comment updateComment(Comment comment);
}
