package org.liangjiakun.viewer;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.filechooser.FileFilter;

/**
 * ͼƬ�����ҵ����
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class ViewerService {
	private static ViewerService service = null;
	// �½�һ��ViewerFileChooser
	private ViewerFileChooser fileChooser = new ViewerFileChooser();
	// �Ŵ����С�ı���
	private double range = 0.2;
	// Ŀǰ���ļ���
	private File currentDirectory = null;
	// Ŀǰ�ļ����µ�����ͼƬ�ļ�
	private List<File> currentFiles = null;
	// ĿǰͼƬ�ļ�
	private File currentFile = null;
	
	/**
	 * ˽�й�����
	 */
	private ViewerService() {
	}
	
	/**
	 * ��ȡ��̬ʵ��
	 * 
	 * @return
	 */
	public static ViewerService getInstance() {
		if (service == null) {
			service = new ViewerService();
		}
		return service;
	}
	
	/**
	 * ��ͼƬ
	 * 
	 * @param frame
	 */
	public void open(ViewerFrame frame) {
		// ���ѡ���
		if (fileChooser.showOpenDialog(frame) == ViewerFileChooser.APPROVE_OPTION) {
			// ��Ŀǰ�򿪵��ļ���ֵ
			this.currentFile = fileChooser.getSelectedFile();
			// ��ȡ�ļ�·��
			String name = this.currentFile.getPath();
			// ��ȡĿǰ�ļ���
			File cd = fileChooser.getCurrentDirectory();
			// ����ļ����иı�
			if (cd != this.currentDirectory || this.currentDirectory == null) {
				// ���fileChooser������FileFilter
				FileFilter[] fileFilters = fileChooser.getChoosableFileFilters();
				File[] files = cd.listFiles();
				this.currentFiles = new ArrayList<File>();
				for (File file : files) {
					for (FileFilter filter : fileFilters) {
						// �����ͼƬ�ļ�
						if (filter.accept(file)) {
							// ���ļ����ص�currentFiles
							this.currentFiles.add(file);
						}
					}
				}
			}
			ImageIcon icon = new ImageIcon(name);
			frame.getLabel().setIcon(icon);
		}
	}
	
	/**
	 * ��Ӧ�˵��Ķ���
	 * 
	 * @param frame
	 * @param cmd
	 */
	public void menuDo(ViewerFrame frame, String cmd) {
		// ��
		if (cmd.equals("��(O)")) {
			open(frame);
		}
		// �Ŵ�
		if (cmd.equals("�Ŵ�(M)")) {
			zoom(frame, true);
		}
		// ��С
		if (cmd.equals("��С(O)")) {
			zoom(frame, false);
		}
		// ��һ��
		if (cmd.equals("��һ��(X)")) {
			last(frame);
		}
		// ��һ��
		if (cmd.equals("��һ��(P)")) {
			next(frame);
		}
		// �˳�
		if (cmd.equals("�˳�(X)")) {
			System.exit(0);
		}
	}

	/**
	 * ��һ��
	 * 
	 * @param frame
	 */
	public void next(ViewerFrame frame) {
		// ����д򿪰���ͼƬ���ļ���
		if (this.currentFiles != null && !this.currentFiles.isEmpty()) {
			int index = this.currentFiles.indexOf(this.currentFile) + 1;
			// ����һ��
			if (index + 1 < this.currentFiles.size()) {
				File file = (File)this.currentFiles.get(index + 1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile = file;
			}
		}
	}

	/**
	 * ��һ��
	 * 
	 * @param frame
	 */
	public void last(ViewerFrame frame) {
		// ����д򿪰���ͼƬ���ļ���
		if (this.currentFiles != null && !this.currentFiles.isEmpty()) {
			int index = this.currentFiles.indexOf(this.currentFile);
			// ����һ��
			if (index > 0) {
				File file = (File) this.currentFiles.get(index - 1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile = file;
			}
		}
	}

	/**
	 * �Ŵ���С
	 * 
	 * @param frame
	 * @param isEnlarge
	 */
	public void zoom(ViewerFrame frame, boolean isEnlarge) {
		// ��ȡ�Ŵ������С�ĳ˱�
		double enLargeRange = isEnlarge ? 1 + range : 1 - range;
		// ��ȡĿǰ��ͼƬ
		ImageIcon icon = (ImageIcon)frame.getLabel().getIcon();
		if (icon != null) {
			int width = (int)(icon.getIconWidth() * enLargeRange);
			// ��ȡ�ı��С���ͼƬ
			ImageIcon newIcon = new ImageIcon(
					icon.getImage().getScaledInstance(width, -1, Image.SCALE_DEFAULT));
			// �ı���ʾ��ͼƬ
			frame.getLabel().setIcon(newIcon);
		}
	}
}
