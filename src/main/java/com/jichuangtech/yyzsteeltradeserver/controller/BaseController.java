package com.jichuangtech.yyzsteeltradeserver.controller;


import com.jichuangtech.yyzsteeltradeserver.utils.DozerUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@Transactional
public class BaseController {

    protected  <T> T mapSingle(Object source, Class<T> destinationClass) {
        return DozerUtil.map(source, destinationClass);
    }

    protected <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        return DozerUtil.mapList(sourceList, destinationClass);
    }
}
