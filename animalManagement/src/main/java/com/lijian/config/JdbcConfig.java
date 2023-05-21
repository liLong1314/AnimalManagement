package com.lijian.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author lijia
 * @createTime 2023/5/20 18:51
 */
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url ;
    @Value("${jdbc.username}")
    private String username ;
    @Value("${jdbc.password}")
    private String password;
//    数据源配置
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
//        数据库中PreparedStatement的最大个数，每个连接最多可以缓存 30 个 PreparedStatement
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(30);
//        数据源初始化时建立的连接数量,数据源一开始就会建立 5 个连接到数据库
        dataSource.setInitialSize(5);
//        以秒为计数单位
        dataSource.setLoginTimeout(3);
        return dataSource;
    }

//    配置事务管理器

    /**
     * 不配置事务管理器,Spring仍能处理事务,但功能有限
     * 显式配置可以获得更多定制化能力
     * 但不配置也可以正常工作
     * @EnableTransactionManagement 如果没有定义 transaction manager,它会自动创建一个默认的。
     * 它还会自动为@Transactional 标注的方法创建代理。
     * 总的来说貌似对我没必要
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager getTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
//        dataSourceTransactionManager.
        return dataSourceTransactionManager;
    }

}
