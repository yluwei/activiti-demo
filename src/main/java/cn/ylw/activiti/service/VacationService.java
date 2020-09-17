package cn.ylw.activiti.service;

import cn.ylw.activiti.dao.VacationDao;
import cn.ylw.activiti.entity.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 假期
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@Service
public class VacationService {

    @Autowired
    private VacationDao vacationDao;

    public void init(String procdefId) {
        Vacation v = new Vacation();
        v.setId(1);
        v.setProcdefId(procdefId);
        vacationDao.updateVacation(v);
    }
}
