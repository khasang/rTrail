package io.khasang.rtrail.service;

import io.khasang.rtrail.dto.CatDTO;
import io.khasang.rtrail.entity.Cat;

import java.util.List;

public interface CatService {

    /**
     * method for add cat
     *
     * @param cat = new cat
     * @return created cat
     */
    CatDTO addCat(Cat cat);

    /**
     * method for getting cat
     *
     * @param id - cat's id for getting
     * @return cat by id
     */
    CatDTO getCatById(Long id);

    /**
     * method for getting all cats
     *
     * @return all cats
     */
    List<CatDTO> getAllCats();

    /**
     * method for delete specify cat by id
     *
     * @param id = cat's id
     * @return cat by id
     */
    CatDTO deleteCat(long id);

    /**
     * method for getting cats by name
     *
     * @param name = filter
     * @return cats by name
     */
    List<CatDTO> getCatByName(String name);

    /**
     * method for update cat
     *
     * @param cat - updated cat
     * @return updated cat
     */
    CatDTO updateCat(Cat cat);

    CatDTO patchCat(Cat cat);
}
