package com.example.t7830.test4;

import java.util.List;

/**
 * Created by t7830 on 2018/3/26.
 */

public class Person {
    private String name;
    private String sex;
    private int age;
    private Boolean isHistory,isSuspense,isLiterary;
    private String time;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +'\''+
                ",time=" + time+'\''+"爱好历史:"+isHistory+"爱好悬疑:"+isSuspense+"爱好文艺:"+isLiterary+
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getLiterary() {
        return isLiterary;
    }

    public void setLiterary(Boolean literary) {
        isLiterary = literary;
    }

    public Boolean getSuspense() {
        return isSuspense;
    }

    public void setSuspense(Boolean suspense) {
        isSuspense = suspense;
    }

    public Boolean getHistory() {
        return isHistory;
    }

    public void setHistory(Boolean history) {
        isHistory = history;
    }
}
