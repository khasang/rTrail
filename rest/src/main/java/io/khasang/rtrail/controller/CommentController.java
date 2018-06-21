package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.CommentDTO;
import io.khasang.rtrail.entity.Comment;
import io.khasang.rtrail.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommentDTO addCat(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommentDTO getCatById(@PathVariable(value = "id") String id) {
        return commentService.getCommentById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<CommentDTO> getCats() {
        return commentService.getAllComments();
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<CommentDTO> getCatsByName(@PathVariable(value = "name") String name) {
        return commentService.getCommentsByName(name);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommentDTO deleteComment(@RequestParam(value = "id") String id) {
        return commentService.deleteComment(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommentDTO updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }
}
