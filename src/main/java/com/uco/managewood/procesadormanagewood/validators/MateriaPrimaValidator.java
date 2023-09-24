package com.uco.managewood.procesadormanagewood.validators;
import com.uco.managewood.procesadormanagewood.domain.materiaprima.MateriaPrima;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class MateriaPrimaValidator  implements Validator{
    private Errors errors;
    private static final String FIELD_REQUIRED = "field.required";

    @Override
    public boolean supports(Class<?> clazz){return MateriaPrima.class.equals(clazz);}

    @Override
    public void validate(Object target, Errors errors){
        this.errors = errors;
        MateriaPrima materiaprima = (MateriaPrima) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre",FIELD_REQUIRED,"El campo 'nombre' es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoespecificacion", FIELD_REQUIRED, "El campo 'codigoespecificacion' es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigotipomateriaprima", FIELD_REQUIRED, "El campo 'codigotipomateriaprima' es obligatorio.");
    }

    public boolean hasErrors(){return  errors != null && errors.hasErrors();}
}
