package com.jichuangtech.yyzsteeltradeserver.controller;

import com.jichuangtech.yyzsteeltradeserver.constant.CarConstant;
import com.jichuangtech.yyzsteeltradeserver.constant.ResponseCode;
import com.jichuangtech.yyzsteeltradeserver.model.CarEntity;
import com.jichuangtech.yyzsteeltradeserver.model.Response;
import com.jichuangtech.yyzsteeltradeserver.model.vo.CarVo;
import com.jichuangtech.yyzsteeltradeserver.repository.CarRepository;
import com.jichuangtech.yyzsteeltradeserver.utils.DozerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bingo on 2017/7/23.
 */

@RestController
@RequestMapping(CarConstant.API_CAR)
public class CarController {
    private static final String TAG = CarController.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);
    @Autowired
    private CarRepository mCarRepository;


    @Transactional
    @RequestMapping(method = RequestMethod.GET)
    public Response<List<CarVo>> list() {
        LOGGER.info(TAG, " car data: list");

        Response<List<CarVo>> response = new Response<>();
        response.data = DozerUtil.mapList(mCarRepository.findAll(), CarVo.class);
        LOGGER.info(" car data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }

    @RequestMapping(value = "/{carId}", method = RequestMethod.GET)
    public Response<CarEntity> listById(@PathVariable int carId) {
        LOGGER.info(" car listById  carId: " + carId);
        Response<CarEntity> response = new Response<>();
        response.data = mCarRepository.findById(carId);
        LOGGER.info(" car listById data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }
}
