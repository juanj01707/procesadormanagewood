package com.uco.managewood.procesadormanagewood.domain.proovedorpormateriaprima;

import com.uco.managewood.procesadormanagewood.domain.materiaprima.MateriaPrima;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "proovedorpormateriaprima")
public class ProovedorPorMateriaPrima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoproovedorpormateriaprima",nullable = false)
    private int codigoproovedorpormateriaprima;

    @NotNull
    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "valor")
    private int valor;

    @ManyToOne
    @JoinColumn (name = "codigoproovedor")
    private Proovedor codigoproovedor;

    @ManyToOne
    @JoinColumn(name = "codigomateriaprima")
    private MateriaPrima codigomateriaprima;

    public int getCodigopormateriaprima() {
        return codigoproovedorpormateriaprima;
    }

    public void setCodigopormateriaprima(int codigopormateriaprima) {
        this.codigoproovedorpormateriaprima = codigoproovedorpormateriaprima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Proovedor getCodigoproovedor() {
        return codigoproovedor;
    }

    public void setCodigoproovedor(Proovedor codigoproovedor) {
        this.codigoproovedor = codigoproovedor;
    }

    public MateriaPrima getCodigomateriaprima() {
        return codigomateriaprima;
    }

    public void setCodigomateriaprima(MateriaPrima codigomateriaprima) {
        this.codigomateriaprima = codigomateriaprima;
    }
}
