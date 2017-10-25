package com.jichuangtech.clothshopserver.filter;

import com.google.common.collect.Sets;
import com.jichuangtech.clothshopserver.model.Response;
import com.jichuangtech.clothshopserver.service.SessionService;
import com.jichuangtech.clothshopserver.utils.JsonHelper;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;
import java.util.logging.LogManager;

/**
 * Created by yangjb on 2017/8/18.
 * 验证身份
 */
@Component("autorizationFilter")
public class AutorizationFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutorizationFilter.class);
    private static final Set<String> filterUri = Sets.newHashSet();

    static {
        //不用进行身份验证的URI
        filterUri.add("/");
        filterUri.add("/login");
        filterUri.add("/onlogin");
        filterUri.add("/configuration/ui");
        filterUri.add("/swagger-resources");
        filterUri.add("/webjars/springfox-swagger-ui/lib/underscore-min.map");
        filterUri.add("/swagger-ui.html");
        filterUri.add("/v2/api-docs");
    }

    @Autowired
    private SessionService sessionService;
    @Value("${is_product}")
    private boolean isProdect;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //不是生产环境不开启session验证
        LOGGER.info("isProdect: " + isProdect);
        if (!isProdect) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String remoteHost = req.getRemoteHost();
        LOGGER.info("requestURI : " + requestURI  + ", remoteHost: " + remoteHost);
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
        String sessionId = req.getHeader("access_token");
        if (sessionId == null) {
            LOGGER.info("sessionId param lost");
            response.getWriter().write("sessionId param lost");
            return;
        }

        //下面代码进行刷新缓存
        String value = sessionService.get(sessionId);
        LOGGER.info("sessionId : " + sessionId + ", value: " + value);
        if (value != null) {
            chain.doFilter(request, response);
            return;
        }
        Response resp = new Response();
        resp.msg = "invalid user";
        resp.statusCode = 400;
        response.getWriter().write(JsonHelper.getJson(resp));
        LOGGER.info("invalid user");
    }

    @Override
    public void destroy() {

    }
}
