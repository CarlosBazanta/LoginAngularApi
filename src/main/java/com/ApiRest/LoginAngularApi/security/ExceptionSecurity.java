package com.ApiRest.LoginAngularApi.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ExceptionSecurity extends RuntimeException {

    private static final  long serialVesionUID = 1L;
    public ExceptionSecurity(String messange){
        super(messange);
    }

}
