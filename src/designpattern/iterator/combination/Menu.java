package designpattern.iterator.combination;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 菜单（组合）
 */
public class Menu extends MenuComponent {

    private String name;
    private List<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponents.get(index);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("\n" + name);
        System.out.println("------------------");

        //此处的迭代器为内部迭代器
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            //执行每个菜单项的打印操作
            iterator.next().print();
        }
    }

    @Override
    public Iterator getIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}
