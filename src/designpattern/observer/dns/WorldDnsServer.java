package designpattern.observer.dns;

/**
 * 世界服务器
 */
public class WorldDnsServer extends DnsServer {
    @Override
    public void sign(Recorder recorder) {
        recorder.setOwner("世界服务器");
    }

    @Override
    public boolean isLocal(Recorder recorder) {
        return true;
    }


}
