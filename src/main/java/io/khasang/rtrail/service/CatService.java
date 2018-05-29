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


}
