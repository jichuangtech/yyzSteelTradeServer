package com.jichuangtech.yyzsteeltradeserver.controller;

import com.jichuangtech.yyzsteeltradeserver.constant.CarConstant;
import com.jichuangtech.yyzsteeltradeserver.constant.CustomerConstant;
import com.jichuangtech.yyzsteeltradeserver.constant.ResponseCode;
import com.jichuangtech.yyzsteeltradeserver.model.CarEntity;
import com.jichuangtech.yyzsteeltradeserver.model.CustomerEntity;
import com.jichuangtech.yyzsteeltradeserver.model.Response;
import com.jichuangtech.yyzsteeltradeserver.repository.CarRepository;
import com.jichuangtech.yyzsteeltradeserver.repository.CustomerRepository;
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
@RequestMapping(CustomerConstant.API_CUSTOMER)
public class CustomerController {
    private static final String TAG = CustomerController.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerRepository mCustomerRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Response<List<CustomerEntity>> list() {
        Response<List<CustomerEntity>> response = new Response<>();
        response.data = mCustomerRepository.findAll();
        LOGGER.info(" customer list data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Response<CustomerEntity> listById(@PathVariable int customerId) {
        Response<CustomerEntity> response = new Response<>();
        response.data = mCustomerRepository.findById(customerId);
        LOGGER.info(" customer listById customerId: " + customerId +",data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }
}
