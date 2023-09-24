package com.uco.managewood.procesadormanagewood.service.materiaprima;

import com.uco.managewood.procesadormanagewood.domain.materiaprima.MateriaPrima;
import com.uco.managewood.procesadormanagewood.repository.materiaprima.MateriaPrimaRepository;
import com.uco.managewood.procesadormanagewood.validators.MateriaPrimaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BeanPropertyBindingResult;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MateriaPrimaService {
    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;

    @Autowired
    private MateriaPrimaValidator materiaPrimaValidator;

    public List<MateriaPrima> findAll() {return materiaPrimaRepository.findAll();}

    public Optional<MateriaPrima> findById(Integer codigo){
        return materiaPrimaRepository.findById(codigo);
    }


    public MateriaPrima saveMateriaPrima(MateriaPrima materiaprima) {

        MateriaPrima exinstingMateriaPrima = materiaPrimaRepository.findByNombre(materiaprima.getNombre());

        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(materiaprima, "materiaprima");
        materiaPrimaValidator.validate(materiaprima, bindingResult);

        if (bindingResult.hasErrors()) {
            return null;
        }

        if (exinstingMateriaPrima != null) {
            throw new RuntimeException("Ya existe una materia prima con el mismo nombre: " + materiaprima.getNombre());
        }

        return materiaPrimaRepository.save(materiaprima);
    }

    /*
    public MateriaPrima saveMateriaPrima(MateriaPrima materiaprima){
        return materiaprimaRepository.save(materiaprima);
    }
    */

    public void deleteMateriaPrima(Integer codigo){
        materiaPrimaRepository.deleteById(codigo);
    }



    public MateriaPrima updateMateriaPrima(int codigomateriaprima, MateriaPrima nuevaMateriaPrima) {
        Optional<MateriaPrima> materiaprimaOptional = materiaPrimaRepository.findById(codigomateriaprima);

        if (materiaprimaOptional.isPresent()) {
            MateriaPrima materiaprimaExistente = materiaprimaOptional.get();
            materiaprimaExistente.setNombre(nuevaMateriaPrima.getNombre());
            materiaprimaExistente.setDescripcion(nuevaMateriaPrima.getDescripcion());
            materiaprimaExistente.setValor(nuevaMateriaPrima.getValor());
            materiaprimaExistente.setCodigoespecificacion(nuevaMateriaPrima.getCodigoespecificacion());
            materiaprimaExistente.setCodigotipomateriaprima(nuevaMateriaPrima.getCodigotipomateriaprima());


            return materiaPrimaRepository.save(materiaprimaExistente);
        } else {
            throw new RuntimeException("Materia prima no encontrada con el código: " + codigomateriaprima);
        }
    }


    public MateriaPrima patchMateriaPrima(int codigomateriaprima, Map<String, Object> fields){

        Optional<MateriaPrima> materiaprimaOptional = materiaPrimaRepository.findById(codigomateriaprima);

        if(materiaprimaOptional.isPresent()) {
            MateriaPrima materiaprimaExistente = materiaprimaOptional.get();
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(MateriaPrima.class, key);
                field.setAccessible(true);

                if (field.getType() == String.class && value instanceof String) {
                    ReflectionUtils.setField(field, materiaprimaExistente, value);
                }

            });
            return materiaPrimaRepository.save(materiaprimaExistente);
        }
        return null;
    }

}
