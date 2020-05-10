package designpattern.other.chainofresponsibility;

/**
 * 妇女接口
 */
public interface IWomen {

    /**
     * 获取对象的当前状态
     */
    int getType();

    /**
     * 获取请求信息
     */
    String getRequest();

}
