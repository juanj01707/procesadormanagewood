package com.uco.managewood.procesadormanagewood.domain.materiaprima;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "materiaprima")
public class MateriaPrima {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "codigomateriaprima",nullable = false)
    private int materiaprima;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "valor")
    private int valor;

    @ManyToOne
    @JoinColumn (name = "codigoespecificacion")
    private Especificacion codigoespecificacion;

    @ManyToOne
    @JoinColumn (name = "codigotipomateriaprima")
    private TipoMateriaPrima codigotipomateriaprima;

    public int getMateriaprima() {
        return materiaprima;
    }

    public void setMateriaprima(int materiaprima) {
        this.materiaprima = materiaprima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Especificacion getCodigoespecificacion() {
        return codigoespecificacion;
    }

    public void setCodigoespecificacion(Especificacion codigoespecificacion) {
        this.codigoespecificacion = codigoespecificacion;
    }

    public TipoMateriaPrima getCodigotipomateriaprima() {
        return codigotipomateriaprima;
    }

    public void setCodigotipomateriaprima(TipoMateriaPrima codigotipomateriaprima) {
        this.codigotipomateriaprima = codigotipomateriaprima;
    }
}
