package designpattern.proxy.virtual;

import javax.swing.*;
import java.awt.*;

/**
 * 单纯的图片组件
 */
public class ImageComponent extends JComponent {

    private Icon icon;

    public ImageComponent(Icon icon) {
        this.icon = icon;
    }

    /**
     * 设置图片
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * 绘制图片
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        //将图片居中
        int x = (800 - w) / 2;
        int y = (600 - h) / 2;
        icon.paintIcon(this, graphics, x, y);

    }
}
