package com.jichuangtech.yyzsteeltradeserver.controller;

import com.jichuangtech.yyzsteeltradeserver.constant.CarConstant;
import com.jichuangtech.yyzsteeltradeserver.constant.OrderConstant;
import com.jichuangtech.yyzsteeltradeserver.constant.ResponseCode;
import com.jichuangtech.yyzsteeltradeserver.model.CarEntity;
import com.jichuangtech.yyzsteeltradeserver.model.OrderEntity;
import com.jichuangtech.yyzsteeltradeserver.model.Response;
import com.jichuangtech.yyzsteeltradeserver.repository.CarRepository;
import com.jichuangtech.yyzsteeltradeserver.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bingo on 2017/7/23.
 */

@RestController
@RequestMapping(OrderConstant.API_ORDER)
public class OrderController {
    private static final String TAG = OrderController.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderRepository mOrderRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Response<List<OrderEntity>> list() {
        Response<List<OrderEntity>> response = new Response<>();
        response.data = mOrderRepository.findAll();
        LOGGER.info(" car list data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }

    @RequestMapping(value = "/{oderId}", method = RequestMethod.GET)
    public Response<OrderEntity> listById(@PathVariable int oderId) {
        Response<OrderEntity> response = new Response<>();
        response.data = mOrderRepository.findById(oderId);
        LOGGER.info(" car listById oderId :" + oderId + "data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }
}
