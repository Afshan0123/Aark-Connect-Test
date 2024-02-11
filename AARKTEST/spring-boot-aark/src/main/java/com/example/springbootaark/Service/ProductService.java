package com.example.springbootaark.Service;

import com.example.springbootaark.Entity.Product;
import com.example.springbootaark.Exceptions.CustomizedException;
import com.example.springbootaark.LogSetup;
import com.example.springbootaark.Repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

public class ProductService {
    private static final Logger logger
            = LoggerFactory.getLogger(LogSetup.class);

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
       //3. Logging.
        logger.info("Fetching all the products");
        List<Product> result = new ArrayList<>();
        result= productRepository.findAll();

        return result;

    }

    public Product getAllProductsById(Long pid) {
        //2. Error Handling
        if(pid==null) {
            logger.error("ProductId is NULL");
            throw new CustomizedException("Product Id should not be NULL");
        }
        logger.info("Fetching product by productId");
        Product result= productRepository.findByPid(pid);
        return result;

    }

    public void createProduct(Product product) {

        logger.info("Creating Product");
        productRepository.save(product);
    }

    public void deleteProduct(Long pid) {
        //2.Error Handling
        if(pid==null) {
            logger.error("ProductId is NULL");
            throw new CustomizedException("Product should not be NULL");
        }
        logger.info("Deleting product by productId") ;
        productRepository.deleteById(pid);
    }

}
