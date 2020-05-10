package designpattern.observer.dns;

/**
 * IP记录实体类
 */
public class Recorder {

    //域名
    private String domain;
    //IP
    private String ip;
    //解析地址
    private String owner;

    public Recorder(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "域名：" + domain + '\n' +
                "IP：" + ip + '\n' +
                "解析服务器：" + owner + '\n';
    }
}
