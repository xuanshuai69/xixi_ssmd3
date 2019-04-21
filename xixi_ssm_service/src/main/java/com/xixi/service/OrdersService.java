package com.xixi.service;



import com.xixi.domain.Orders;
import java.util.List;

public interface OrdersService {
    List<Orders> findAll(int page,int size);

    Orders findById(String id);
}

