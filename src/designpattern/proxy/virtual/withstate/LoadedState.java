package designpattern.proxy.virtual.withstate;

import java.awt.*;

/**
 * 图片加载完毕的状态
 */
public class LoadedState implements ImageState {

    private ImageProxy2 imageProxy2;

    public LoadedState(ImageProxy2 imageProxy2) {
        this.imageProxy2 = imageProxy2;
    }

    @Override
    public void loadImage(Component c, Graphics g, int x, int y) {
        //获取图片对象，直接打印显示图片
        imageProxy2.getImageIcon().paintIcon(c, g, x, y);
    }

    @Override
    public int getHeight() {
        return imageProxy2.getImageIcon().getIconHeight();
    }

    @Override
    public int getWidth() {
        return imageProxy2.getImageIcon().getIconWidth();
    }
}
