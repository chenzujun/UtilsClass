package com.tool;

import com.alibaba.fastjson.JSON;
import com.bean.PickTask;

import java.io.*;
import java.util.List;

/**
 * @author chenjun
 * @date 2020/10/16
 * @since V1.0.0
 */
public class JsonOperate {

    void readJson(){
        String path ="E:\\temp\\read.txt";
        BufferedReader br = null;
        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            String s;
            int i = 0;
            while ((s = br.readLine()) != null) {

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    void writeTxt(){

    }

    static void readAndWrite(){
        String path = "E:\\temp\\readText.txt";
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
                List<PickTask> list = JSON.parseArray(s, PickTask.class);
                sb.append("大包号").append("\t").append("小包号").append("\r\n");
                for (PickTask ins:list){
                    sb.append(ins.getContainerNo()).append("\t").append(ins.getLogisticsOrderNo()).append("\r\n");
                }
                out.write(sb.toString());
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

    public static void main(String[] args) {
        readAndWrite();
    }

}
