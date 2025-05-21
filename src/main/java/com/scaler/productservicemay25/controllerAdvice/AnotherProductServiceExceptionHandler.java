package com.scaler.productservicemay25.controllerAdvice;

import com.scaler.productservicemay25.dtos.ExceptionDto;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AnotherProductServiceExceptionHandler {

    // global exception handler for run time but in another exception handler
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeExceptioninAnotherExceptionHandler(RuntimeException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong : thrown from Exception in another exception handler : "+ e.getMessage());
        exceptionDto.setResolutionDetails("no resolution for this");
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
