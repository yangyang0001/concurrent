package com.inspur.jdk8;

import java.io.Serializable;

/**
 * User: YANG
 * Date: 2019/5/12-10:19
 * Description: No Description
 */
public class Student implements Serializable{

    private static final long serialVersionUID = -7192844021206212875L;

    private long id;
    private String name;
    private int age;
    private double score;

    public Student() {

    }

    public Student(long id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
