package com.inspur.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: YANG
 * Date: 2019/5/12-10:22
 * Description: No Description
 */
public class TestObject {

    public static void main(String[] args){

        Student student1 = new Student(1L, "张三", 22, 80);
        Student student2 = new Student(2L, "李四", 22, 85);
        Student student3 = new Student(3L, "王五", 23, 85);
        Student student4 = new Student(4L, "赵六", 24, 88);
        Student student5 = new Student(5L, "猫三", 25, 80);
        Student student6 = new Student(6L, "狗四", 24, 100);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4, student5, student6);
        studentList.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.groupingBy(Student::getScore)));




    }
}
