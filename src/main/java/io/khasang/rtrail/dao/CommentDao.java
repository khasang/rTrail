package io.khasang.rtrail.dao;


import io.khasang.rtrail.entity.Comment;
import java.util.List;

public interface CommentDao extends BasicDao<Comment> {

    /**
     * method for getting comments by name
     *
     * @param name = filter
     * @return comments by name
     */
    List<Comment> getByName(String name);
}
