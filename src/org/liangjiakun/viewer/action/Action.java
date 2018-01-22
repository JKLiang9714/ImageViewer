package org.liangjiakun.viewer.action;

import org.liangjiakun.viewer.ViewerFrame;
import org.liangjiakun.viewer.ViewerService;

/**
 * 图片浏览器的Action接口
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public interface Action {
	/**
	 * 具体执行方法
	 * @param service 图片浏览器的业务处理类
	 * @param frame 主界面对象
	 */
	void execute(ViewerService service, ViewerFrame frame);
}
