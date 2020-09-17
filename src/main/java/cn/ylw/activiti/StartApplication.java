package cn.ylw.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author yanluwei
 * @date 2020/9/16
 */
@MapperScan("cn.ylw.activiti.dao")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
