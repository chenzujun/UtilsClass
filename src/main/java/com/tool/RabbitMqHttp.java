package com.tool;

import com.common.util.ExcelUtils;
import com.common.util.HttpUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.entity.ContentType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;

/**
 * 包裹状态 pds-pdms pds_x_pkg_status pds_r_pkg_status
 * 包裹操作记录 pds-pdms pds_x_pkg_status pds_r_operation_record
 * hwmc同步 pds-hwmc pds_hwms_x_sync pds_hwms_r_sync
 *
 * @description:
 * @author: mustang
 * @create: 2020-03-06
 **/
public class RabbitMqHttp {
    private static final String URL = "http://mq_pds:p18y10m12s@172.16.5.42:15672/api/exchanges/pds-pdms/pds_x_pkg_status/publish";

    public static void main(String[] args) throws URISyntaxException, IOException, TimeoutException {
        Workbook readWB = ExcelUtils.getWorkbok(new File("E://temp//mq.xlsx"));
        if (readWB != null) {
            Sheet readSheet = readWB.getSheetAt(0);
            // 获取Sheet表中所包含的总行数
            int rsRows = readSheet.getLastRowNum();
            Row row;
            for (int i = 0; i < 22; i++) {
                try {
                    row = readSheet.getRow(i);
                    if (row == null) {
                        continue;
                    }

                    Iterator<Cell> iterator = row.cellIterator();
                    while (iterator.hasNext()) {
                        Cell cell = iterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    ContentType content = ContentType.create("text/plain","UTF-8");
                    //String utl = "http://pds-asm:pds-asm@环境:15672/api/exchanges/虚拟主机/交换器/publish";
                    String payload = row.getCell(0).toString().trim();
                    payload = StringEscapeUtils.escapeJava(payload);
                    String body = "{\"vhost\":\"pds-pdms\",\"name\":\"amq.default\",\"properties\":{\"delivery_mode\":1,\"headers\":{}},\"routing_key\":\"pds_r_operation_record\",\"delivery_mode\":\"1\",\"payload\":\""+payload+"\",\"headers\":{},\"props\":{},\"payload_encoding\":\"string\"}";

                    String result = HttpUtils.postTextplain(URL, body);
                    System.out.println(result);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
