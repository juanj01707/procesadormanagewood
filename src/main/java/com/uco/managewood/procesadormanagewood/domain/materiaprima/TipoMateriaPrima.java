package com.uco.managewood.procesadormanagewood.domain.materiaprima;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipomateriaprima")
public class TipoMateriaPrima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigomateriaprima", nullable = false)
    private int codigomateriaprima;

    @Column(name = "nombre")
    private String nombre;

    public int getCodigomateriaprima() {
        return codigomateriaprima;
    }

    public void setCodigomateriaprima(int codigomateriaprima) {
        this.codigomateriaprima = codigomateriaprima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
