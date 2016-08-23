package indi.jackie;

import indi.jackie.boot.Dao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jackie chen
 * @create 2016/8/23
 * @description 配置mapper的bean，数据库操作
 */
@Configuration
@MapperScan(basePackages = {"indi.jackie"}, annotationClass = Dao.class)
public class DatabaseConfig {
}
