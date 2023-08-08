package com.yc.biz;

import com.yc.bean.Student;
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
public class StudentBizImplTest extends TestCase {
    @Autowired
    private StudentBiz studentBiz;

    @Test
    public void testZhuce() {
        Student s=studentBiz.zhuce("王五","b");
        log.info("添加成功");
    }

    @Test
    public void testXiaohu() {
        studentBiz.xiaohu(1);
        log.info("销户成功");
    }
}