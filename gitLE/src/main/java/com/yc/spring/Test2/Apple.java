package com.yc.spring.Test2;

public class Apple {
    private int id;

    public Apple() {
        System.out.println("Apple被构造了！");
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
