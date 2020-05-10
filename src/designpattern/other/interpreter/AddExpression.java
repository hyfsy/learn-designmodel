package designpattern.other.interpreter;

import java.util.Map;

/**
 * 非终结符表达式（NonTerminalExpression） +
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    /**
     * 返回两个表达式结果的相加
     */
    @Override
    public int interpreter(Map<String,Integer> context) {
        return super.left.interpreter(context) + super.right.interpreter(context);
    }
}
