package com.yc.dao;

import com.yc.configs.Config;
import com.yc.configs.DataSourceConfig;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, DataSourceConfig.class})
@Log4j2
public class StudentDaoImplTest extends TestCase {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testInsert() {
        int sid=studentDao.insert("张三","a");
    }

    @Test
    public void testUpdate() {
        studentDao.update(1,"李四","a");
    }

    @Test
    public void testDelete() {
        studentDao.delete(1);
    }
}