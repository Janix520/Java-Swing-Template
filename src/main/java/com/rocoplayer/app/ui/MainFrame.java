package com.rocoplayer.app.ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import com.rocoplayer.app.App;
import com.rocoplayer.app.config.AppConfig;

/**
 * 主界面
 * @author ZJ
 *
 */
public class MainFrame {

	/**
	 * 
	 */
	public void init() {
		
		JFrame window = new JFrame(AppConfig.title);
		window.setSize(AppConfig.stageWidth, AppConfig.stageHeight);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(AppConfig.stageResizable);
		window.setLocationRelativeTo(null);
		
		//app图标
		Image image = new ImageIcon(App.class.getResource(AppConfig.icon)).getImage();
		window.setIconImage(image);

		//约束布局
		SpringLayout springLayout = new SpringLayout();
		window.setLayout(springLayout);
		
		// 设为null是绝对定位，setLocation才有效
//		aWindow.setLayout(null);
		JButton jButton = new JButton("按钮");
		jButton.setSize(60, 30);
		
		// 约束，jButton距离window的上边50，距离左边50
		springLayout.putConstraint(SpringLayout.NORTH, jButton, Spring.constant(50), SpringLayout.NORTH, window);
		springLayout.putConstraint(SpringLayout.WEST, jButton, Spring.constant(50), SpringLayout.NORTH, window);
		window.add(jButton);
		
		//设置绝对定位
//        jButton.setLocation(50, 50);

		jButton.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "You are clicked !");
		});

		
		//滑动条
		JSlider jSlider = new JSlider(JSlider.HORIZONTAL);
		window.add(jSlider);
		springLayout.putConstraint(SpringLayout.NORTH, jSlider, Spring.constant(250), SpringLayout.NORTH, window);
		springLayout.putConstraint(SpringLayout.WEST, jSlider, Spring.constant(50), SpringLayout.WEST, window);
		
		
		//用户名
		JLabel jLabel = new JLabel("用户名");
		window.add(jLabel);
		springLayout.putConstraint(SpringLayout.NORTH, jLabel, Spring.constant(350), SpringLayout.NORTH, window);
		springLayout.putConstraint(SpringLayout.WEST, jLabel, Spring.constant(50), SpringLayout.WEST, window);
		
		
		//输入框
		JEditorPane jEditorPane = new JEditorPane();
		window.add(jEditorPane);
		springLayout.putConstraint(SpringLayout.NORTH, jEditorPane, Spring.constant(350), SpringLayout.NORTH, window);
		springLayout.putConstraint(SpringLayout.WEST, jEditorPane, Spring.constant(90), SpringLayout.WEST, window);
		
		
		
		// 监听窗体的大小改变事件，以便重新定位按钮
		window.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = window.getWidth();
				int height = window.getHeight();
				
			}
		});


		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("This Is a Menubar");
		
		window.setJMenuBar(menuBar);

		JMenu menu1 = new JMenu("Menu");
		menuBar.add(menu1);
		JMenuItem helloName = new JMenuItem("Say Hello");
		menu1.add(helloName);
		
		helloName.setToolTipText("This is a MenuItem");
		
		helloName.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Hello !");
		});

		JMenu menu = new JMenu("Exit");
		menuBar.add(menu);
		JMenuItem mntmClose = new JMenuItem("Close");
		
		//绑定快捷键，ctrl+q直接退出程序
		mntmClose.setMnemonic(KeyEvent.VK_Q);
		mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		mntmClose.setToolTipText("Exit this app");
		
		mntmClose.addActionListener(e -> {
			System.exit(0);
		});

		menu.add(mntmClose);

//		window.pack(); //根据内容自动调整框架大小
		
		//最后显示window
		window.setVisible(true);


	}
	
}
