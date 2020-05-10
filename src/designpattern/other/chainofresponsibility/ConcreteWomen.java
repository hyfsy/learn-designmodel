package designpattern.other.chainofresponsibility;

/**
 * 具体对象
 */
public class ConcreteWomen implements IWomen {

    private int type;

    public ConcreteWomen(int type){
        this.type = type;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return null;
    }

}
