package designpattern.other.interpreter;

import java.util.Map;

/**
 * 解释器模式
 *
 * 给定一门语言,定义它的文法的一种表示,并定义一个解释器,该解释器使用该表示来解释语言中的句子
 *
 * 优点：解释器是一个简单语法分析工具,它最显著的优点就是扩展性,
 *      修改语法规则只要修改相应的非终结符表达式就可以了,
 *      若扩展语法,则只要增加非终结符类就可以了
 * 缺点：解释器模式会引起类膨胀：每个语法都要产生一个非终结符表达式
 *       采用递归调用，排查困难，解析复杂语法效率低下
 *
 * 尽量不要在重要的模块中使用解释器模式,否则维护会是一个很大的问题。
 * 在项目中可以使用shell, JRuby, Groovy等脚本语言来代替解释器模式,弥补Java编译型语言的不足。
 * 避免使用解释器模式的四则运算,效率和性能各方面表现良好
 *
 * 若你确实遇到“一种特定类型的问题发生的频率足够高”的情况,准备使用解释器模式时,
 * 可以考虑一下Expression4J, MESP (Math Expression String Parser), Jep等开源的解析工具包,
 * 功能都异常强大,而且非常容易使用,效率也还不错,实现太多数的数学运算完全没有问题
 */
public class Test {
    public static void main(String[] args) {

        //获取表达式
        String expStr = Context.getExpStr();
        //获取表达式中变量对应的值map
        Map<String, Integer> context = Context.getContext(expStr);
        //通过表达式获取上下文对象
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果为：" + expStr + " = " + calculator.run(context));
    }


}
