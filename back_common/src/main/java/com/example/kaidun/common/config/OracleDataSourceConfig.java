package com.example.kaidun.common.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: Administrator
 * @date: 2020/11/17 13:15
 * @description:
 */


/*@Configuration*/
public class OracleDataSourceConfig {

//    @Bean(name = "OracleDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public HikariDataSource dataSource() {
        return (HikariDataSource) DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


   /* @Bean(name="oracleJdbcTemplate")*/
    public JdbcTemplate oracleJdbcTemplate(@Qualifier("OracleDataSource") HikariDataSource OracleDataSource){
        return new JdbcTemplate(OracleDataSource);
    }
}
