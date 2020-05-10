package designpattern.proxy.virtual.withstate;

import javax.swing.*;
import java.awt.*;

/**
 * 图片未加载的状态
 */
public class UnloadState implements ImageState {

    private ImageProxy2 imageProxy2;
    private Thread getImageThread;
    private boolean startFind = false;

    public UnloadState(ImageProxy2 imageProxy2) {
        this.imageProxy2 = imageProxy2;
    }

    @Override
    public void loadImage(Component c, Graphics g, int x, int y) {
        if (startFind) {
            return;
        }
        startFind = true;
        //图片对象不存在时，先显示此消息
        g.drawString("正在加载中，请稍后......", x + 300, y + 190);
        getImageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //通过连接 获取并设置真实图片对象
                imageProxy2.setImageIcon(new ImageIcon(imageProxy2.getImageURL(), "image viewer"));
                //改变状态为加载完成
                imageProxy2.setNowState(imageProxy2.getLoadedState());
                //重新绘制图片
                c.repaint();
            }
        });
        getImageThread.start();
    }

    @Override
    public int getWidth() {
        return 800;
    }

    @Override
    public int getHeight() {
        return 600;
    }

}
