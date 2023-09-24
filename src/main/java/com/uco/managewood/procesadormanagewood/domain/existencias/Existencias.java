package com.uco.managewood.procesadormanagewood.domain.existencias;

import com.uco.managewood.procesadormanagewood.domain.inventario.Inventario;
import com.uco.managewood.procesadormanagewood.domain.materiaprima.MateriaPrima;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "existencias")
public class Existencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoexistencias",nullable = false)
    private int codigoexistencias;

    @NotBlank
    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "unidades")
    private int unidades;

    @ManyToOne
    @JoinColumn(name = "codigoinventario")
    private Inventario codigoinventario;

    @ManyToOne
    @JoinColumn(name = "codigomateriaprima")
    private MateriaPrima codigomateriaprima;

    public int getCodigoexistencias() {
        return codigoexistencias;
    }

    public void setCodigoexistencias(int codigoexistencias) {
        this.codigoexistencias = codigoexistencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Inventario getCodigoinventario() {
        return codigoinventario;
    }

    public void setCodigoinventario(Inventario codigoinventario) {
        this.codigoinventario = codigoinventario;
    }

    public MateriaPrima getCodigomateriaprima() {
        return codigomateriaprima;
    }

    public void setCodigomateriaprima(MateriaPrima codigomateriaprima) {
        this.codigomateriaprima = codigomateriaprima;
    }
}
