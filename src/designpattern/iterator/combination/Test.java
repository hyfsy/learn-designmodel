package designpattern.iterator.combination;

/**
 * 组合模式
 *      组合模式允许你将对象组合成树形结构来表现"整体/部分"层次结构。
 *      组合能让客户以一致的方式处理个别对象以及对象组合
 *      组合模式以单一责任设计原则换取透明性(transparency)
 *
 * @see MenuComponent
 */
public class Test {
    public static void main(String[] args) {

        //组合-菜单
        MenuComponent breakfast = new Menu("Breakfast");
        MenuComponent lunch = new Menu("Lunch");
        MenuComponent dinner = new Menu("Dinner");
        MenuComponent dessert = new Menu("Dessert");

        //根组合-菜单
        MenuComponent allMenus = new Menu("AllMenu");
        allMenus.add(breakfast);
        allMenus.add(lunch);
        allMenus.add(dinner);
        allMenus.add(dessert);

        //添加菜单项
        breakfast.add(new MenuItem("egg", false));
        breakfast.add(new MenuItem("milk", false));
        lunch.add(new MenuItem("greenVegetable", true));
        lunch.add(new MenuItem("chinese cabbage", true));

        //创建服务员
        Waitress waitress = new Waitress(allMenus);
        //实际上调用根节点的打印方法
        waitress.print();

        waitress.printVegetarian();

    }
}
