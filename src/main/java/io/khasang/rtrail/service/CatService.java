package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Cat;

import java.util.List;

public interface CatService {

    /**
     * method add cat to db
     * @param cat - cat to add
     * @return added cat
     */
    Cat addCat(Cat cat);

    /**
     * method return cat by id
     * @param id - cat id
     * @return cat by id
     */
    Cat getCatById(long id);

    Cat deleteCatById(long id);

    List<Cat> getAllCats();

    Cat updateCat(Cat cat);
}
