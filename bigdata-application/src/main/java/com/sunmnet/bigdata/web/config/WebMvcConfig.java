package com.sunmnet.bigdata.web.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sunmnet.bigdata.web.config.interceptor.ApiCostInterceptor;
import com.sunmnet.bigdata.web.config.interceptor.SecurityInterceptor;
import com.sunmnet.bigdata.web.logging.AccessLoggerListener;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;


import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Spring Boot MVC相关配置
 */
@SpringBootConfiguration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableSwagger2
@ComponentScan(basePackages = {
        "com.sunmnet.bigdata.web.controller",
        "com.sunmnet.bigdata.web.exception",
        "com.sunmnet.bigdata.web.admin.controller",
        "com.sunmnet.bigdata.web.config.interceptor",
        "com.sunmnet.bigdata.web.config.security"
})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Resource
    private ApplicationContext ctx;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
//        registry.addInterceptor(ctx.getBean(ApiCostInterceptor.class)).addPathPatterns("/**");
//        registry.addInterceptor(ctx.getBean(SecurityInterceptor.class)).addPathPatterns("/**")
//                .excludePathPatterns("/login");
    }

    @Bean
    public Docket customDocket() {
        //
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        Contact DEFAULT_CONTACT = new Contact("Cosmo", "https://github.com/cosmoxie", "songlin_xie_n22@126.com");
        String title = "大数据平台接口";
        String description = "大数据平台接口";
        String version = "1.0";
        String termsOfServiceUrl;
        String license = "Apache 2.0";
        String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";
        return new ApiInfo(title, description,version,
                "urn:tos", DEFAULT_CONTACT, license,
                licenseUrl,
                new ArrayList());

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public AccessLoggerListener accessLoggerListener() {
        Class excludes[] = {
                ServletRequest.class,
                ServletResponse.class,
                InputStream.class,
                OutputStream.class,
                MultipartFile.class,
                MultipartFile[].class
        };
        return loggerInfo -> {
            Map<String, Object> loggerMap = loggerInfo.toSimpleMap(obj -> {
                if (Stream.of(excludes).anyMatch(aClass -> aClass.isInstance(obj))) {
                    return obj.getClass().getName();
                }
                return JSON.toJSONString(obj);
            });
//            loggerMap.put("userToken", UserTokenHolder.currentToken());

            System.out.println(JSON.toJSONString(loggerMap, SerializerFeature.SortField, SerializerFeature.PrettyFormat));

        };
    }

}

