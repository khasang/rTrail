package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.Author;

import java.util.ArrayList;
import java.util.List;

public class BookDTO {
    private Long id;
    private String name;
    private String genre;
    private List<AuthorDTO> authorDTOList = new ArrayList<>();

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<AuthorDTO> getAuthorDTOList() {
        return authorDTOList;
    }

    public void setAuthorDTOList(List<AuthorDTO> authorDTOList) {
        this.authorDTOList = authorDTOList;
    }
}
