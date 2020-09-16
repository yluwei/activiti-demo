package cn.ylw.activiti.controller;

import cn.ylw.activiti.service.TestService;
import cn.ylw.activiti.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author yanluwei
 * @date 2020/9/16
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestService testService1;

    @GetMapping("/test")
    public String test() {
        boolean b = testService == testService1;
        TestService bean = ApplicationContextUtil.getApplicationContext().getBean(TestService.class);
        System.out.println(testService == bean);
        System.out.println(b);
        return b + "";
    }
}
