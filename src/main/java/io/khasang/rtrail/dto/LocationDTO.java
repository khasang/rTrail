package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.Location;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class LocationDTO {
    private Long id;
    private String name;
    private String short_description;
    private String detailed_description;
    private String event;

    public LocationDTO getLocationDTO(Location location) {

        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setName(location.getName());
        locationDTO.setDetailed_description(location.getDetailed_description());
        locationDTO.setShort_description(location.getShort_description());

        return locationDTO;
    }

    public Location getLocation(LocationDTO locationDTO) {

        Location location = new Location();
        location.setId(locationDTO.getId());
        location.setName(locationDTO.getName());
        location.setDetailed_description(locationDTO.getDetailed_description());
        location.setShort_description(locationDTO.getShort_description());
        return location;
    }

    public List<LocationDTO> getList(List<Location> locationList) {
        List<LocationDTO> locationDTOList = new ArrayList<>();
        for (Location location : locationList) {
            locationDTOList.add(getLocationDTO(location));
        }
        return locationDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDetailed_description() {
        return detailed_description;
    }

    public void setDetailed_description(String detailed_description) {
        this.detailed_description = detailed_description;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }


}
