package designpattern.observer.dns;

/**
 * 上海服务器
 */
public class SHDnsServer extends DnsServer {

    @Override
    public void sign(Recorder recorder) {
        recorder.setOwner("上海服务器");
    }

    @Override
    public boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".sh.cn");
    }

}
