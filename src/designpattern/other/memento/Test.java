package designpattern.other.memento;

/**
 * 备忘录模式
 *
 * 在不破坏封装性的前提下,捕获一个对象的内部状态,在该对象之外保存这个状态。
 *      这样以后就可将该对象恢复到原先保存的状态
 *
 * 白箱模式（备忘录可操作）
 * 黑箱模式（备忘录不可操作）
 * 多重检查点模式（多个状态点任意切换）
 * 自述历史模式（发起人做全部的工作）
 *
 * 双接口设计方法（宽接口、窄接口）
 * 双接口设计,一个类可以实现多个接口,在系统设计时,如果考虑对象的安全问题,则可以提供两个接口
 *      宽接口：
 *      业务的正常接口,实现必要的业务逻辑,叫做宽接口
 *      窄接口：
 *      一个空接口,什么方法都没有,其目的是提供给子系统外的模块访问，比如容器对象
 *      由于窄接口中没有提供任何操纵数据的方法,因此相对来说比较安全
 *
 */
public class Test {
    public static void main(String[] args) {

        //管理者对象
        Caretaker caretaker = new Caretaker();

        //骑士对象
        Knight knight = new Knight(100, 100, 100);
        IMemento iMemento = knight.saveStatus();
        caretaker.saveMemento("zero", iMemento);
        System.out.println(knight);


        //===============================减少骑士的状态=================================

        knight.reduceStatus();
        IMemento iMemento1 = knight.saveStatus();
        caretaker.saveMemento("one", iMemento1);
        System.out.println(knight);

        knight.reduceStatus();
        IMemento iMemento2 = knight.saveStatus();
        caretaker.saveMemento("two", iMemento2);
        System.out.println(knight);

        knight.reduceStatus();
        IMemento iMemento3 = knight.saveStatus();
        caretaker.saveMemento("three", iMemento3);
        System.out.println(knight);


        //===============================还原状态=======================================

        knight.restoreStatus(caretaker.restoreMemento("two"));
        System.out.println("还原状态2：" + knight);

    }
}
