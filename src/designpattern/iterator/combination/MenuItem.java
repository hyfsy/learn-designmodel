package designpattern.iterator.combination;

import java.util.Iterator;

/**
 * 菜单项（叶子节点）
 */
public class MenuItem extends MenuComponent {

    private String name;
    private boolean isVegetarian;

    public MenuItem(String name, boolean isVegetarian) {
        this.name = name;
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    @Override
    public void print() {
        System.out.print(name+" ");
        if(isVegetarian){
            System.out.print(" (v)");
        }
        System.out.println();
    }

    /**
     * 返回一个空迭代器
     */
    @Override
    public Iterator getIterator() {
        return new NullIterator();
    }
}
