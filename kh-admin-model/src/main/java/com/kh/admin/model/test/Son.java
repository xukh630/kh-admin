package com.kh.admin.model.test;

/**
 * 所在的包名: com.kh.admin.model.test
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 1:16 2017/9/24
 */
public class Son extends Father{

    private String age;

    private String name;

    public Son() {
        super();
    }

    public Son(String money) {
        super();
    }



    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
