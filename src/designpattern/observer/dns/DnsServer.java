package designpattern.observer.dns;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * 域名解析服务器 抽象类
 *
 * 观察者 + 被观察者
 * 组成一条链
 *
 */
public abstract class DnsServer extends Observable implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Recorder recorder = (Recorder) arg;
        if (isLocal(recorder)) {
            //通过域名解析到IP
            recorder.setIp(randomIP());
            //签名在此处就是谁解析 显示谁的服务器
        } else {
            //通知上级域名服务器
            notifyUpperServer(recorder);
        }
        //此处签名最后会返回用户第一次请求的服务器的签名
        sign(recorder);
    }

    /**
     * 上级域名服务器默认只有一个
     */
    public void setUpperServer(DnsServer dnsServer) {
        super.deleteObserver(dnsServer);
        super.addObserver(dnsServer);
    }

    /**
     * 通知上级域名服务器
     */
    public void notifyUpperServer(Recorder recorder) {
        super.setChanged();
        //带着记录去通知观察者（上级域名服务器）
        super.notifyObservers(recorder);
    }

    /**
     * 服务器签名
     */
    public abstract void sign(Recorder recorder);

    /**
     * 判断服务器中是否有对应域名
     */
    public abstract boolean isLocal(Recorder recorder);

    /**
     * 随机获取IP地址
     */
    public String randomIP() {
        Random random = new Random();
        return random.nextInt(255) + "." + random.nextInt(255) + "." + random.nextInt(255) + "." + random.nextInt(255);
    }
}
