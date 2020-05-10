package designpattern.other.interpreter;

import java.util.Map;

/**
 * 非终结符表达式（NonTerminalExpression） -
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    /**
     * 返回两个表达式结果的相减
     */
    @Override
    public int interpreter(Map<String,Integer> context) {
        return super.left.interpreter(context) - super.right.interpreter(context);
    }
}
