package com.lijian.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author lijia
 * @createTime 2023/5/20 18:40
 */
@Configuration
@ComponentScan({"com.lijian.service","com.lijian.mapper"})
@EnableTransactionManagement
@Import({JdbcConfig.class, MybatisConfig.class})
@PropertySource("db.properties")
public class SpringConfig {
}
