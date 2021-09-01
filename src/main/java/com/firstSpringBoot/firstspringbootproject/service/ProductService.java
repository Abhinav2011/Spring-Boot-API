package com.firstSpringBoot.firstspringbootproject.service;

import com.firstSpringBoot.firstspringbootproject.entity.Product;
import com.firstSpringBoot.firstspringbootproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //POST METHODS

    //SAVE SINGLE PRODUCT
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    //SAVE MULTIPLE PRODUCT
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //GET METHODS
    //GET ALL PRODUCTS
    public  List<Product> getProducts(){
        return repository.findAll();
    }
    //TO GET BASED ON ID
    public Product getProductByID(int id){
        return repository.findById(id).orElse(null);
    }
    //TO GET BASED ON NAME
    public Product getProductByNAME(String name){
        return repository.findByName(name);
    }

    //DELETE METHODS
    //DELETE BY ID
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Prodct  ID: " + id + " has been removed sucessfully";
    }

    //UPDATE METHODS

    public  Product updateProduct(Product product){
        Product existingProduct = repository.findById((product.getId())).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice((product.getPrice()));
        return repository.save(existingProduct);
    }
}
