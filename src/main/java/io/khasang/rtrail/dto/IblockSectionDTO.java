package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockSection;
import org.springframework.stereotype.Component;

@Component
public class IblockSectionDTO {

    private Long id;
    private String name;
    private String code;
    private String description;
    private Iblock iblock;

    public IblockSectionDTO getIblockSectionDTO(IblockSection iblockSection) {

        if (iblockSection != null) {
            IblockSectionDTO iblockSectionDTO = new IblockSectionDTO();
            iblockSectionDTO.setId(iblockSection.getId());
            iblockSectionDTO.setName(iblockSection.getName());
            iblockSectionDTO.setCode(iblockSection.getCode());
            iblockSectionDTO.setDescription(iblockSection.getDescription());
            iblockSectionDTO.setIblock(iblockSection.getIblock());

            return iblockSectionDTO;
        }

        throw new IllegalArgumentException("Argument iblockSection is: null");
    }

    public IblockSection getIblockSection(IblockSectionDTO iblockSectionDTO) {

        if (iblockSectionDTO != null) {
            IblockSection iblockSection = new IblockSection();
            iblockSection.setId(iblockSectionDTO.getId());
            iblockSection.setName(iblockSectionDTO.getName());
            iblockSection.setCode(iblockSectionDTO.getCode());
            iblockSection.setDescription(iblockSectionDTO.getDescription());
            iblockSection.setIblock(iblockSectionDTO.getIblock());

            return iblockSection;
        }

        throw new IllegalArgumentException("Argument iblockSectionDTO is: null");
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
}
