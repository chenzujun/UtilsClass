package com.common.util.document;

import java.io.*;
import java.util.Properties;


public class FileUtils {

	/**
	 * 读取txt文件
	 * @return
	 */
	public static String readFile(){
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(new File("C:\\Users\\chenjun01\\Desktop\\input.txt")));
			String s;
			int i = 0;
			while ((s = br.readLine()) != null) {
				i++;
				System.out.println("第" + i + "行");
				String[] arr = s.split("\t");
				sb.append(arr[0]+"\t"+arr[1]+"\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 写txt文件
	 * @param str
	 */
	public static void writeFile(String str) {
		try {
			File writeName = new File("C:\\Users\\chenjun01\\Desktop\\output.txt");
			writeName.createNewFile();
			// try(){}catch(){}
			// 从 Java 7 build 105 版本开始，Java 7 的编译器和运行环境支持新的 try-with-resources 语句
			// 数据流会在 try 执行完毕后自动被关闭，前提是，这些可关闭的资源必须实现 java.lang.AutoCloseable 接口
			try (
					FileWriter writer = new FileWriter(writeName);
					BufferedWriter out = new BufferedWriter(writer)
			) {
				// \r\n即为换行
				out.write(str);
				// 把缓存区内容压入文件
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readPropFile(String path) {
		InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		
		try {
			p.load(is);
			
			System.out.println(p.getProperty("test"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
//		readPropFile("test.properties");
		String str = readFile();
		writeFile(str);
	}
}
