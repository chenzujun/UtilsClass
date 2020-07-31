package com.tool;

import com.alibaba.fastjson.JSON;
import com.tool.domain.TransferObj;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * txt文件转对象
 *
 * @author chenjun
 * @date 2020/6/11
 * @since V1.0.0
 */
public class FileToObj {

    public static String match(String str){
        // 匹配大括号之间的内容
        String regex = "(\\{(.*?)})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        String result = "";
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\chenjun01\\Downloads\\guoguo0611.txt";
        FileWriter writer = null;
        BufferedWriter out = null;
        BufferedReader br = null;
        try {
            File writeName = new File("E:\\temp\\output.txt");
            writeName.createNewFile();
            writer = new FileWriter(writeName);
            out = new BufferedWriter(writer);


            StringBuffer sb = new StringBuffer();

            br = new BufferedReader(new FileReader(new File(path)));
            String s;
            int i = 0;
            while ((s = br.readLine()) != null) {
                i++;
                String[] arr = s.split("创建裹裹订单,参数信息:");
                String[] arr2 = arr[1].split("\\},\\{");
                // 对象转换问题
                TransferObj obj = JSON.parseObject(arr2[0]+"}", TransferObj.class);
                TransferObj obj2 = JSON.parseObject("{"+arr2[1], TransferObj.class);
                String matach = obj.getTrackingNumber() + "  "+obj2.getRequest().getExternalUserId();

                out.write(matach);
                out.newLine();
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
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
