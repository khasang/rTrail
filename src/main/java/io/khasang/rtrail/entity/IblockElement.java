package io.khasang.rtrail.entity;

import javax.persistence.*;

@Entity
@Table(name = "iblock_element")
public class IblockElement {
    public IblockElement() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    private String description;

    @ManyToOne
    private Iblock iblock;

    @ManyToOne
    private IblockSection iblock_section;


    public IblockElement(String name, String code, String description, Iblock iblock, IblockSection iblock_section) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.iblock = iblock;
        this.iblock_section = iblock_section;
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

    @Override
    public String toString() {
        return "IblockElement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", iblock=" + iblock +
                ", iblock_section=" + iblock_section +
                '}';
    }
}
