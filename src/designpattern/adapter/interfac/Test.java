package designpattern.adapter.interfac;

/**
 * 接口适配器，其目的是用来优化一个过大的接口的
 */
public class Test {
    public static void main(String[] args) {
        MainAdapter adapter = new ImpA();
        adapter.A();
        adapter.B();
        adapter.C();
    }
}
