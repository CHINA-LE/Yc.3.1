package com.yc.biz;

import com.yc.bean.Student;
import com.yc.dao.StudentDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@Transactional
public class StudentBizImpl implements StudentBiz{
    @Autowired
    StudentDao studentDao;

    @Override
    public Student zhuce( String sname, String spwd) {
        int sid=this.studentDao.insert(sname,spwd);
        Student student=new Student();
        student.setSid(sid);
        student.setSname(sname);
        student.setSpwd(spwd);
        return student;
    }

    @Override
    public void xiaohu(int sid) {
        this.studentDao.delete(sid);
    }
}
