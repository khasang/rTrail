package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Book;
import io.khasang.rtrail.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Book getBookById(@PathVariable(value = "id") String id) {
        return bookService.getBookById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Book deleteBook(@RequestParam(value = "id") String id) {
        return bookService.deleteBook(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Book> getBooksByName(@PathVariable(value = "name") String name) {
        return bookService.getBooksByName(name);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "/patch", method = RequestMethod.PATCH, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Book patchBook(@RequestBody Book book) {
        return bookService.patchBook(book);
    }
}
