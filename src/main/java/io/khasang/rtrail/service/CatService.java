package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Cat;

import java.util.List;

public interface CatService {
    /**
    * method for add cat
     * @param cat - new cat for creation
     * @return created cat
     *
    * */
    Cat addCat(Cat cat);

    /**
     * method for getting cat
     * @param id - cat's id for getting
     * @return cat by id
     *
     * */
    Cat getCatById(long id);

    /**
     * method for getting all cats
     *
     * @return clist od cats
     *
     * */
     List<Cat> getAllCats();

    /**
     * method for getting cat
     * @param id - cat's id for getting
     * @return cat by id
     *
     * */
    Cat deleteCat(long id);

    /**
     * method for getting cats by name
     * @param name = filter
     * @return list of cats
     *
     * */
    List<Cat> getCatsByName(String name);

    /**
     * method for updating cat
     * @param cat = new cat
     * @return added cat
     *
     * */
    Cat updateCat(Cat cat);
}
