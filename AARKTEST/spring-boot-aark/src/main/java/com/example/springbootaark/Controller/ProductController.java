package com.example.springbootaark.Controller;

import com.example.springbootaark.Entity.Product;
import com.example.springbootaark.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> result = new ArrayList<>();
        result= productService.getAllProducts();
        return new ResponseEntity<>(result , HttpStatus.OK);

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getAllProductsById(@PathVariable Long id ){

        Product result = productService.getAllProductsById(id);
        if(result==null){
            return new ResponseEntity<>(result , HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(result , HttpStatus.OK);

    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product product){

        productService.createProduct(product);

    }

   @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id , @RequestBody Product product ){

        product.setPid(id);
        productService.createProduct(product);

   }

   @DeleteMapping("/products/{pid}")
    public void deleteProduct(@PathVariable Long pid){

        productService.deleteProduct(pid);

   }



}
