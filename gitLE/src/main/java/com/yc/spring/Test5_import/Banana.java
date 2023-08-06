package com.yc.spring.Test5_import;

public class Banana {
    private int id;

    public Banana() {
        System.out.println("Banana被构造了！！！");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "id=" + id +
                '}';
    }
}
