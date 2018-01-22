package org.liangjiakun.viewer;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * 文件对话框对象
 * 
 * @author Liang Jiakun
 * @version 1.0
 */
public class ViewerFileChooser extends JFileChooser {
	/**
	 * 使用一个默认路径创建一个ImageFileChooser
	 */
	public ViewerFileChooser() {
		super();
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}
	
	/**
	 * 使用自定义的路径路径创建一个ViewerFileChooser
	 * 
	 * @param currentDirectoryPath
	 */
	public ViewerFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}

	/**
	 * 增加文件过滤器
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
				".PNG", ".ICO" }, "所有图形文件"));
	}
	
	class MyFileFilter extends FileFilter {
		// 后缀名数组
		String[] suffarr;
		// 描述
		String desciption;
		
		public MyFileFilter() {
			super();
		}
		
		/**
		 * 用包含后缀名的数组与描述创建一个MyFileFilter
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
		 * 重写boolean accept(File f)方法
		 */
		public boolean accept(File f) {
			// 如果文件的后缀名合法，返回true
			for (String s : this.suffarr) {
				if (f.getName().toUpperCase().endsWith(s)) {
					return true;
				}
			}
			// 如果是目录，返回true或者false
			return f.isDirectory();
		}
		
		/**
		 * 返回描述信息
		 */
		public String getDescription() {
			return this.desciption;
		}
	}
}