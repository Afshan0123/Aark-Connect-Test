package com.example.springbootaark;

import com.example.springbootaark.Controller.ProductController;
import com.example.springbootaark.Entity.Product;
import com.example.springbootaark.Service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Test
    public void testGetAllProducts() {
        Product product= new Product();
        product.setPid(1l);
        product.setName("Shampoo");
        product.setDescription("Hair care");
        product.setPrice(200);

        List<Product> products = new ArrayList<>();
        products.add(product);

        Mockito.when(productService.getAllProducts()).thenReturn(products);
        ResponseEntity<List<Product>> result=productController.getAllProducts();
        assertNotNull(result);
        assertEquals(HttpStatus.OK,result.getStatusCode());

    }

    @Test
    public void testGetAllProductsById() {
        Product product= new Product();
        product.setPid(1l);
        product.setName("Shampoo");
        product.setDescription("Hair care");
        product.setPrice(200);

        Mockito.when(productService.getAllProductsById(1l)).thenReturn(product);
        ResponseEntity<Product> result=productController.getAllProductsById(1l);
        assertNotNull(result);
        assertEquals(HttpStatus.OK,result.getStatusCode());

    }

    @Test
    public void testCreateProduct(){
        Product product= new Product();
        product.setPid(1l);
        product.setName("Shampoo");
        product.setDescription("Hair care");
        product.setPrice(200);
        productController.createProduct(product);
        assertNotNull(product);
    }


    @Test
    public void testDeleteProduct(){
        Long id=2l;
        productController.deleteProduct(id);
    }



}
