package designpattern.proxy.virtual.withstate;

import java.awt.*;

/**
 * 图片状态接口
 */
public interface ImageState {

    void loadImage(Component c, Graphics g, int x, int y);

    int getWidth();

    int getHeight();

}
