package designpattern.compound;

/**
 * 白鹅实体类
 */
public class WhiteGoose implements GooseQuack {

    @Override
    public void honk(){
        System.out.println("e honk");
    }
}
