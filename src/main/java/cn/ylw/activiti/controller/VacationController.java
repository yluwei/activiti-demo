package cn.ylw.activiti.controller;

import cn.ylw.activiti.dao.VacationDao;
import cn.ylw.activiti.entity.User;
import cn.ylw.activiti.entity.Vacation;
import cn.ylw.activiti.listener.CeoTaskListener;
import cn.ylw.activiti.listener.CtoTaskListener;
import cn.ylw.activiti.listener.ManagerTaskListener;
import cn.ylw.activiti.service.VacationService;
import cn.ylw.activiti.vo.ApplyVO;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 请假流程
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@RestController
@RequestMapping("/vacation")
@Slf4j
public class VacationController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private VacationService vacationService;
    @Autowired
    private VacationDao vacationDao;
    @Autowired
    private CtoTaskListener ctoTaskListener;
    @Autowired
    private CeoTaskListener ceoTaskListener;

    @GetMapping("/init")
    public void init() {
        Deployment deploy = repositoryService.createDeployment()
            .name("apply vacation")
            .key("vacation")
            .addClasspathResource("processes/vacation.bpmn20.xml")
            .deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
            .deploymentId(deploy.getId())
            .singleResult();
        vacationService.init(processDefinition.getId());
        log.info("流程部署完成，部署ID{}，流程定义ID{}", deploy.getId(), processDefinition.getId());
    }

    @PostMapping("/apply")
    public void apply(@RequestBody ApplyVO apply) {

        Vacation vacation = vacationDao.getVacation(1);
        User user = vacationDao.getUser("项目经理");
        Map<String, Object> map = new HashMap<>();
        map.put("days", apply.getDays());
        map.put("manager", user.getId());
        map.put("managerTaskListener", new ManagerTaskListener());
        ProcessInstance p = runtimeService.startProcessInstanceById(vacation.getProcdefId(), map);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("ctoTaskListener", ctoTaskListener);
        map1.put("ceoTaskListener", ceoTaskListener);
        map1.put("cto", "3");
        map1.put("ceo", "4");
        runtimeService.setVariables(p.getId(), map1);
        runtimeService.setVariablesLocal(p.getId(), map1);
    }

    @PostMapping("/check")
    public String check(Integer userId, Integer type, String pId) {
        // 取任务
        Task task = taskService.createTaskQuery()
            .taskAssignee(userId.toString())
            .processInstanceId(pId)
            .singleResult();
        if (task == null) {
            return "任务不存在";
        }
        taskService.setVariable(task.getId(), "任务变量", "hello");
        taskService.setVariable(task.getId(), "任务变量", "hello2");
        taskService.setVariableLocal(task.getId(), "任务变量", "hello3");
        taskService.setAssignee(task.getId(), "1000");
        if (type == 1) {
            taskService.complete(task.getId());
        } else {
            runtimeService.deleteProcessInstance(task.getProcessInstanceId(), "不通过");
        }
        return "完成";
    }

}
