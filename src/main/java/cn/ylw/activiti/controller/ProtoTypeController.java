package cn.ylw.activiti.controller;

import cn.ylw.activiti.dao.VacationDao;
import cn.ylw.activiti.service.TestService;
import cn.ylw.activiti.util.ApplicationContextUtil;
import org.apache.ibatis.binding.MapperProxy;
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
public class ProtoTypeController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestService testService1;

    @Autowired
    private VacationDao vacationDao;

    @Autowired
    private VacationDao vacationDao1;

    @GetMapping("/proto")
    public String test() {
        boolean b = testService == testService1;
        TestService bean = ApplicationContextUtil.getApplicationContext().getBean(TestService.class);
        TestService bean2 = ApplicationContextUtil.getApplicationContext().getBean(TestService.class);
        System.out.println(bean == bean2);
        System.out.println(testService == bean);
        System.out.println(b);
        System.out.println(vacationDao1);
        MapperProxy vacationDao = (MapperProxy) this.vacationDao;
        MapperProxy vacationDao1 = (MapperProxy) this.vacationDao1;
        return b + "";
    }
}
