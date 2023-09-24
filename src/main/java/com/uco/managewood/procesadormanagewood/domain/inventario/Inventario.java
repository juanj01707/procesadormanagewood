package com.uco.managewood.procesadormanagewood.domain.inventario;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoinventario", nullable = false)
    private int codigoinventario;

    @NotBlank
    @NotNull
    @Column(name = "nombre")
    private String nombre;


    @Column(name = "codigosede")
    private int codigosede;

    public int getCodigoinventario() {
        return codigoinventario;
    }

    public void setCodigoinventario(int codigoinventario) {
        this.codigoinventario = codigoinventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigosede() {
        return codigosede;
    }

    public void setCodigosede(int codigosede) {
        this.codigosede = codigosede;
    }
}

