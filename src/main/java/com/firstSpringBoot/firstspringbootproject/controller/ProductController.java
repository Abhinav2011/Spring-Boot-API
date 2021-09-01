package com.firstSpringBoot.firstspringbootproject.controller;

import com.firstSpringBoot.firstspringbootproject.entity.Product;
import com.firstSpringBoot.firstspringbootproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    //HERE WE WRITE THE REST ENDPOINTS FOR ALL THE METHODS IN SERVICE

    //post methods
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    //get methods
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/productByID/{id}")
    public Product getProductByID(@PathVariable int id){
        return service.getProductByID(id);
    }
    @GetMapping("/productByNAME/{name}")
    public Product getProductByID(@PathVariable String name){
        return service.getProductByNAME(name);
    }

    //put methods
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    //delete methods
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

}
