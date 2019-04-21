package com.xixi.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xixi.dao.OrdersDao;
import com.xixi.domain.Orders;
import com.xixi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;


    @Override
    public List<Orders> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
