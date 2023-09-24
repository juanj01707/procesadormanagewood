package com.uco.managewood.procesadormanagewood.repository.existencias;

import com.uco.managewood.procesadormanagewood.domain.existencias.Existencias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExistenciasRepository extends JpaRepository <Existencias, Integer>{

    Existencias findByNombre(String nombre);
}

