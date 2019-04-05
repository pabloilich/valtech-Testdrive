package com.valtech.carassignment.exceptionhandling;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.valtech.carassignment.apierror.ErrorResponse;
import com.valtech.carassignment.apierror.ExistException;
import com.valtech.carassignment.apierror.NotFoundException;

@ControllerAdvice()
public class HandlerErrorControllerAdvice extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Se produjo un error en el server", details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<?> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("El registro no existe", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
 
    @ExceptionHandler({ExistException .class})
    public ResponseEntity<?> handleExistException(ExistException ex) {
    	List<String> details = new ArrayList<>();
    	details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("el registro ya existe", details);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("La validacion ha fallado", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	 List<String> details = new ArrayList<>();
         details.add(ex.getMessage());
         ErrorResponse error = new ErrorResponse("El formato no es valido", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
