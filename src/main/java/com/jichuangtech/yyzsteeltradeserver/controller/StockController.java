package com.jichuangtech.yyzsteeltradeserver.controller;

import com.jichuangtech.yyzsteeltradeserver.constant.ResponseCode;
import com.jichuangtech.yyzsteeltradeserver.constant.StockConstant;
import com.jichuangtech.yyzsteeltradeserver.model.FactoryEntity;
import com.jichuangtech.yyzsteeltradeserver.model.Response;
import com.jichuangtech.yyzsteeltradeserver.model.StockEntity;
import com.jichuangtech.yyzsteeltradeserver.model.vo.StockReqVo;
import com.jichuangtech.yyzsteeltradeserver.model.vo.StockRespVo;
import com.jichuangtech.yyzsteeltradeserver.model.vo.StockVo;
import com.jichuangtech.yyzsteeltradeserver.repository.FactoryRepository;
import com.jichuangtech.yyzsteeltradeserver.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Bingo on 2017/7/23.
 */

@RestController
@RequestMapping(StockConstant.API_STOCK)
public class StockController extends BaseController {
    private static final String TAG = StockController.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

    @Autowired
    private StockRepository mStockRepository;

    @Autowired
    private FactoryRepository mFactoryRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Response<List<StockRespVo>> list() {
        LOGGER.info(TAG, " factory data: list");
        Response<List<StockRespVo>> response = new Response<>();
        response.data = mapList(mStockRepository.findAll(), StockRespVo.class);
        LOGGER.info(" factory data: " + response.data);
        if(response.data == null) {
            response.setStatusCode(ResponseCode.CODE_GOODS_GET_ALL_ERROR);
        }
        return response;
    }

    @RequestMapping(value = "/withFactoryId/{factoryId}", method = RequestMethod.GET)
    public Response<List<StockRespVo>> listByFactoryId(@PathVariable int factoryId) {
        LOGGER.info(" listByFactoryId factoryId: " + factoryId);
        Response<List<StockRespVo>> response = new Response<>();
        List<StockEntity> list = -1 == factoryId ? mStockRepository.findAll(): mStockRepository.findAllByFactoryId(factoryId);
        if(list != null) {
            response.data = mapList(list, StockRespVo.class);
        } else {
            response.setStatusCode(ResponseCode.CODE_GOODS_CATEGORY_GET_ERROR);
        }
        return response;
    }


    @RequestMapping(method = RequestMethod.POST)
    public Response<List<FactoryEntity>> saveStock(StockReqVo stockVo) {
        LOGGER.info(" saveStock stockVo： " + stockVo);
        Response response = new Response();

        StockEntity entity = new StockEntity();
        entity.setContractNo(stockVo.getContractNo());
        entity.setPrice(stockVo.getPrice());
        entity.setDatetime(new Timestamp(stockVo.getTimestamp()));
        entity.setNumber(stockVo.getNumber());
        entity.setRest(stockVo.getRest());
        entity.setOffset(stockVo.getOffset());
        entity.setFactory(mFactoryRepository.findById(stockVo.getFactoryId()));

        mStockRepository.save(entity);
        return response;
    }
}
