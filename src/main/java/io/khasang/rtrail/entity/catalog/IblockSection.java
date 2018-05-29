package io.khasang.rtrail.entity.catalog;

import javax.persistence.*;

@Entity
@Table(name = "iblock_section")
public class IblockSection {
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

    public IblockSection(String name, String code, String description, Iblock iblock) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.iblock = iblock;
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

    public IblockSection() {
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

    @Override
    public String toString() {
        return "IblockSection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", iblock=" + iblock +
                '}';
    }

    public Iblock getIblock() {
        return iblock;
    }

    public void setIblock(Iblock iblock) {
        this.iblock = iblock;
    }
}
