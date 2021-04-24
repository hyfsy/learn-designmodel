package designpattern.other.vistor.dispatch;

/**
 * 伪动态双分派
 *
 * 访问者模式中使用的是伪动态双分派，
 *      所谓的动态单分派就是在运行时依据两个实际类型去判断一个方法的运行行为，
 *      而访问者模式实现的手段是进行了两次动态单分派来达到这个效果
 *
 * 数据结构对象调用的接受访问者对象的方法就是伪动态双分派
 */
public class Test {
    public static void main(String[] args) {
        // Employee.accept(IVisitor) 是第一次动态单分派，动态的是IVisitor
        // IVisitor.visit(this) 是第二次动态单分派，动态的是Employee
        // 合并起来就是动态双分派，不过是通过两次动态单分派实现的，是伪的
        // 另外，visit(this) 不是实际意义上的动态单分派，因为this在编译时就是确定的了
        // 所以第二次的调用 表面上是动态单分派，实际上却是静态双分派
    }
}
