package com.xixi.dao;

import com.xixi.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id =true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",one = @One(select = "com.xixi.dao.ProductDao.findById")),

    })

    List<Orders> findAll();

    @Select("select * from orders where id = #{id}")
    @Results({@Result(id =true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",one = @One(select = "com.xixi.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberid",one = @One(select ="com.xixi.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",many = @Many(select ="com.xixi.dao.TravellerDao.findByOrderId")),
    })
    Orders findById(String id);
}
