package designpattern.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 视图，关联 M、C ，用户有请求传送给 C 去处理，包含组合模式（主界面改变操作同步更新子节点）
 */
public class DJView implements ActionListener, BeatObserver, BPMObserver {

    private BeatModelI beatModelI;
    private BeatControllerI beatControllerI;
    //===============================第一个显示界面============================================
    private JFrame viewFrame;
    private JPanel viewPanel;
    //自写的频率显示器
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;
    //===============================第二个设置界面============================================
    private JFrame controlFrame;
    private JPanel controlPanel;
    private JMenuBar menuBar;
    //菜单 控制开关
    private JMenu menu;
    private JMenuItem startMenuItem;
    private JMenuItem stopMenuItem;
    private JMenuItem exitMenuItem;
    //设置BPM
    private JLabel bpmLabel;
    private JTextField bpmTextField;
    //按钮控制BPM，将请求传给 C
    private JButton setBPMButton;
    private JButton decreaseBPMButton;
    private JButton increaseBPMButton;

    /**
     * 通过控制器创建视图，并给予模型的引用
     */
    public DJView(BeatControllerI beatControllerI, BeatModelI beatModelI) {
        //V 和 M、C 同时关联，所以要传入两个的引用
        this.beatControllerI = beatControllerI;
        this.beatModelI = beatModelI;
        //视图要注册同时成为两个观察者
        beatModelI.registerObserver((BeatObserver) this);
        beatModelI.registerObserver((BPMObserver) this);
    }

    /**
     * 创建所有显示界面的控件对象
     */
    public void createShows() {
        viewFrame = new JFrame("DJ view");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));

        viewPanel = new JPanel(new GridLayout(1, 2));

        beatBar = new BeatBar();
        beatBar.setValue(40);
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);

        //viewPanel中的子Panel
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel);
        //适应大小
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    /**
     * 创建所有设置界面的控件对象
     */
    public void createControls() {
        //新创建的Frame继承外观
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("DJ control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));

        controlPanel = new JPanel(new GridLayout(1, 2));

        menuBar = new JMenuBar();
        menu = new JMenu("settings");

        startMenuItem = new JMenuItem("Start");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beatControllerI.start();
            }
        });

        stopMenuItem = new JMenuItem("Stop");
        menu.add(stopMenuItem);
        stopMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beatControllerI.stop();
            }
        });

        exitMenuItem = new JMenuItem("Quit");
        menu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);

        //创建按钮
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(10, 20));
        decreaseBPMButton = new JButton("<<");
        increaseBPMButton = new JButton(">>");
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);

        //创建文本、按钮等容器
        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(decreaseBPMButton);
        buttonPanel.add(increaseBPMButton);

        //创建将分类的容器组合的容器
        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);

        //文本设置边框及添加到主界面
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);

    }

    /**
     * GUI 上的监听事件
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == setBPMButton) {
            try {
                int bpm = Integer.parseInt(bpmTextField.getText());
                beatControllerI.setBPM(bpm);
            } catch (Exception ex) {
            }
        } else if (e.getSource() == decreaseBPMButton) {
            beatControllerI.decreaseBPM();
        } else if (e.getSource() == increaseBPMButton) {
            beatControllerI.increaseBPM();
        }
    }

    /**
     * 收到拍打的通知更新自己
     */
    @Override
    public void updateBeat() {
        beatBar.setValue(100);
    }

    /**
     * 收到改变BPM的通知作出更新
     */
    @Override
    public void updateBPM() {
        int bpm = beatModelI.getBPM();
        if (bpm == 0) {
            bpmOutputLabel.setText("offline");
        } else {
            bpmOutputLabel.setText("Current BPM: " + bpm);
        }
    }

    /**
     * 控制按钮的启用、禁用
     */
    public void enableStartMenuItem() {
        startMenuItem.setEnabled(true);
    }

    public void enableStopMenuItem() {
        stopMenuItem.setEnabled(true);
    }

    public void disableStartMenuItem() {
        startMenuItem.setEnabled(false);
    }

    public void disableStopMenuItem() {
        stopMenuItem.setEnabled(false);
    }

}
