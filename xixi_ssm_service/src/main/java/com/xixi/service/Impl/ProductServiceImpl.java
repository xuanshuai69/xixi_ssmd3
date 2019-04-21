package com.xixi.service.Impl;

import com.xixi.dao.ProductDao;
import com.xixi.domain.Product;
import com.xixi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> findById(String id) {
        return productDao.findById(id);
    }
}
