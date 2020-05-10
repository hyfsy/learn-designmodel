package designpattern.other.vistor.dispatch;

/**
 * 静态分派
 *
 * 静态分派就是按照变量的静态类型进行分派，从而确定方法的执行版本，
 *      静态分派在编译时期就可以确定方法的版本
 *
 * 静态分派最典型的应用就是方法重载
 */
public class StaticDispatch {

    public void test(String string){
        System.out.println("this is string");
    }

    public void test(Integer integer){
        System.out.println("this is integer");
    }

    public static void main(String[] args) {
        String s1 ="aaaaa";
        Integer a = 1;
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.test(a);
        staticDispatch.test(s1);
    }

}
