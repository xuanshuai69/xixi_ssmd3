package com.xixi.controller;

import com.github.pagehelper.PageInfo;
import com.xixi.domain.Orders;
import com.xixi.domain.Product;
import com.xixi.service.OrdersService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name ="page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ps = ordersService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(ps);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders ps = ordersService.findById(id);
        mv.addObject("orders", ps);
        mv.setViewName("orders-show");
        return mv;
    }

}
