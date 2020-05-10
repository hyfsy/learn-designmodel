package designpattern.factory.bean.simple;

public class Pizza {

    private String name;

    public void prepare(){
        System.out.println("准备"+name);
    }

    public void bake(){
        System.out.println("正在烤");
    }

    public void cut(){
        System.out.println("正在切");
    }

    public void box(){
        System.out.println("正在装箱");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
