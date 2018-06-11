package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.catalog.Iblock;
import org.springframework.stereotype.Component;

@Component
public class IblockDTO {

    private long id;
    private String name;
    private String code;
    private String description;

    public IblockDTO getIblockDTO(Iblock iblock) {

        if (iblock == null) {
            return null;
        }

        IblockDTO iblockDTO = new IblockDTO();
        iblockDTO.setId(iblock.getId());
        iblockDTO.setName(iblock.getName());
        iblockDTO.setCode(iblock.getCode());
        iblockDTO.setDescription(iblock.getDescription());

        return iblockDTO;
    }

    public Iblock getIblock(IblockDTO iblockDTO) {

        if (iblockDTO == null) {
            return null;
        }

        Iblock iblock = new Iblock();
        iblock.setId(iblockDTO.getId());
        iblock.setName(iblockDTO.getName());
        iblock.setCode(iblockDTO.getCode());
        iblock.setDescription(iblockDTO.getDescription());

        return iblock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
