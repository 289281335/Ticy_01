package com.sunmnet.bigdata.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 配置SpringBoot中内嵌的Servlet容器
 */
@SpringBootConfiguration
public class ServletContainerConfig {

    @Autowired
    private Environment env;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(env.getProperty(Constents.SERVER_PORT,Integer.class));
        factory.setSessionTimeout(env.getProperty(Constents.SERVER_SESSION_TIMEOUT,Integer.class), TimeUnit.MINUTES);

        // Tomcat自定义配置
        List<TomcatContextCustomizer> contextCustomizers = new ArrayList<>();

        // Tomcat守护线程执行backgroundProcess时间间隔（单位：秒），可以定期清理过期Session
        contextCustomizers.add(context -> context.setBackgroundProcessorDelay(env.getProperty(Constents.SERVER_BACKGROUD_PROESSOR_DELAY,Integer.class)));
        factory.setTomcatContextCustomizers(contextCustomizers);
        return factory;
    }

    /**
     * 字符编码拦截器
     */
    @Bean
    public FilterRegistrationBean characterEncodingFilter() {
        FilterRegistrationBean characterEncodingFilter = new FilterRegistrationBean();
        characterEncodingFilter.setName("characterEncodingFilter");
        characterEncodingFilter.setFilter(new CharacterEncodingFilter());
        characterEncodingFilter.addUrlPatterns("/*");

        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("encoding", "UTF-8");
        initParameters.put("forceEncoding", "true");
        characterEncodingFilter.setInitParameters(initParameters);

        return characterEncodingFilter;
    }

}
