package org.liangjiakun.viewer.action;

import org.liangjiakun.viewer.ViewerFrame;
import org.liangjiakun.viewer.ViewerService;

/**
 * ´ò¿ªÍ¼Æ¬µÄAction
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class OpenAction implements Action {
	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.open(frame);
	}
}
