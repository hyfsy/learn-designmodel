package designpattern.other.interpreter;

/**
 * 运算符抽象类
 */
public abstract class SymbolExpression extends AbstractExpression {

    /**
     * 左右两个表达式
     */
    protected AbstractExpression left;
    protected AbstractExpression right;

    public SymbolExpression(AbstractExpression left, AbstractExpression right){
        this.left = left;
        this.right = right;
    }

}
