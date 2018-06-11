package io.khasang.rtrail.service.iml;

import io.khasang.rtrail.dao.AuthorDao;
import io.khasang.rtrail.dto.AuthorDTO;
import io.khasang.rtrail.entity.Author;
import io.khasang.rtrail.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private AuthorDTO authorDTO;

    @Override
    public Author addAuthor(Author author) {
        return authorDao.create(author);
    }

    @Override
    public AuthorDTO getAuthorById(long id) {
        return authorDTO.getAuthorDTO(authorDao.getById(id));
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getList();
    }

    @Override
    public AuthorDTO deleteAuthor(long id) {
        Author authorForDelete = authorDao.getById(id);
        return authorDTO.getAuthorDTO(authorDao.delete(authorForDelete));
    }

    @Override
    public List<Author> getAuthorsByFirstName(String firstName) {
        return authorDao.getByFirstName(firstName);
    }

    @Override
    public List<Author> getAuthorsByLastName(String lastName) {
        return authorDao.getByLastName(lastName);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorDao.update(author);
    }

    @Override
    public Author patchAuthor(Author author) {
        return authorDao.update(author);
    }
}
