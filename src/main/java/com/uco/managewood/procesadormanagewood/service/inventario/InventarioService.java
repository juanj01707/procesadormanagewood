package com.uco.managewood.procesadormanagewood.service.inventario;

import com.uco.managewood.procesadormanagewood.domain.inventario.Inventario;
import com.uco.managewood.procesadormanagewood.repository.inventario.InventarioRepository;
import com.uco.managewood.procesadormanagewood.validators.InventarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BeanPropertyBindingResult;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;
    @Autowired
    private InventarioValidator inventarioValidator;

    public List<Inventario> findAll(){return inventarioRepository.findAll();}

    public Optional<Inventario> findById(Integer codigo){
        return inventarioRepository.findById(codigo);
    }

    public Inventario saveInventario(Inventario inventario) {

        Inventario existingInventario = inventarioRepository.findByNombre(inventario.getNombre());

        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(inventario, "inventario");
        inventarioValidator.validate(inventario, bindingResult);
        if (bindingResult.hasErrors()) {
            return null;
        }

        if (existingInventario != null) {
            throw new RuntimeException("Ya existe un inventario con el mismo nombre: " + inventario.getNombre());
        }

        return inventarioRepository.save(inventario);
    }
    public void deleteInventario(Integer codigo){
        inventarioRepository.deleteById(codigo);
    }


    public Inventario updateInventario(int codigoinventario, Inventario nuevoInventario) {
        Optional<Inventario> inventarioOptional = inventarioRepository.findById(codigoinventario);

        if (inventarioOptional.isPresent()) {
            Inventario inventarioExistente = inventarioOptional.get();
            inventarioExistente.setNombre(nuevoInventario.getNombre());
            return inventarioRepository.save(inventarioExistente);
        } else {
            throw new RuntimeException("Inventario no encontrado con el código: " + codigoinventario);
        }
    }

    public Inventario patchInventario(int codigoinventario, Map<String, Object> fields){

        Optional<Inventario> inventarioOptional = inventarioRepository.findById(codigoinventario);

        if(inventarioOptional.isPresent()) {
            Inventario inventarioExistente = inventarioOptional.get();
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Inventario.class, key);
                field.setAccessible(true);

                if (field.getType() == String.class && value instanceof String) {
                    ReflectionUtils.setField(field, inventarioExistente, value);
                }

            });
            return inventarioRepository.save(inventarioExistente);
        }
        return null;
    }
}
