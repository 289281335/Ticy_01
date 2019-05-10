package com.sunmnet.bigdata.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 大数据Web统计数据源配置类
 */
@SpringBootConfiguration
@PropertySource("classpath:datasource.properties")
@MapperScan(basePackages = "com.sunmnet.bigdata.web.dao", sqlSessionFactoryRef = "statisSqlSessionFactory")
public class StatisDatasourceConfig {

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext ctx;


    @Bean
    public DataSource statisDataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        // 基本属性
        dataSource.setDriverClassName(env.getProperty(Constents.DRIVER));
        dataSource.setUrl(env.getProperty(Constents.JDBC_URL));
        dataSource.setUsername(env.getProperty(Constents.USER_NAEM));
        dataSource.setPassword(env.getProperty(Constents.PASSWORD));

        // 配置初始化大小、最小、最大
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(20);

        // 配置获取连接等待超时的时间，单位是毫秒
        dataSource.setMaxWait(60000);

        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000);

        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000);

        // 配置连接存活测试
        dataSource.setValidationQuery("select 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);

        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory statisSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        VFS.addImplClass(SpringBootVFS.class);
        sessionFactory.setDataSource(statisDataSource());
        //实体类的包名（根据你的项目自行修改）
        sessionFactory.setTypeAliasesPackage(env.getProperty(Constents.ALIASES_PACKAGE));

        // Mybatis Config
        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(configuration);

        // Mybatis Mapper XML Config
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //*.mapper.xml的地址（根据你的项目自行修改）
        sessionFactory.setMapperLocations(resolver.getResources(env.getProperty(Constents.MAPPER)));

        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        // Mybatis Plugins
        Interceptor[] plugins = new Interceptor[]{
                (Interceptor) ctx.getBean("sqlLogInterceptor"),pageHelper
        };
        sessionFactory.setPlugins(plugins);

        return sessionFactory.getObject();
    }
}
