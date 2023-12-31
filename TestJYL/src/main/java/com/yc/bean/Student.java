package com.yc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor //带所有参数的构造方法
@NoArgsConstructor  //空参数的构造方法
@ToString           //生成toString()
public class Student {
    private int sid;
    private String sname;
    private String spwd;
}
