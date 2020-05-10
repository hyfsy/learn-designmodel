package designpattern.proxy.remote;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息实体类(通过远程代理传输必须实现序列化接口)
 */
public class Message implements Serializable {

    private String name;
    private String info;
    private Date sendTime;

    public Message(String name, String info, Date sendTime) {
        this.name = name;
        this.info = info;
        this.sendTime = sendTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }


    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
