package com.yc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

@Repository
public class StudentDaoImpl implements StudentDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public int insert( String sname, String spwd) {
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps=connection.prepareStatement
                    ("insert into Student(sname,spwd) values (?,?)",new String[] {"sid"});
            ps.setString(1,sname+"");
            ps.setString(2,spwd+"");
            return ps;
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(int sid, String sname, String spwd) {
        this.jdbcTemplate.update(
                "update Student set sname=?,spwd=? where sid=? ",
                sname+"",spwd+"",sid+"");
    }

    @Override
    public void delete(int sid) {
        this.jdbcTemplate.update(
                "delete from Student where sid=? ;",
                Integer.valueOf(sid));
    }
}
