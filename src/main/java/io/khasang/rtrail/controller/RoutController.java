package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Rout;
import io.khasang.rtrail.service.RoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * controller for routs
 */
@Controller
@RequestMapping("/rout")
public class RoutController {

    @Autowired
    private RoutService routService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Rout addRout(@RequestBody Rout rout) {
        return routService.addRout(rout);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Rout getRoutById(@PathVariable(value = "id") String id) {
        return routService.getRoutById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Rout deleteRout(@PathVariable(value = "id") String id) {
        return routService.deleteRout(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Rout updateRout(@RequestBody Rout rout) {
        return routService.updateRout(rout);
    }
}
