package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.LocationDTO;
import io.khasang.rtrail.entity.Location;
import io.khasang.rtrail.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public LocationDTO addLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public LocationDTO getLocationById(@PathVariable(value = "id") String id) {
        return locationService.getLocationById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<LocationDTO> getCats() {
        return locationService.getAllLocations();
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<LocationDTO> getCatsByName(@PathVariable(value = "name") String name) {
        return locationService.getLocationsByName(name);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public LocationDTO deleteCat(@RequestParam(value = "id") String id) {
        return locationService.deleteLocation(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public LocationDTO updateLocation(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }
}
