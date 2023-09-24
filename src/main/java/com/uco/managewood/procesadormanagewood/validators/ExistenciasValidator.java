package com.uco.managewood.procesadormanagewood.validators;

import com.uco.managewood.procesadormanagewood.domain.existencias.Existencias;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class ExistenciasValidator implements Validator {
    private Errors errors;
    private static final String FIELD_REQUIRED = "field.required";

    @Override
    public boolean supports(Class<?> clazz){return Existencias.class.equals(clazz);}

    @Override
    public void validate(Object target, Errors errors){
        this.errors = errors;
        Existencias existencias = (Existencias) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre",FIELD_REQUIRED,"El campo 'nombre' es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoinventario", FIELD_REQUIRED, "El campo 'codigoinventario' es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigomateriaprima", FIELD_REQUIRED, "El campo 'codigomateriaprima' es obligatorio.");
    }

    public boolean hasErrors(){return  errors != null && errors.hasErrors();}
}
