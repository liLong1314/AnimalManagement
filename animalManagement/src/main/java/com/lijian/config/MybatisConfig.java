package com.lijian.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @Author lijia
 * @createTime 2023/5/20 19:10
 */

//@MapperScan会自动为DAO接口创建代理,并注入SqlSessionTemplate,从而可以执行SQL。
//    但是因为已经有了XMl,她不用写了,但是在boot中还是会用的到的,不亏
//他等价于mapperScannerConfigurer()方法
@MapperScan("com.lijian.mapper")
public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource,PageInterceptor pageInterceptor) throws IOException {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
//        给类起别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.lijian.entity");
//        通过setMapperLocations()方法设置映射文件位置:
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:/**/mapper/**.xml")
        );
//        设置配置属性
        Properties properties = new Properties();
        //驼峰和下划线
        properties.setProperty("mapUnderscoreToCamelCase", "true");
        sqlSessionFactoryBean.setConfigurationProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});

//        设置插件(如PageHelper分页插件)
//        PageInterceptor pageInterceptor = new PageInterceptor();
//
//        ArrayList<Interceptor> plugins = new ArrayList<>();
//        plugins.add(pageInterceptor);
//
//        sqlSessionFactoryBean.setPlugins(plugins);
//        PageInterceptor pageHelper = new PageInterceptor();
//        Properties properties2 = new Properties();
//        properties.setProperty("pageSizeZero", "true");
//        properties.setProperty("reasonable", "true");
//        pageHelper.setProperties(properties);
//
//        SqlSessionFactoryBean.
//                setPlugins(new Interceptor[] { pageHelper });
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setBasePackage("com.lijian.mapper");
        return mapperScannerConfigurer;
    }

    /**配置PageInterceptor分页插件*/
    @Bean
    public PageInterceptor getPageInterceptor() {
        PageInterceptor pageIntercptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("reasonable", "true");
//        properties.setProperty("value", "true");
        pageIntercptor.setProperties(properties);
        return pageIntercptor;
    }
}
