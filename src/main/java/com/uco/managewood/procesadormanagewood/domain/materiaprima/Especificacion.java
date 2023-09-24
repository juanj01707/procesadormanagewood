package com.uco.managewood.procesadormanagewood.domain.materiaprima;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipomateriaprima")
public class Especificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoespecificacion", nullable = false)
    private int codigoespecificacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "unidaddemedida")
    private String unidaddemedida;

    @Column(name = "formato")
    private String formato;

    @Column(name = "calibreoanchura")
    private String calibreoanchura;

    @Column(name = "marca")
    private String marca;

    @Column(name = "acabado")
    private String acabado;

    @Column(name = "material")
    private String material;

    public int getCodigoespecificacion() {
        return codigoespecificacion;
    }

    public void setCodigoespecificacion(int codigoespecificacion) {
        this.codigoespecificacion = codigoespecificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidaddemedida() {
        return unidaddemedida;
    }

    public void setUnidaddemedida(String unidaddemedida) {
        this.unidaddemedida = unidaddemedida;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getCalibreoanchura() {
        return calibreoanchura;
    }

    public void setCalibreoanchura(String calibreoanchura) {
        this.calibreoanchura = calibreoanchura;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAcabado() {
        return acabado;
    }

    public void setAcabado(String acabado) {
        this.acabado = acabado;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
