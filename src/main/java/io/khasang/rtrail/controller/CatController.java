package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Cat;
import io.khasang.rtrail.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cat")
public class CatController {
    @Autowired
    public CatService catService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat addCat(@RequestBody Cat cat){
        return catService.addCat(cat);
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat getCatById(@PathVariable(value = "id") String id ){
        return catService.getCatById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all" ,method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Cat> getCatById(){
        return catService.getAllCats();
    }

    @RequestMapping(value = "/get/name/{name}" ,method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Cat> getCatByName(@PathVariable(value = "name") String name){
        return catService.getCatsByName(name);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat deleteCat(@PathVariable(value = "id") String id ){
        return catService.deleteCat(Long.parseLong(id));
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat updateCat(@RequestBody Cat cat){
        return catService.updateCat(cat);
    }

}
