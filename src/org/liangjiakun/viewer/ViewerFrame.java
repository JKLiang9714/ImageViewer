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
 * ���������
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class ViewerFrame extends JFrame {
	// ���ö�ͼ���Ŀ�͸�
	private int width = 800;
	private int height = 600;
	// ��һ��JLable����ͼƬ
	JLabel label = new JLabel();
	ViewerService service = ViewerService.getInstance();
	
	/**
	 * ������
	 */
	public ViewerFrame() {
		super();
		init();
	}
	
	/**
	 * ��ʼ��
	 */
	public void init() {
		// ���ñ���
		this.setTitle("��ͼ����");
		// ���ô�С
		this.setPreferredSize(new Dimension(width, height));
		// �����˵�
		createMenuBar();
		// ����������
		JPanel toolBar = createToolPanel();
		// �ѹ������Ͷ�ͼ���ӵ�JFrame����
		this.add(toolBar, BorderLayout.NORTH);
		this.add(new JScrollPane(label), BorderLayout.CENTER);
		// ����Ϊ�ɼ�
		this.setVisible(true);
		this.pack();
	}
	
	/**
	 * ��ȡJLabel
	 * 
	 * @return
	 */
	public JLabel getLabel() {
		return this.label;
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	private JPanel createToolPanel() {
		// ����һ��JPanel
		JPanel panel = new JPanel();
		// ����һ������Ϊ"����"�Ĺ�����
		JToolBar toolBar = new JToolBar("����");
		// ����Ϊ�����϶�
		toolBar.setFloatable(false);
		// ���ò��ַ�ʽ
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		// ��������
		String[] toolarr = {"org.liangjiakun.viewer.action.OpenAction",
				"org.liangjiakun.viewer.action.LastAction", 
				"org.liangjiakun.viewer.action.NextAction", 
				"org.liangjiakun.viewer.action.BigAction", 
				"org.liangjiakun.viewer.action.SmallAction"};
		for (int i = 0; i < toolarr.length; i++) {
			ViewerAction action = new ViewerAction(
					new ImageIcon("img/" + toolarr[i] + ".gif"), 
					toolarr[i], this);
			// ��ͼ�괴��һ��button
			JButton button = new JButton(action);
			toolBar.add(button);
		}
		panel.add(toolBar);
		return panel;
	}

	/**
	 * �����˵���
	 */
	private void createMenuBar() {
		// ����һ��JMenuBar���ò˵�
		JMenuBar menuBar = new JMenuBar();
		// �˵��������飬�������menuItemArrһһ��Ӧ
		String[] menuArr = {"�ļ�(F)", "����(T)", "����(H)"};
		// �˵�����������
		String[][] menuItemArr = {{"��(O)", "-", "�˳�(X)"},
				{"�Ŵ�(M)", "��С(O)", "-", "��һ��(X)", "��һ��(P)"},
				{"��������", "����"}};
		// ����menuArr��menuItemArrȥ�����˵�
		for (int i = 0; i < menuArr.length; i++) {
			// �½�һ��JMenu�˵�
			JMenu menu = new JMenu(menuArr[i]);
			for (int j = 0; j < menuItemArr[i].length; j++) {
				// ���menuItemArr[i][j]����"-"
				if (menuItemArr[i][j].equals("-")) {
					// ���ò˵��ָ�
					menu.addSeparator();
				} else {
					// �½�һ��JMenuItem�˵���
					JMenuItem menuItem = new JMenuItem(menuItemArr[i][j]);
					menuItem.addActionListener(menuListener);
					// �Ѳ˵���ӵ��˵���
					menu.add(menuItem);
				}
			}
			// �Ѳ˵��ӵ�JMenuBar��
			menuBar.add(menu);
		}
		// ����JMenuBar
		this.setJMenuBar(menuBar);
	}
	
	// �Ӹ��˵����¼�������
	ActionListener menuListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			service.menuDo(ViewerFrame.this, e.getActionCommand());
		}
	};
}
