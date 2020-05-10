package designpattern.proxy.protect;

public class PersonBeanImpl implements PersonBean {

    private String name;
    private int age;
    private int rating;
    private int ratingCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取受欢迎度
     */
    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return rating / ratingCount;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating = rating;
        ratingCount++;
    }

    @Override
    public String toString() {
        return "PersonBeanImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", ratingCount=" + ratingCount +
                '}';
    }
}
