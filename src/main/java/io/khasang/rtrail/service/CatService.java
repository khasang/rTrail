package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Cat;

import java.util.List;

public interface CatService {

    /**
     * method for add cat
     *
     * @param cat - new cat for creation
     * @return created cat
     */
    Cat addCat(Cat cat);

    /**
     * method for getting cat
     *
     * @param id - cat's id for getting
     * @return cat by id
     */
    Cat getCatById(Long id);

    /**
     * method for getting all cats
     *
     * @return all cats
     */
    List<Cat> getAllCats();
}
