package com.jichuangtech.yyzsteeltradeserver.controller;

import com.jichuangtech.yyzsteeltradeserver.constant.FactoryConstant;
import com.jichuangtech.yyzsteeltradeserver.constant.ResponseCode;
import com.jichuangtech.yyzsteeltradeserver.constant.SpecificationConstant;
import com.jichuangtech.yyzsteeltradeserver.model.FactoryEntity;
import com.jichuangtech.yyzsteeltradeserver.model.Response;
import com.jichuangtech.yyzsteeltradeserver.model.SpecificationEntity;
import com.jichuangtech.yyzsteeltradeserver.model.vo.SpecificationVo;
import com.jichuangtech.yyzsteeltradeserver.repository.FactoryRepository;
import com.jichuangtech.yyzsteeltradeserver.repository.SpecificationRepository;
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
@RequestMapping(SpecificationConstant.API_SPEC)
public class SpecificationController {
    private static final String TAG = SpecificationController.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(SpecificationController.class);
    @Autowired
    private SpecificationRepository mSpecRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Response<List<SpecificationEntity>> list() {
        Response<List<SpecificationEntity>> response = new Response<>();
        response.data = mSpecRepository.findAll();
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }

    @RequestMapping(value = "/{factoryId}", method = RequestMethod.GET)
    public Response<List<SpecificationEntity>> listAllById(@PathVariable int factoryId) {
        Response<List<SpecificationEntity>> response = new Response<>();
        response.data = mSpecRepository.findAllByFactoryId(factoryId);

        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_CATEGORY_GET_ERROR);
        }
        return response;
    }


    @RequestMapping(method = RequestMethod.POST)
    public Response<List<FactoryEntity>> saveSpec(SpecificationVo specVo) {
        LOGGER.info(" saveSpec specVo： " + specVo);
        Response response = new Response();

        SpecificationEntity entity = new SpecificationEntity();
        entity.setDiameter(specVo.getDiameter());
        entity.setLength(specVo.getLength());
        entity.setWeight(specVo.getWeight());
        entity.setNumber(specVo.getNumber());
        entity.setOffsetPrice(specVo.getOffsetPrice());
        entity.setFactoryId(specVo.getFactoryId());

        mSpecRepository.save(entity);
        return response;
    }
}
