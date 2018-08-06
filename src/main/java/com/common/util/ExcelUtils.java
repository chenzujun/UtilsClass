package com.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
public class ExcelUtils {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public static Sheet getSheet(String fileName) {
        File file = new File(fileName);
        // 获取Excel对象
        Workbook readWB = null;
        try {
            readWB = getWorkbok(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Sheet的下标是从0开始
        // 获取第一张Sheet表
        if (readWB != null) {
            return readWB.getSheetAt(NumberUtils.INTEGER_ZERO);
        }
        return null;
    }

    public static Workbook getWorkbok(File file) throws IOException{
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if(file.getName().endsWith(EXCEL_XLS)){
            //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){
            // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 提取字符元素，无则返回null
     *
     * @param row  目标行数据
     * @param var1 目标单元格
     * @return 返回字符
     */
    public static String getStringValue(Row row, int var1) {
        Cell cell = row.getCell(var1);
        if (null != cell && org.apache.commons.lang.StringUtils.isNotBlank(cell.getStringCellValue())) {
            return cell.getStringCellValue();
        }
        return null;
    }

    /**
     * 提取字符元素，无则返回StringUtils.EMPTY
     *
     * @param row  目标行数据
     * @param var1 目标单元格
     * @return 返回字符
     */
    public static String getStringValueOrDefault(Row row, int var1) {
        String str = getStringValue(row, var1);
        if(null == str){
            return org.apache.commons.lang.StringUtils.EMPTY;
        }
        return str;
    }

    /**
     * 提取Double元素，无则返回null
     *
     * @param row  目标行数据
     * @param var1 目标单元格
     * @return 返回Double
     */
    public static Double getDoubleValue(Row row, int var1) {
        Cell cell = row.getCell(var1);
        if (null != cell && org.apache.commons.lang.StringUtils.isNotBlank(cell.getStringCellValue())) {
            return Double.valueOf(cell.getStringCellValue());
        }
        return null;
    }

    /**
     * 提取Integer元素，无则返回null
     *
     * @param row  目标行数据
     * @param var1 目标单元格
     * @return 返回Integer
     */
    public static Integer getIntegerValue(Row row, int var1) {
        Cell cell = row.getCell(var1);
        if (null != cell && StringUtils.isNotBlank(cell.getStringCellValue())) {
            return Integer.valueOf(cell.getStringCellValue());
        }
        return null;
    }

}
