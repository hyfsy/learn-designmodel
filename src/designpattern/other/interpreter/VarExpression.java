package designpattern.other.interpreter;

import java.util.Map;

/**
 * 终结符表达式（TerminalExpression）,处理运算后的结果
 */
public class VarExpression extends AbstractExpression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * 返回最后的结果
     */
    @Override
    public int interpreter(Map<String, Integer> context) {
        return context.get(this.key);
    }

}
