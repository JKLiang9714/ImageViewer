package org.liangjiakun.viewer.action;

import org.liangjiakun.viewer.ViewerFrame;
import org.liangjiakun.viewer.ViewerService;

/**
 * ͼƬ�������Action�ӿ�
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public interface Action {
	/**
	 * ����ִ�з���
	 * @param service ͼƬ�������ҵ������
	 * @param frame ���������
	 */
	void execute(ViewerService service, ViewerFrame frame);
}
