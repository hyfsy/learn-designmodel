package designpattern.other.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户操作使用类-获取上下文
 */
public class Context {

    /**
     * 获取表达式
     */
    public static String getExpStr() {
        System.out.print("请输入表达式：");
        try {
            return (new BufferedReader(new InputStreamReader(System.in))).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取表达式所对应的每个参数的值
     *
     * @param expStr 表达式
     * @return 上下文对象
     */
    public static Map<String, Integer> getContext(String expStr) {
        assert expStr != null;
        //声明上下文对象
        Map<String, Integer> context = new HashMap<>();

        //将每个参数用空格分开
        char[] chars = expStr.replace(" ", "").toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '+':
                case '-':
                    chars[i] = ' ';
                    break;
            }
        }

        //获取每个参数并设置值
        String[] values = String.valueOf(chars).split(" ");
        for (String value : values) {
            //解决重复参数问题
            if (!context.containsKey(value)) {
                try {
                    System.out.print("请输入" + value + "的值：");
                    String var = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    context.put(value, Integer.valueOf(var));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return context;
    }

}
