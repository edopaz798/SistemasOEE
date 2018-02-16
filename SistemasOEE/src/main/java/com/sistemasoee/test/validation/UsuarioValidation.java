package com.sistemasoee.test.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sistemasoee.test.beans.Usuario;

public class UsuarioValidation implements Validator {

	@Override
    public boolean supports(Class<?> arg0) {
        return Usuario.class.equals(arg0);
    }
 
    @Override
    public void validate(Object arg0, Errors arg1) {
    }

}
