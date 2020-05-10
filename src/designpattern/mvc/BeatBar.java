package designpattern.mvc;

import javax.swing.*;

/**
 * 进度条控件，自启动，自改变
 */
public class BeatBar extends JProgressBar implements Runnable {

    private JProgressBar progressBar;
    private Thread thread;

    /**
     * 自启动线程
     */
    public BeatBar(){
        //设置进度条最大值
        setMaximum(100);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for(;;){
            int value = getValue();
            value = (int)(value * .75);
            setValue(value);

            //重新绘制控件
            repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
