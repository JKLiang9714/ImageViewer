package org.liangjiakun.viewer.action;

import org.liangjiakun.viewer.ViewerFrame;
import org.liangjiakun.viewer.ViewerService;

/**
 * �Ŵ�ͼƬ��Action
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class BigAction implements Action {
	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, true);
	}
}
