package com.example.BabyStore.service;

import com.example.BabyStore.entity.Category;
import com.example.BabyStore.entity.Product;
import com.example.BabyStore.repository.CategoryRepository;
import com.example.BabyStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProduct(){

        return productRepository.findAll();
    }

    public void removeProductById(Integer id){
        productRepository.deleteById(id);
    }

    public List<Product> getAllProductsByCategoryId(Integer id){
        return productRepository.findAllByCategoryId(id);
    }




//    public Product get(Long id) {
//        return productRepository.findById(id).get();
//    }


}
