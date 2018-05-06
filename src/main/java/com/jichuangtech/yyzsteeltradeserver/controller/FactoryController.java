package com.jichuangtech.yyzsteeltradeserver.controller;

import com.jichuangtech.yyzsteeltradeserver.constant.FactoryConstant;
import com.jichuangtech.yyzsteeltradeserver.constant.ResponseCode;
import com.jichuangtech.yyzsteeltradeserver.model.FactoryEntity;
import com.jichuangtech.yyzsteeltradeserver.model.Response;
import com.jichuangtech.yyzsteeltradeserver.repository.FactoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bingo on 2017/7/23.
 */

@RestController
@RequestMapping(FactoryConstant.API_FACTORY)
public class FactoryController {
    private static final String TAG = FactoryController.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryController.class);
    @Autowired
    private FactoryRepository mFactoryRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Response<List<FactoryEntity>> list() {
        LOGGER.info(TAG, " factory data: list");
        Response<List<FactoryEntity>> response = new Response<>();
        response.data = mFactoryRepository.findAll();
        LOGGER.info(" factory data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }

    @RequestMapping(value = "/{factoryId}", method = RequestMethod.GET)
    public Response<FactoryEntity> listById(@PathVariable int factoryId) {
        LOGGER.info(" factory listById  factoryId: " + factoryId);
        Response<FactoryEntity> response = new Response<>();
        response.data = mFactoryRepository.findById(factoryId);
        LOGGER.info(" factory listById data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }
}
