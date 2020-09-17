package cn.ylw.activiti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * aop测试
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@RestController
public class AopController {

    @GetMapping("/aop")
    public String aop() {
        System.out.println("aop执行");
        return "执行成功";
    }
}
