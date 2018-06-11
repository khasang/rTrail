package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;
import org.springframework.stereotype.Component;

@Component
public class IblockElementDTO {

    private Long id;
    private String name;
    private String code;
    private String description;
    private Iblock iblock;
    private IblockSection iblock_section;

    public IblockElementDTO getIblockElementDTO(IblockElement iblockElement) {

        if (iblockElement == null) {
            return null;
        }

        IblockElementDTO iblockElementDTO = new IblockElementDTO();
        iblockElementDTO.setId(iblockElement.getId());
        iblockElementDTO.setName(iblockElement.getName());
        iblockElementDTO.setCode(iblockElement.getCode());
        iblockElementDTO.setDescription(iblockElement.getDescription());
        iblockElementDTO.setIblock(iblockElement.getIblock());
        iblockElementDTO.setIblock_section(iblockElement.getIblock_section());

        return iblockElementDTO;
    }

    public IblockElement getIblockElement(IblockElementDTO iblockElementDTO) {

        if (iblockElementDTO == null) {
            return null;
        }

        IblockElement iblockElement = new IblockElement();
        iblockElement.setId(iblockElementDTO.getId());
        iblockElement.setName(iblockElementDTO.getName());
        iblockElement.setCode(iblockElementDTO.getCode());
        iblockElement.setDescription(iblockElementDTO.getDescription());
        iblockElement.setIblock(iblockElementDTO.getIblock());
        iblockElement.setIblock_section(iblockElementDTO.getIblock_section());

        return iblockElement;
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

    public Iblock getIblock() {
        return iblock;
    }

    public void setIblock(Iblock iblock) {
        this.iblock = iblock;
    }

    public IblockSection getIblock_section() {
        return iblock_section;
    }

    public void setIblock_section(IblockSection iblock_section) {
        this.iblock_section = iblock_section;
    }
}
