package designpattern.iterator.combination;

import java.util.Iterator;

/**
 * 菜单组件
 * 希望某些子类的某些方法有默认的实现
 *
 * 折衷案例 （同时管理菜单和菜单项）
 * 牺牲单一职责原则提高用户透明性
 *
 * 什么是透明性?
 * 通过让组件的接口同时包含一些管理子节点和叶节点的操作,客户就可以将组合和叶节点一视同仁。
 * 也就是说,一个元素究竟是组合还是叶节点,对客户是透明的。
 */
public class MenuComponent {

    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException();
    }

    public Iterator getIterator(){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }

}
