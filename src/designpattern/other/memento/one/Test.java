package designpattern.other.memento.one;

/**
 * 自述历史模式（三合一）
 */
public class Test {
    public static void main(String[] args) {

        //创建三合一对象
        Originator originator = new Originator("状态1");
        System.out.println("初始状态：" + originator.getStatus());

        //保存状态并改变
        originator.saveMemento();
        originator.setStatus("status one");
        System.out.println("改变状态：" + originator.getStatus());

        //还原备份
        originator.restoreMemento();
        System.out.println("还原状态：" + originator.getStatus());


    }
}
