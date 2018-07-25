package com.common.util.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取本地配置文件实例
 *
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
public class FileProperties extends Properties {
    public FileProperties() {
    }

    public FileProperties(String s) {
        try {
            InputStream inputStream = new FileInputStream(new File(s));
            load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            System.err.println("Exception in FileProperties(String): "
                    + e.toString()
                    + " for filename="
                    + s);
        }
    }

    public FileProperties(Properties properties) {
        super(properties);
    }

    public static String getMyProperty(String path, String key) {
        FileProperties fp = new FileProperties(path);
        if (fp != null) {
            return fp.getProperty(key);
        } else {
            return null;
        }
    }
}
