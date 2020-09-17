package cn.ylw.activiti.listener;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 监听
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@Slf4j
public class ManagerTaskListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("项目经理任务创建了");
        log.info("assignee:{},processInstanceId:{},executionId:{}", delegateTask.getAssignee(),
            delegateTask.getProcessInstanceId(), delegateTask.getExecutionId());
    }
}
