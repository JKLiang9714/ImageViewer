package org.liangjiakun.viewer.action;

import org.liangjiakun.viewer.ViewerFrame;
import org.liangjiakun.viewer.ViewerService;

/**
 * ËõÐ¡Í¼Æ¬µÄAction
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class SmallAction implements Action {
	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, false);
	}
}
