package io.khasang.rtrail.dto;


import io.khasang.rtrail.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatDTO {
    private Long id;
    private String name;
    private String description;

    public CatDTO getCatDTO(Cat cat) {

        CatDTO catDTO = new CatDTO();
        catDTO.setId(cat.getId());
        catDTO.setName(cat.getName());
        catDTO.setDescription(cat.getDescription());

        return catDTO;
    }

    public Cat getComment(CatDTO catDTO) {

        Cat cat = new Cat();
        cat.setId(catDTO.getId());
        cat.setName(catDTO.getName());
        cat.setDescription(catDTO.getDescription());

        return cat;
    }

    public List<CatDTO> getList(List<Cat> catList) {
        List<CatDTO> catDTOList = new ArrayList<>();
        for (Cat cat : catList) {
            catDTOList.add(getCatDTO(cat));
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
