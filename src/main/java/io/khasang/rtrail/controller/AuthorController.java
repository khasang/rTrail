package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Author;
import io.khasang.rtrail.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller for REST CRUD services
 *
 * @author Ilya Bogachev
 * @since 06.08.2017=8
 */

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Author getAuthorById(@PathVariable(value = "id") String id) {
        return authorService.getAuthorById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/name/{authorname}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Author> getBookByName(@PathVariable(value = "authorname") String authorname) {
        return authorService.getAuthorByName(authorname);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Author> getAuthor() {
        return authorService.getAllAuthor();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Author deleteUser(@RequestParam(value = "id") String id) {
        return authorService.deleteAuthor(Long.parseLong(id)); }
}


