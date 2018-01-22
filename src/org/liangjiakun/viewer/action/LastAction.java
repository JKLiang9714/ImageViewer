package org.liangjiakun.viewer.action;

import org.liangjiakun.viewer.ViewerFrame;
import org.liangjiakun.viewer.ViewerService;

/**
 * ��һ��ͼƬ��Action
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class LastAction implements Action {
	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.last(frame);
	}
}