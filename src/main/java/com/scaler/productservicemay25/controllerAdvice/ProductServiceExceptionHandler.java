package com.scaler.productservicemay25.controllerAdvice;

import com.scaler.productservicemay25.dtos.ExceptionDto;
import com.scaler.productservicemay25.dtos.ProductNotFoundDto;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(1)
@ControllerAdvice
public class ProductServiceExceptionHandler {

    // global exception handler for run time
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong : thrown from Exception in exception handler : "+ e.getMessage());
        exceptionDto.setResolutionDetails("Please pay more money");
        return new ResponseEntity<>(exceptionDto, HttpStatus.UNAUTHORIZED);
    }

    // global exception handler for product not found
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ProductNotFoundDto productNotFoundDto = new ProductNotFoundDto();
        productNotFoundDto.setProductId(productNotFoundException.getProductId());
        productNotFoundDto.setMessage("Not Found : "+ productNotFoundException.getMessage());
        productNotFoundDto.setResolution("Please pass a valid product id");
        return new ResponseEntity<>(productNotFoundDto, HttpStatus.NOT_FOUND);
    }
}
