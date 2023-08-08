package com.yc.dao;

import com.yc.bean.Student;

public interface StudentDao {
    public int insert(String sname,String spwd);
    public void update(int sid,String sname,String spwd);
    public void delete(int sid);
}
