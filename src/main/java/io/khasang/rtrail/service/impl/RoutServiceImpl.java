package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.RoutDao;
import io.khasang.rtrail.dto.RoutDTO;
import io.khasang.rtrail.entity.Rout;
import io.khasang.rtrail.service.RoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoutServiceImpl implements RoutService {

    @Autowired
    private RoutDao routDao;

    @Override
    public RoutDTO addRout(RoutDTO routDTO) {
        Rout rout = RoutDTO.createRoutFromDTO(routDTO);
        routDao.create(rout);
        return RoutDTO.creteDTOFromRout(rout);
    }

    @Override
    public RoutDTO getRoutDTOById(String id) {
        return RoutDTO.creteDTOFromRout(getRoutById(id));
    }

    @Override
    public RoutDTO deleteRout(String id) {
        Rout result = getRoutById(id);
        routDao.delete(result);
        return RoutDTO.creteDTOFromRout(result);
    }

    private Rout getRoutById(String id) {
        Rout result = null;
        try {
            result = routDao.getById(Long.parseLong(id));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public RoutDTO updateRout(RoutDTO routDTO) {
        Rout rout = RoutDTO.createRoutFromDTO(routDTO);
        return RoutDTO.creteDTOFromRout(routDao.update(rout));
    }

    @Override
    public List<RoutDTO> getAllRouts() {
        return createRoutDTOListFromRoutList(routDao.getList());
    }

    @Override
    public List<RoutDTO> getRoutByName(String name) {
        return createRoutDTOListFromRoutList(routDao.getByName(name));
    }

    @Override
    public List<RoutDTO> getAllOwnerRout(String owner) {
        return createRoutDTOListFromRoutList(routDao.getByOwner(owner));
    }

    private List<RoutDTO> createRoutDTOListFromRoutList(List<Rout> routList) {
        List<RoutDTO> routDTOList = new ArrayList<>();
        for (Rout rout : routList) {
            routDTOList.add(RoutDTO.creteDTOFromRout(rout));
        }

        return routDTOList;
    }
}