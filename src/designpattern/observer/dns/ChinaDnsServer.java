package designpattern.observer.dns;

/**
 * 中国服务器
 */
public class ChinaDnsServer  extends DnsServer {
    @Override
    public void sign(Recorder recorder) {
        recorder.setOwner("中国服务器");
    }

    @Override
    public boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".cn");
    }
}
