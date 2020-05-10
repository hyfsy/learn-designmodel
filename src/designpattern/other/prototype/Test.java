package designpattern.other.prototype;

import java.util.Random;

/**
 * 原型模式
 *  用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象
 *
 * 浅拷贝：不会拷贝对象引用（不包括String）
 * 深拷贝：对象引用手动拷贝
 *
 * 拷贝不会执行类的构造函数
 *      Object 类的 clone 方法的原理是从内存中（具体的说就是堆内存）
 *      以二进制流的方式进行拷贝，重新分配一个内存块
 *
 * final修饰的成员变量不能深拷贝
 *
 * String是没有clone方法的,处理机制也比较特殊,通过字符串池(stringPool)
 *      在需要的时候才在内存中创建新的字符串
 */
public class Test {

    /**
     * 发送邮件数
     */
    private static final int MAX_COUNT = 6;

    public static void main(String[] args) {
        Mail mail = new Mail(new Context());
        mail.setAppellation("先生/女士");
        try {
            Mail cloneMail = null;
            for (int i = 0; i < MAX_COUNT; i++) {
                //使用克隆创建原型对象，内部的context对象指向不同的引用（深拷贝）
                cloneMail = (Mail) mail.clone();
                cloneMail.setReceiver(getRandomString());
                cloneMail.setTail(getRandomString() + "公司");
                sendMail(cloneMail);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送邮件
     */
    public static void sendMail(Mail mail) {
        System.out.print("\t收件人：" + mail.getReceiver() + mail.getAppellation());
        System.out.print("\t主题：" + mail.getSubject());
        System.out.print("\t" + mail.getContext().getContent());
        System.out.println("\t" + mail.getTail());
    }

    /**
     * 随机获取五位字符
     */
    public static String getRandomString() {
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();
    }

}
