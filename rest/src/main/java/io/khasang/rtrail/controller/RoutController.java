package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.RoutDTO;
import io.khasang.rtrail.entity.Rout;
import io.khasang.rtrail.service.RoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rout")
public class RoutController {

    @Autowired
    private RoutService routService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public RoutDTO addRout(@RequestBody RoutDTO routDTO) {
        return routService.addRout(routDTO);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RoutDTO getRoutById(@PathVariable(value = "id") String id) {
        return routService.getRoutDTOById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public RoutDTO deleteRout(@PathVariable(value = "id") String id) {
        return routService.deleteRout(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public RoutDTO updateRout(@RequestBody RoutDTO routDTO) {
        return routService.updateRout(routDTO);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RoutDTO> getAllRouts() {
        return routService.getAllRouts();
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RoutDTO> getRoutByName(@PathVariable(value = "name") String name) {
        return routService.getRoutByName(name);
    }

    @RequestMapping(value = "/get/routByOwner/{owner}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RoutDTO> getAllOwnerRouts(@PathVariable(value = "owner") String owner) {
        return routService.getAllOwnerRout(owner);
    }
}
