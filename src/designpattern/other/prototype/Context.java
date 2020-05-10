package designpattern.other.prototype;

/**
 * 测试浅克隆-内容类
 */
public class Context implements Cloneable {

    /**
     * 邮件主题
     */
    private String subject = "抽奖活动";

    /**
     * 内容
     */
    private String content = "恭喜您获取资格";

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
