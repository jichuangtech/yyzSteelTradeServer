package com.jichuangtech.clothshopserver.filter;

import com.google.common.collect.Sets;
import com.jichuangtech.clothshopserver.constant.ResponseCode;
import com.jichuangtech.clothshopserver.model.Response;
import com.jichuangtech.clothshopserver.service.SessionService;
import com.jichuangtech.clothshopserver.utils.JsonHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

/**
 * Created by yangjb on 2017/8/18.
 * 验证身份
 */
@Component("autorizationFilter")
public class AutorizationFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutorizationFilter.class);
    private final Set<String> filterUri = Sets.newHashSet();
    private static final String PRODUCT_REQUESTURI_PRREF = "/clothshopserver";

    @Autowired
    private SessionService sessionService;
    @Value("${is_product}")
    private boolean isProduct;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //不用进行身份验证的URI
        String prefix = "";

        if(isProduct) {
            prefix  = PRODUCT_REQUESTURI_PRREF;
        }

        filterUri.add(prefix + "/");
        filterUri.add(prefix + "/login");
        filterUri.add(prefix + "/onlogin");
        filterUri.add(prefix + "/configuration/ui");
        filterUri.add(prefix + "/swagger-resources");
        filterUri.add(prefix + "/webjars/springfox-swagger-ui/lib/underscore-min.map");
        filterUri.add(prefix + "/swagger-ui.html");
        filterUri.add(prefix + "/v2/api-docs");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //不是生产环境不开启session验证
        LOGGER.info("isProduct: " + isProduct);
        if (!isProduct) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String remoteHost = req.getRemoteHost();
        LOGGER.info("requestURI : " + requestURI + ", remoteHost: " + remoteHost);
        if (filterUri.contains(requestURI)) {
            chain.doFilter(request, response);
            return;
        }
        //过滤一些静态资源,如果不用swagger可以考虑注释掉
        if (StringUtils.endsWith(requestURI, "js") || StringUtils.endsWith(requestURI, "css")
                || StringUtils.endsWith(requestURI, "html") || StringUtils.endsWith(requestURI, "png")
                || StringUtils.endsWith(requestURI, "jpg") || StringUtils.endsWith(requestURI, "ttf")) {
            chain.doFilter(request, response);
            return;
        }
        Response resp = new Response();
        String sessionId = req.getHeader("access_token");
        if (sessionId == null) {
            resp.msg = "not found access_token in your headers";
            resp.statusCode = ResponseCode.ACCESS_TOKEN_NOT_FOUND;
            response.getWriter().write(JsonHelper.getJson(resp));
            LOGGER.info(resp.msg);
            return;
        }

        //下面代码进行刷新缓存
        String value = sessionService.get(sessionId);
        LOGGER.info("sessionId : " + sessionId + ", value: " + value);
        if (value != null) {
            chain.doFilter(request, response);
            return;
        }

        resp.msg = "invalid token";
        resp.statusCode = ResponseCode.TOKEN_INVALID;
        response.getWriter().write(JsonHelper.getJson(resp));
        LOGGER.info(resp.msg);
    }

    @Override
    public void destroy() {

    }
}
