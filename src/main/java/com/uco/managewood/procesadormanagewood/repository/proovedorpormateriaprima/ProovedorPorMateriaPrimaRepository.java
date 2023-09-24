package com.uco.managewood.procesadormanagewood.repository.proovedorpormateriaprima;


import com.uco.managewood.procesadormanagewood.domain.proovedorpormateriaprima.ProovedorPorMateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProovedorPorMateriaPrimaRepository extends JpaRepository<ProovedorPorMateriaPrima, Integer> {

    ProovedorPorMateriaPrima findByNombre (String nombre);
}
