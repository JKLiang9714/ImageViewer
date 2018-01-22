package org.liangjiakun.viewer;

import javax.swing.JFrame;

/**
 * 图片浏览器入口类
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) {
		ViewerFrame f = new ViewerFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//传入参数null,即可让JFrame 位于屏幕中央
		//若传入一个Component,则JFrame位于该组件的中央
		f.setLocationRelativeTo(null);
	}
}
