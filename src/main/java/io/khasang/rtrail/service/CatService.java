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
     * method for getting all cat
     *
     * @return all cats
     */
    List<Cat> getAllCats();

    /**
     * method for deleting cat
     *
     * @param id - cat's id for deleting
     * @return deleted cat
     */
    Cat deleteCat(long id);

    /**
     * method for getting cat by name
     *
     * @param  name - filter
     * @return list of cats by name
     */
    List<Cat> getCatsByName(String name);


    /**
     * method for updating cat
     *
     * @param  cat - cat for updating
     * @return updated cat
     */
    Cat updateCat(Cat cat);

    /**
     * method for patching cat
     *
     * @param  cat - cat for patching
     * @return patched cat
     */
    Cat patchCat(Cat cat);
}
