package com.sunmnet.bigdata.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 1.应用主配置类，@SpringBootApplication和同时使用@Configuration、@EnableAutoConfiguration、@ComponentScan效果相同。
 *
 * 2.@ComponentScan将会自动扫描所有以@Repository、@Service、@Component等注解标注的Spring组件，其中也包括@Configuration，
 *   所以，若应用中需要引入其他配置，只需添加相关的以@Configuration注解标注的配置类即可。
 *
 * 3.SpringApplication会自动从application.properties文件加载应用配置，并将各个配置项放入
 *   {@link org.springframework.core.env.Environment Environment}，加载顺序如下：
 *     a). 该配置类所在目录的/config子目录
 *     b). 该配置类所在目录
 *     c). classpath中/config目录
 *     d). classpath根目录
 *   其他组件中若需要使用配置项，可通过@Autowire引入Environment即可：
 *   <pre class="code">
 *   &#064;Configuration
 *   &#064;PropertySource("classpath:/com/myco/app.properties")
 *   public class AppConfig {
 *     &#064;Autowired
 *     Environment env;
 *
 *     &#064;Bean
 *     public TestBean testBean() {
 *         TestBean testBean = new TestBean();
 *         testBean.setName(env.getProperty("testbean.name"));
 *         return testBean;
 *     }
 *   }</pre>
 *
 * 4.Spring-Boot默认支持多个日志系统，具体使用哪个取决于classpath中相应日志jar包和配置文件：
 *   Logback：logback-spring.xml，logback-spring.groovy，logback.xml 或 logback.groovy
 *   Log4j2：log4j2-spring.xml 或 log4j2.xml
 *   JDK (Java Util Logging)：logging.properties
 *
 * 5.启动可通过spring-boot Maven插件启动：clean install spring-boot:run -Pdev
 */
@SpringBootConfiguration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
        "com.sunmnet.bigdata.web.config",
        "com.sunmnet.bigdata.web.config.aspect",
        "com.sunmnet.bigdata.web.admin.service",
        "com.sunmnet.bigdata.web.dao",
        "com.sunmnet.bigdata.web.service",
        "com.sunmnet.bigdata.web.controller",
        "com.sunmnet.bigdata.web.admin.controller"
})
@EnableTransactionManagement
@EnableScheduling
public class BigDataApplication {
    @Bean
    public PlatformTransactionManager statisDataSourceManager(@Qualifier("statisDataSource") DataSource statisDataSource) {
        return new DataSourceTransactionManager(statisDataSource);
    }


    public static void main(String[] args) {
        SpringApplication.run(BigDataApplication.class, args);
    }
}
