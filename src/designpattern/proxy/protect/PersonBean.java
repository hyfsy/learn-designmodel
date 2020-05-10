package designpattern.proxy.protect;

/**
 * 人接口（实现动态代理必须实现相同的接口）
 */
public interface PersonBean {

    String getName();

    int getAge();

    int getHotOrNotRating();

    void setName(String name);

    void setAge(int age);

    void setHotOrNotRating(int rating);

}
