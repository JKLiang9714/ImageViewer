package org.liangjiakun.viewer;

import javax.swing.JFrame;

/**
 * ͼƬ����������
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) {
		ViewerFrame f = new ViewerFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�������null,������JFrame λ����Ļ����
		//������һ��Component,��JFrameλ�ڸ����������
		f.setLocationRelativeTo(null);
	}
}
