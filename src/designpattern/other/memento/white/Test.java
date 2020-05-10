package designpattern.other.memento.white;

/**
 * 白箱模式
 */
public class Test {
    public static void main(String[] args) {

        Caretaker caretaker = new Caretaker();

        //生成发起人
        Originator originator = new Originator("状态1");
        System.out.println("初始状态：" + originator.getStatus());

        //创建备份
        caretaker.setMemento(originator.createMemento());
        //改变发起人状态
        originator.setStatus("status one");
        System.out.println("改变状态：" + originator.getStatus());

        //还原备份
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("还原状态：" + originator.getStatus());

    }
}
