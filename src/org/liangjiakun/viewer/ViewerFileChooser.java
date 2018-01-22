package org.liangjiakun.viewer;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * �ļ��Ի������
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class ViewerFileChooser extends JFileChooser {
	/**
	 * ʹ��һ��Ĭ��·������һ��ImageFileChooser
	 */
	public ViewerFileChooser() {
		super();
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}
	
	/**
	 * ʹ���Զ����·��·������һ��ViewerFileChooser
	 * 
	 * @param currentDirectoryPath
	 */
	public ViewerFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}

	/**
	 * �����ļ�������
	 */
	private void addFilter() {
		this.addChoosableFileFilter(new MyFileFilter(new String[] {".BMP"},
				"BMP (*.BMP)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] {".JPG",
				".JPEG", ".JPE", ".JFIF"},
				"JPEG (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] {".GIF"},
				"GIF (*.GIF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] {".TIF",
				".TIFF"}, "TIFF (*.TIF;*.TIFF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] {".PNG"},
				"PNG (*.PNG)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] {".ICO"},
				"ICO (*.ICO)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP",
				".JPG", ".JPEG", ".JPE", ".JFIF", ".GIF", ".TIF", ".TIFF",
				".PNG", ".ICO" }, "����ͼ���ļ�"));
	}
	
	class MyFileFilter extends FileFilter {
		// ��׺������
		String[] suffarr;
		// ����
		String desciption;
		
		public MyFileFilter() {
			super();
		}
		
		/**
		 * �ð�����׺������������������һ��MyFileFilter
		 * 
		 * @param suffarr
		 * @param description
		 */
		public MyFileFilter(String[] suffarr, String description) {
			super();
			this.suffarr = suffarr;
			this.desciption = description;
		}
		
		/**
		 * ��дboolean accept(File f)����
		 */
		public boolean accept(File f) {
			// ����ļ��ĺ�׺���Ϸ�������true
			for (String s : this.suffarr) {
				if (f.getName().toUpperCase().endsWith(s)) {
					return true;
				}
			}
			// �����Ŀ¼������true����false
			return f.isDirectory();
		}
		
		/**
		 * ����������Ϣ
		 */
		public String getDescription() {
			return this.desciption;
		}
	}
}