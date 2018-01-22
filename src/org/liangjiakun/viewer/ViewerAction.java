package org.liangjiakun.viewer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import org.liangjiakun.viewer.action.Action;

/**
 * ��������Action��
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class ViewerAction extends AbstractAction {
	private String actionName = "";
	private ViewerFrame frame = null;
	
	//�����������AbstractAction����Ӧ��org.liangjiakun.viewer.action����ĳ��Actionʵȫ
	private Action action = null;
	
	public ViewerAction() {
		super();
	}
	
	/**
	 * ������
	 * 
	 * @param icon
	 * @param actionName
	 * @param frame
	 */
	public ViewerAction(ImageIcon icon, String actionName, ViewerFrame frame) {
		// ���ø��๹����
		super("", icon);
		this.actionName = actionName;
		this.frame = frame;
	}

	/**
	 * ��дvoid actionPerformed(ActionEvent e)����
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ViewerService service = ViewerService.getInstance();
		Action action = getAction(this.actionName);
		// ����Action��execute����
		action.execute(service, frame);
	}

	/**
	 * ͨ��actionName�õ������ʵ��
	 * 
	 * @param actionName
	 * @return
	 */
	private Action getAction(String actionName) {
		try {
			if (this.action == null) {
				// ����Actionʵ��
				Action action = (Action)Class.forName(actionName).newInstance();
				this.action = action;
			}
			return this.action;
		} catch (Exception e) {
			return null;
		}
	}
}
