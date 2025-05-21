package com.scaler.productservicemay25.controllers;

import com.scaler.productservicemay25.dtos.ExceptionDto;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(productId),
                HttpStatus.OK
        );
        // should be implemented in service layer, make call to service layer
//        return productService.getSingleProduct(productId);
//        ResponseEntity<Product> responseEntity = null;
//        Product product = null;
//        try{
//            product = productService.getSingleProduct(productId);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return responseEntity;
    }


    //localhost:8080/products/
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //localhost:8080/products/
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
         return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    //localhost:8080/products/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        return null;
    }

    @PutMapping()
    public ResponseEntity<Void> replaceProduct(@RequestBody Product product) {return null;}

    @PatchMapping()
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {return null;}

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException e) {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage("Something went wrong  : thrown from Exception in controller: "+ e.getMessage());
//        exceptionDto.setResolutionDetails("Please dont pay again, will get back to you within 24 hrs");
//        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
