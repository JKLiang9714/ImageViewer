package org.liangjiakun.viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

/**
 * 主界面对象
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class ViewerFrame extends JFrame {
	// 设置读图区的宽和高
	private int width = 800;
	private int height = 600;
	// 用一个JLable放置图片
	JLabel label = new JLabel();
	ViewerService service = ViewerService.getInstance();
	
	/**
	 * 构造器
	 */
	public ViewerFrame() {
		super();
		init();
	}
	
	/**
	 * 初始化
	 */
	public void init() {
		// 设置标题
		this.setTitle("看图程序");
		// 设置大小
		this.setPreferredSize(new Dimension(width, height));
		// 创建菜单
		createMenuBar();
		// 创建工具栏
		JPanel toolBar = createToolPanel();
		// 把工具栏和读图区加到JFrame里面
		this.add(toolBar, BorderLayout.NORTH);
		this.add(new JScrollPane(label), BorderLayout.CENTER);
		// 设置为可见
		this.setVisible(true);
		this.pack();
	}
	
	/**
	 * 获取JLabel
	 * 
	 * @return
	 */
	public JLabel getLabel() {
		return this.label;
	}

	/**
	 * 创建工具栏
	 * 
	 * @return
	 */
	private JPanel createToolPanel() {
		// 创建一个JPanel
		JPanel panel = new JPanel();
		// 创建一个标题为"工具"的工具栏
		JToolBar toolBar = new JToolBar("工具");
		// 设置为不可拖动
		toolBar.setFloatable(false);
		// 设置布局方式
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		// 工具数组
		String[] toolarr = {"org.liangjiakun.viewer.action.OpenAction",
				"org.liangjiakun.viewer.action.LastAction", 
				"org.liangjiakun.viewer.action.NextAction", 
				"org.liangjiakun.viewer.action.BigAction", 
				"org.liangjiakun.viewer.action.SmallAction"};
		for (int i = 0; i < toolarr.length; i++) {
			ViewerAction action = new ViewerAction(
					new ImageIcon("img/" + toolarr[i] + ".gif"), 
					toolarr[i], this);
			// 以图标创建一个button
			JButton button = new JButton(action);
			toolBar.add(button);
		}
		panel.add(toolBar);
		return panel;
	}

	/**
	 * 创建菜单栏
	 */
	private void createMenuBar() {
		// 传建一个JMenuBar放置菜单
		JMenuBar menuBar = new JMenuBar();
		// 菜单文字数组，以下面的menuItemArr一一对应
		String[] menuArr = {"文件(F)", "工具(T)", "帮助(H)"};
		// 菜单项文字数组
		String[][] menuItemArr = {{"打开(O)", "-", "退出(X)"},
				{"放大(M)", "缩小(O)", "-", "上一个(X)", "下一个(P)"},
				{"帮助主题", "关于"}};
		// 遍历menuArr与menuItemArr去创建菜单
		for (int i = 0; i < menuArr.length; i++) {
			// 新建一个JMenu菜单
			JMenu menu = new JMenu(menuArr[i]);
			for (int j = 0; j < menuItemArr[i].length; j++) {
				// 如果menuItemArr[i][j]等于"-"
				if (menuItemArr[i][j].equals("-")) {
					// 设置菜单分隔
					menu.addSeparator();
				} else {
					// 新建一个JMenuItem菜单项
					JMenuItem menuItem = new JMenuItem(menuItemArr[i][j]);
					menuItem.addActionListener(menuListener);
					// 把菜单项加到菜单里
					menu.add(menuItem);
				}
			}
			// 把菜单加到JMenuBar上
			menuBar.add(menu);
		}
		// 设置JMenuBar
		this.setJMenuBar(menuBar);
	}
	
	// 加给菜单的事件监听器
	ActionListener menuListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			service.menuDo(ViewerFrame.this, e.getActionCommand());
		}
	};
}
