package designpattern.other.vistor.dispatch;

/**
 * 动态分派
 *
 * 与静态相反，它不是在编译期确定的方法版本，而是在运行时才能确定
 *
 * 动态分派最典型的应用就是多态的特性(重写)
 */
public class DynamicDispatch {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.test();
        cat.test();
    }

    interface Animal {
        void test();
    }

    static class Dog implements Animal {
        public void test() {
            System.out.println("dog");
        }
    }

    static class Cat implements Animal {
        public void test() {
            System.out.println("cat");
        }
    }

}




