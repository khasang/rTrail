package io.khasang.rtrail.entity;


import javax.persistence.*;

@Entity
@Table(name = "check_points")
public class CheckPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long coordX;

    private Long coordY;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoordX() {
        return coordX;
    }

    public void setCoordX(Long coordX) {
        this.coordX = coordX;
    }

    public Long getCoordY() {
        return coordY;
    }

    public void setCoordY(Long coordY) {
        this.coordY = coordY;
    }
}
