package designpattern.other.interpreter;

import java.util.Map;
import java.util.Stack;

/**
 * 解析器封装类
 */
public class Calculator {

    private AbstractExpression expression;

    /**
     * 生成抽象语法树，复杂的可能有多个，本例只有一个
     * @param expStr 表达式字符串
     */
    public Calculator(String expStr) {
        expStr = expStr.replace(" ","");
        //安排运算的先后顺序
        Stack<AbstractExpression> stack = new Stack<>();
        //表达式拆分成字符数组
        char[] charArray = expStr.toCharArray();
        AbstractExpression left = null;
        AbstractExpression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    //获取左值的表达式对象
                    left = stack.pop();
                    //获取右边的终结符运算符（值）
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    //将值放入栈中
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        //获取最后的包含所有运算对象的运算对象
        this.expression = stack.pop();
    }

    /**
     * 开始运算
     * @param context K: 操作的字符 V: 对应的参数值
     * @return 运算后的结果
     */
    public int run(Map<String, Integer> context) {
        //给值并开始递归计算
        return this.expression.interpreter(context);
    }

}
