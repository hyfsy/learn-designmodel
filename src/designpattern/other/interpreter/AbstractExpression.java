package designpattern.other.interpreter;

import java.util.Map;

/**
 * 抽象解释器
 */
public abstract class AbstractExpression {

    public abstract int interpreter(Map<String,Integer> context);

}
