package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.AuthorDTO;
import io.khasang.rtrail.entity.Author;
import io.khasang.rtrail.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public AuthorDTO getAuthorById(@PathVariable(value = "id") String id) {
        return authorService.getAuthorById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public AuthorDTO deleteAuthor(@RequestParam(value = "id") String id) {
        return authorService.deleteAuthor(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/firstName/{firstName}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Author> getAuthorsByFirstName(@PathVariable(value = "firstName") String firstName) {
        return authorService.getAuthorsByFirstName(firstName);
    }

    @RequestMapping(value = "/get/lastName/{lastName}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Author> getAuthorsByLastName(@PathVariable(value = "lastName") String lastName) {
        return authorService.getAuthorsByLastName(lastName);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }

    @RequestMapping(value = "/patch", method = RequestMethod.PATCH, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Author patchAuthor(@RequestBody Author author) {
        return authorService.patchAuthor(author);
    }
}
