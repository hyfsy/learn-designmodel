package designpattern.templatemethod;

/**
 * 模板方法模式
 *      模板方法模式在一个方法中定义一个算法的骨架,而将一些步骤延迟到子类中,
 *      模板方法使得子类可以在不改变算法结构的情况下,重新定义算法中的某些步骤
 */
public class Test {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();

        System.out.println();

        Coffee coffee = new Coffee();
        coffee.prepareRecipe();


        // Arrays.sort();中排序对象要实现Comparator接口
        // 调用了compareTo方法实现排序，此方法(sort())也算是模板方法
    }
}
