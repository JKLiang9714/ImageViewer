package org.liangjiakun.viewer.action;

import org.liangjiakun.viewer.ViewerFrame;
import org.liangjiakun.viewer.ViewerService;

/**
 * 上一张图片的Action
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