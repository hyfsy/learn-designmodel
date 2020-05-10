package designpattern.proxy;

import java.io.InvalidObjectException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 序列化代理（非基本设计模式）
 *
 * 正如保护性拷贝方法一样，序列化代理方法可以阻止伪字节流的攻击以及内部域的盗用攻击
 * 这种方法允许Period类的域为final的
 * 为了确保 Period类真正是不可变的，这一点很有必要
 */
public class Period implements Serializable {

    public static final long serialVersionUID = 1L;
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }

    /**
     * 序列化代理类
     */
    private static class SerializationProxy implements Serializable {

        public static final long serialVersionUID = 1L;
        private final Date start;
        private final Date end;

        public SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        /**
         * 这个方法的出现，导致序列化系统在反序列化时将序列化代理转变回外围类的实例
         */
        private Object readResolve() {
            return new Period(start, end);
        }
    }

    /**
     * writeReplace方法在序列化之前，将外围类的实例转变成了它的序列化代理
     */
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    /**
     * 序列化系统永远不会产生外围类的序列化实例，但是攻击者有可能伪造，企图违反该类的约束条件
     */
    private void readObject(ObjectOutputStream oos) throws InvalidObjectException {
        throw new InvalidObjectException("proxy request");
    }
}

