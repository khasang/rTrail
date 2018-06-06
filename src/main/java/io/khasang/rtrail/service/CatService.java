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
    Cat getCatById(long id);

    /**
     * method for getting all cats
     *
     * @return all cats
     */
    List<Cat> getAllCats();

    /**
     * method for deletion cat
     *
     * @param id - cat's id for delete
     * @return deleted cat
     */
    Cat deleteCat(long id);

    /**
     * method for getting cats by name
     *
     * @param name = filter
     * @return cats by name
     */
    List<Cat> getCatsByName(String name);
}
