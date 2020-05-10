package designpattern.iterator.combination;

import java.util.Iterator;

/**
 * 服务员类真正执行遍历操作
 */
public class Waitress {

    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void print(){
        allMenus.print();
    }

    /**
     * 打印为素食的菜单
     */
    public void printVegetarian(){
        Iterator iterator = allMenus.getIterator();
        System.out.println("\nVegetarian Menu\n-----");
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            try {
                //菜单调用 isVegetarian 方法可能抛异常
                if (menuComponent.isVegetarian()) {
                    //只有当对象为菜单项并且是素食时，我们才打印
                    menuComponent.print();
                }
            }catch(UnsupportedOperationException e){

            }
        }
    }

}
