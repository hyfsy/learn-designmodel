package designpattern.observer.dns;

/**
 * 观察者模式 仿照 责任链模式
 *
 * 触发链
 *
 * 责任链传递过程中不能改变传递对象
 * 触发连传递过程中可以改变，只要保证相邻两个节点的消息对象固定
 *
 * 上下节点的关系不同
 * 消息的分销渠道不同
 */
public class Test {
    public static void main(String[] args) {
        //创建一条DNS解析记录
        Recorder recorder = new Recorder("www.baidu.com");
        //创建服务器
        DnsServer shDnsServer = new SHDnsServer();
        DnsServer chinaDnsServer = new ChinaDnsServer();
        DnsServer worldDnsServer = new WorldDnsServer();
        //设置下一个责任人
        shDnsServer.setUpperServer(chinaDnsServer);
        chinaDnsServer.setUpperServer(worldDnsServer);
        //通知第一个服务器
        shDnsServer.update(null, recorder);
        //打印解析结果
        System.out.println(recorder);
    }
}
