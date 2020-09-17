package cn.ylw.activiti.dao;

import cn.ylw.activiti.entity.User;
import cn.ylw.activiti.entity.Vacation;
import org.springframework.stereotype.Repository;

/**
 * 假期
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@Repository
public interface VacationDao {
    User getUser(String type);

    Vacation getVacation(Integer id);

    int updateVacation(Vacation v);
}
