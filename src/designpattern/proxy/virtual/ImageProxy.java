package designpattern.proxy.virtual;

import designpattern.proxy.virtual.withstate.ImageState;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 显示图片代理类，代理了 ImageIcon
 */
public class ImageProxy implements Icon {

    /**
     * 被代理对象
     */
    private ImageIcon imageIcon;

    /**
     * 图片URL
     */
    private URL imageURL;

    /**
     * 创建图片线程
     */
    private Thread getImageThread;

    /**
     * 创建图片线程只启动一次
     */
    private boolean startFind = false;

    private ImageState imageState;

    public ImageProxy(URL imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        //有图片直接打印显示
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            //图片对象不存在时，先显示此消息
            g.drawString("正在加载图片，请稍后......", x + 300, y + 190);
            if (!startFind) {
                startFind = true;
                //开启额外线程去获取图片
                getImageThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //获取真实图片对象
                            imageIcon = new ImageIcon(imageURL, "CD over");
                            //重新绘制图片
                            c.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                getImageThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon == null) {
            return 600;
        } else {
            return imageIcon.getIconWidth();
        }
    }

    @Override
    public int getIconHeight() {
        if (imageIcon == null) {
            return 400;
        } else {
            return imageIcon.getIconHeight();
        }
    }

    public ImageState getImageState() {
        return imageState;
    }

    public void setImageState(ImageState imageState) {
        this.imageState = imageState;
    }
}
