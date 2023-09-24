package com.uco.managewood.procesadormanagewood.repository.materiaprima;

import com.uco.managewood.procesadormanagewood.domain.materiaprima.MateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaPrimaRepository extends JpaRepository <MateriaPrima,Integer>{

    MateriaPrima findByNombre(String nombre);
}
