package designpattern.other.prototype;

/**
 * 邮件类
 */
public class Mail implements Cloneable {

    /**
     * 收件人
     */
    private String receiver;

    /**
     * 右键主题
     */
    private String subject;

    /**
     * 称谓
     */
    private String appellation;

    /**
     * 无法通过浅克隆 克隆引用对象（克隆对象与原对象指向相同）
     */
    private Context context;

    /**
     * 尾部信息
     */
    private String tail;

    /**
     * 调用克隆方法时，不会被执行
     */
    public Mail() {
        System.out.println("构造函数被执行");
    }

    public Mail(Context context) {
        this.subject = context.getSubject();
        this.context = context;
    }

    /**
     * 主要的克隆方法
     *
     * final 类型修饰的成员变量不能进行深拷贝，此处如类内的context对象
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅拷贝
//        return super.clone();

        //深拷贝
        Mail mail = (Mail) super.clone();
        //将引用对象也一起拷贝
        mail.context = (Context) this.context.clone();
        return mail;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
