package designpattern.proxy.virtual.withstate;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 显示图片代理类，代理了 ImageIcon （结合状态模式）
 */
public class ImageProxy2 implements Icon {

    /**
     * 被代理对象
     */
    private ImageIcon imageIcon;

    /**
     * 图片URL
     */
    private URL imageURL;

    /**
     * 三种图片状态
     */
    private ImageState unloadState;
    private ImageState loadedState;
    private ImageState nowState;

    public ImageProxy2(URL imageURL) {
        //初始化图片链接及图片状态
        this.imageURL = imageURL;
        unloadState = new UnloadState(this);
        loadedState = new LoadedState(this);
        nowState = unloadState;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        nowState.loadImage(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
        return nowState.getWidth();
    }

    @Override
    public int getIconHeight() {
        return nowState.getHeight();
    }



    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public ImageState getUnloadState() {
        return unloadState;
    }

    public void setUnloadState(ImageState unloadState) {
        this.unloadState = unloadState;
    }

    public ImageState getLoadedState() {
        return loadedState;
    }

    public void setLoadedState(ImageState loadedState) {
        this.loadedState = loadedState;
    }

    public ImageState getNowState() {
        return nowState;
    }

    public void setNowState(ImageState nowState) {
        this.nowState = nowState;
    }

    public URL getImageURL() {
        return imageURL;
    }

    public void setImageURL(URL imageURL) {
        this.imageURL = imageURL;
    }
}
