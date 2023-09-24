package com.uco.managewood.procesadormanagewood.repository.inventario;

import com.uco.managewood.procesadormanagewood.domain.inventario.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    Inventario findByNombre(String nombre);
}
