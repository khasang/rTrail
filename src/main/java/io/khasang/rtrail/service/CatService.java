package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Cat;

import java.util.List;

public interface CatService {

    /**
     * method for add cat
     * @param cat - new cat for creating
     * @return created Cat
     */
    Cat addCat(Cat cat);

    /**
     * method for getting cat
     * @param id - cat's id for getting
     * @return  Cat by Id
     */
    Cat getCatById(long id);

    /**
     * method for getting all cats
     * @return all Cats
     */
    List<Cat> getAllCats();

    /**
     * method for remove cat
     * @param id - cat's id for remove
     * @return  delete
     */
    Cat deleteCat(long id);

    /**
     * method for getting cats by name
     * @return list of cats
     */
    List<Cat> getCatByName(String name);

    /**
     * method for update cat
     * @param cat - updated cat
     * @return created Cat
     */
    Cat updateCat(Cat cat);
}
