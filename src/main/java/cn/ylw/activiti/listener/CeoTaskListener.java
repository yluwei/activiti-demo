package cn.ylw.activiti.listener;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

/**
 * 监听
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@Slf4j
@Component
public class CeoTaskListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("CEO任务创建了");
        log.info("assignee:{},processInstanceId:{},executionId:{}", delegateTask.getAssignee(),
            delegateTask.getProcessInstanceId(), delegateTask.getExecutionId());
    }
}
