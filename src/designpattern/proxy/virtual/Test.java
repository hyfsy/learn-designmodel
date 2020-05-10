package designpattern.proxy.virtual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 虚拟代理(资源消耗大的延迟加载)(创建开销大的对象)
 */
public class Test extends JFrame {

    //学习使用Hashtable
    private Hashtable<Integer, String> picTable = new Hashtable<>();
    private ImageComponent imageComponent;
    private JFrame frame = new JFrame("虚拟");
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu= new JMenu("切换图片");
    private JMenuItem item;

    public static void main(String[] args) throws Exception {
        new Test();
    }

    public Test() throws Exception {
        //初始化图片列表
        picTable.put(1, "http://photocdn.sohu.com/20110402/Img305300494.jpg");
        picTable.put(2, "http://seopic.699pic.com/photo/50062/8783.jpg_wh1200.jpg");
        picTable.put(3, "http://img05.jdzj.com/oledit/UploadFile/news2014c/image/20140724/20140724095878967896.jpg");

        //遍历Hashtable，将所有图片放到对应的MenuItem中，并设置点击事件
        for (Enumeration e = picTable.keys(); e.hasMoreElements(); ) {
            //e.nextElement(); 获取key
            JMenuItem item = new JMenuItem(String.valueOf(e.nextElement()));
            //菜单项增加监听点击事件
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //actionCommand 为 new JMenuItem(); 中的值
                    String actionCommand = e.getActionCommand();

                    //菜单点击后重新设置代理类中的图片链接对象
                    imageComponent.setIcon(new ImageProxy(getPicURL(actionCommand)));

                    //重新绘制框架
                    frame.repaint();
                }
            });
            menu.add(item);
        }

        //初始化第一个图片
        URL initialUrl = new URL(picTable.get(picTable.size()));
        Icon icon = new ImageProxy(initialUrl);
        imageComponent = new ImageComponent(icon);

        //建立框架和菜单
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

    }

    /**
     * 获取图片链接对象
     */
    public URL getPicURL(String name) {
        //注意此处Hashtable<Integer,String>调用get(String)不会报错
        String url = picTable.get(Integer.valueOf(name));
        try {
            //获取另一个图片的链接
            return new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

}


