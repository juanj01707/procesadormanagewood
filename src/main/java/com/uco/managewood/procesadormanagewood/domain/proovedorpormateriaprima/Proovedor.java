package com.uco.managewood.procesadormanagewood.domain.proovedorpormateriaprima;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "proovedor")
public class Proovedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoproovedor",nullable = false)
    private String codigoproovedor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nit")
    private String nit;

    public String getCodigoproovedor() {
        return codigoproovedor;
    }

    public void setCodigoproovedor(String codigoproovedor) {
        this.codigoproovedor = codigoproovedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
