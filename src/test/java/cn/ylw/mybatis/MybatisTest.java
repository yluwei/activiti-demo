package cn.ylw.mybatis;

import cn.ylw.activiti.StartApplication;
import cn.ylw.activiti.dao.VacationDao;
import cn.ylw.activiti.entity.Vacation;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@SpringBootTest(classes = StartApplication.class)
@RunWith(SpringRunner.class)
public class MybatisTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void test() {
        Configuration configuration = sqlSessionFactory.getConfiguration();
        System.out.println(configuration);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        VacationDao mapper = sqlSession1.getMapper(VacationDao.class);
        VacationDao mapper6 = sqlSession1.getMapper(VacationDao.class);
        Vacation vacation = mapper.getVacation(1);
        Vacation vacation2 = mapper6.getVacation(1);
        sqlSession1.commit();
        VacationDao mapper2 = sqlSession2.getMapper(VacationDao.class);
        Vacation vacation3 = mapper2.getVacation(1);

    }
}
