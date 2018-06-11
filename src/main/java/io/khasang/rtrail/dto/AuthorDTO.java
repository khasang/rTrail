package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.Author;
import io.khasang.rtrail.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private List<BookDTO> bookDTOList = new ArrayList<>();

    public List<AuthorDTO> getAuthorDTOList(List<Author> authorList) {
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author : authorList) {
            List<BookDTO> bookDTOList = new ArrayList<>();

            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setId(author.getId());
            authorDTO.setFirstName(author.getFirstName());
            authorDTO.setLastName(author.getLastName());

            getBookDTOListFromAuthor(author, bookDTOList);

            authorDTO.setBookDTOList(bookDTOList);
            authorDTOList.add(authorDTO);
        }

        return authorDTOList;
    }

    public AuthorDTO getAuthorDTO(Author author) {
        List<BookDTO> bookDTOList = new ArrayList<>();

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());

        getBookDTOListFromAuthor(author, bookDTOList);

        authorDTO.setBookDTOList(bookDTOList);

        return authorDTO;
    }

    private void getBookDTOListFromAuthor(Author author, List<BookDTO> bookDTOList) {
        for (Book book : author.getBookList()) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setName(book.getName());
            bookDTO.setGenre(book.getGenre());

            bookDTOList.add(bookDTO);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public void setBookDTOList(List<BookDTO> bookDTOList) {
        this.bookDTOList = bookDTOList;
    }
}
