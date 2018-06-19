package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.CheckPoint;
import io.khasang.rtrail.entity.Rout;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoutDTO {
    private Long id;
    private String name;
    private String description;
    private String owner;
    private List<CheckPoint> checkPointList = new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<CheckPoint> getCheckPointList() {
        return checkPointList;
    }

    public void setCheckPointList(List<CheckPoint> checkPointList) {
        this.checkPointList = checkPointList;
    }

    public static Rout createRoutFromDTO(RoutDTO routDTO) {
        Rout rout = new Rout();
        rout.setId(routDTO.getId());
        rout.setName(routDTO.getName());
        rout.setDescription(routDTO.getDescription());
        rout.setOwner(routDTO.getOwner());
        rout.setCheckPointList(routDTO.getCheckPointList());
        return rout;
    }

    public static RoutDTO creteDTOFromRout(Rout rout) {
        RoutDTO routDTO = new RoutDTO();
        routDTO.setId(rout.getId());
        routDTO.setName(rout.getName());
        routDTO.setDescription(rout.getDescription());
        routDTO.setOwner(rout.getOwner());
        routDTO.setCheckPointList(rout.getCheckPointList());
        return routDTO;
    }
}