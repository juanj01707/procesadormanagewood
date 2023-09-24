package com.uco.managewood.procesadormanagewood.validators;

import com.uco.managewood.procesadormanagewood.domain.inventario.Inventario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class InventarioValidator implements Validator {

    private Errors errors;
    private static final String FIELD_REQUIRED = "field.required";

    @Override
    public boolean supports(Class<?> clazz){return Inventario.class.equals(clazz);}

    @Override
    public void validate(Object target, Errors errors){
        this.errors = errors;
        Inventario inventario = (Inventario) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre",FIELD_REQUIRED,"El campo 'nombre' es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigosede", FIELD_REQUIRED, "El campo 'codigosede' es obligatorio.");
    }

    public boolean hasErrors(){return  errors != null && errors.hasErrors();}

}
