package io.khasang.rtrail.service;

import io.khasang.rtrail.dto.CommentDTO;
import io.khasang.rtrail.entity.Comment;
import java.util.List;

public interface CommentService {
    /**
     * method for add comment
     *
     * @param comment - new comment for creation
     * @return created comment
     */
    CommentDTO addComment(Comment comment);

    /**
     * method for getting comment
     *
     * @param id - comment's id for getting
     * @return comment by id
     */
    CommentDTO getCommentById(long id);

    /**
     * method for getting all comments
     *
     * @return all comments
     */
    List<CommentDTO> getAllComments();

    /**
     * method for deletion comment
     *
     * @param id - comment's id for delete
     * @return deleted comment
     */
    CommentDTO deleteComment(long id);

    /**
     * method for getting comments by name
     *
     * @param name = filter
     * @return comments by name
     */
    List<CommentDTO> getCommentsByName(String name);

    /**
     * method for getting comments by name
     *
     *
     * @return comments by name
     */
    CommentDTO updateComment(Comment comment);
}
