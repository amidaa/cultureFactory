package com.first.group;
import com.first.group.authority.Tutorial;
import com.first.group.util.PassWordToHash;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.jdbc.pool.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;

import org.mybatis.spring.annotation.MapperScan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@MapperScan("com.first.group.dao")
public class FactoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(FactoryApplication.class, args);

    }

    //DataSource配置

    @Bean

    @ConfigurationProperties(prefix="spring.datasource")

    public DataSource dataSource() {

        return new DataSource();

    }



    //提供SqlSeesion

    @Bean

    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {



        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource());



        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();



        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));



        return sqlSessionFactoryBean.getObject();

    }



    @Bean

    public PlatformTransactionManager transactionManager() {

        return new DataSourceTransactionManager(dataSource());

    }



}
