package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CommentDTO {
    private Long id;
    private String name;
    private String description;

    public CommentDTO getCommentDTO(Comment comment) {

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setDescription(comment.getDescription());

        return commentDTO;
    }

    public Comment getComment(CommentDTO commentDTO) {

        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setName(commentDTO.getName());
        comment.setDescription(commentDTO.getDescription());

        return comment;
    }

    public List<CommentDTO> getList(List<Comment> commentList) {
        List<CommentDTO> catDTOList = new ArrayList<>();
        for (Comment comment : commentList) {
            catDTOList.add(getCommentDTO(comment));
        }

        return catDTOList;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


