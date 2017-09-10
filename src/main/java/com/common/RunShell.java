package com.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 执行脚本文件
 * TODO 完善具体的调用方法；
 *      完善结果获取方法
 * @author Administrator
 *
 */
public class RunShell {
	public static void main(String[] args) {
		try {
			if (System.getProperty("os.name").toUpperCase().contains("WIN")) {
				// 不做任何处理
				System.out.println("windows系统！");
				Process p = Runtime.getRuntime().exec("cmd.exe /c dir");
				System.out.println(p.toString());
			} else {
				String shpath = "/home/demo-echo.sh ";
				Process ps = Runtime.getRuntime().exec(shpath);
				ps.waitFor();

				BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				String result = sb.toString();
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
