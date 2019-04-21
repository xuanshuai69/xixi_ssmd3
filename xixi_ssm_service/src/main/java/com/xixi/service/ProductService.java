package com.xixi.service;

import com.xixi.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public void save(Product product);

    List<Product> findById(String id);
}
