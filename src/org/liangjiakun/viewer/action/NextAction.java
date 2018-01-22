package org.liangjiakun.viewer.action;

import org.liangjiakun.viewer.ViewerFrame;
import org.liangjiakun.viewer.ViewerService;

/**
 * 下一张图片的Action
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class NextAction implements Action {
	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.next(frame);
	}
}