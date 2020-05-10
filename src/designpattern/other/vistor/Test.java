package designpattern.other.vistor;

/**
 * 访问者模式
 *
 * 封装一些作用于某种数据结构中的各元素的操作,
 *      它可以在不改变数据结构的前提下定义作用于这些元素的新的操作
 *
 * 优点：
 *      1、使得对象结构和作用于结构上的操作解耦，使得操作集合可以独立变化
 *      2、优秀的扩展性，由于职责分开,继续增加对数据的操作是非常快捷的
 * 缺点：
 *      1、具体元素对访问者公布细节
 *              访问者要访问一个类就必然要求这个类公布一些方法和数据,
 *              也就是说访问者关注了其他类的内部细节,这是迪米特法则所不建议的。
 *      2、具体元素变更比较困难
 *              具体元素角色的增加、删除、修改都是比较困难的,就我们的这个例子,
 *              你想想,你要是想增加一个成员变量,如年龄age, Visitor就需要修改,
 *              如果Visitor是一个还好办,多个呢?业务逻辑再复杂点呢?
 *      3、违背了依赖倒置转原则
 *              访问者依赖的是具体元素,而不是抽象元素,这破坏了依赖倒置原则,
 *              特别是在面向对象的编程中,抛弃了对接口的依赖,而直接依赖实现类,扩展比较难。
 *
 */
public class Test {
    public static void main(String[] args) {

        //结构对象，包含某种数据结构
        ObjectStructure os = new ObjectStructure();

        //创建两个访问者
        IShowVisitor showVisitor = new ShowVisitor();
        ITotalVisitor totalVisitor = new TotalVisitor();

        //此处也可以写入到 ObjectStructure 中去
        for (Employee employee : os.getEmployeeList()) {
            //让基本信息访问者访问自己，生成数据
            employee.accept(showVisitor);
            //让工资总和访问者访问自己，生成数据
            employee.accept(totalVisitor);
        }

        //展示访问过后的结果
        showVisitor.report();
        totalVisitor.countTotalSalary();

    }

}
