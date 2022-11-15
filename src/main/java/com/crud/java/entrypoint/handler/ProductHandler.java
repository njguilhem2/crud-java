package com.crud.java.entrypoint.handler;

import com.crud.java.entrypoint.handler.exception.GlobalError;
import com.crud.java.entrypoint.handler.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@ControllerAdvice
public class ProductHandler extends ResponseEntityExceptionHandler {


    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<GlobalError> globalError(Exception ex, HttpServletRequest httpServletRequest,
                                                       HttpServletResponse httpResponse) throws IOException {
        GlobalError globalError = new GlobalError();
        globalError.setCode("400");
        globalError.setMessage(messageSource.getMessage(
                ex.getMessage(), null, Locale.getDefault()));
        globalError.setStatus("Bad Request");

        return new ResponseEntity<>(globalError,HttpStatus.BAD_REQUEST);
    }
}
