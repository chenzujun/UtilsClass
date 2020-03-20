package com.tool;

import com.alibaba.fastjson.JSON;
import com.common.util.ExcelUtils;
import com.common.util.HttpUtils;
import com.tool.domain.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.entity.ContentType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

/**
 * 包裹状态 pds-pdms pds_x_pkg_status pds_r_pkg_status
 * 包裹操作记录 pds-pdms pds_x_pkg_status pds_r_operation_record
 * hwmc同步 pds-hwmc pds_hwms_x_sync pds_hwms_r_sync
 * 菜鸟柜子 pds-gateway pds_xms_x_cabinet_cainiao pds_xms_r_cabinet_cainiao
 * 转运回传 pds-pdms-rabbit-x-callback-dispatch pds-pdms-rabbit-r-callback-dispatch
 *
 * @description:
 * @author: mustang
 * @create: 2020-03-06
 **/
public class RabbitMqHttp {


    public static void main(String[] args) throws Exception {
//        resend();
//        resendCallbackDispatch();
        resendPaiSongReceived();
    }

    enum MQ_TYPE{
        STATUS,
        RECORD,
        CABINET,
        SYNC,
        DISPATCH;

    }

    public static void resend() throws Exception{
        final String URL = "http://mq_pds:p18y10m12s@172.16.5.42:15672/api/exchanges/pds-gateway/pds_xms_x_cabinet_cainiao/publish";
        Workbook readWB = ExcelUtils.getWorkbok(new File("E://temp//mq.xlsx"));
        if (readWB != null) {
            Sheet readSheet = readWB.getSheetAt(0);
            // 获取Sheet表中所包含的总行数
            int rsRows = readSheet.getLastRowNum();
            Row row;
            for (int i = 0; i < 1; i++) {
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
                    String body = "{\"vhost\":\"pds-gateway\",\"name\":\"amq.default\",\"properties\":{\"delivery_mode\":1,\"headers\":{}},\"routing_key\":\"pds_xms_r_cabinet_cainiao\",\"delivery_mode\":\"1\",\"payload\":\""+payload+"\",\"headers\":{},\"props\":{},\"payload_encoding\":\"string\"}";

                    String result = HttpUtils.postTextplain(URL, body);
                    System.out.println(result);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 例：
     * 803102925090002	1573992075000	803102925090	1518320629010821120	1518320627232436224
     * @throws Exception
     */
    public static void resendCallbackDispatch() throws Exception{
        final String URL = "http://mq_pds:p18y10m12s@172.16.5.42:15672/api/exchanges/pds-pdms/pds-pdms-rabbit-x-callback-dispatch/publish";
        Workbook readWB = ExcelUtils.getWorkbok(new File("E://temp//mq.xlsx"));
        if (readWB != null) {
            Sheet readSheet = readWB.getSheetAt(0);
            // 获取Sheet表中所包含的总行数
            int rsRows = readSheet.getLastRowNum();
            System.out.println(rsRows);
            Row row;
            for (int i = 1; i < 290; i++) {
                try {
                    row = readSheet.getRow(i);
                    if (row == null) {
                        continue;
                    }
                    String shippingNo = row.getCell(0).getStringCellValue();
                    long operationTime = Long.valueOf(row.getCell(1).getStringCellValue());
                    String serialNo = row.getCell(3).getStringCellValue();
                    Long taskNo = Long.valueOf(row.getCell(4).getStringCellValue());

                    ContentType content = ContentType.create("text/plain", "UTF-8");
                    //String utl = "http://pds-asm:pds-asm@环境:15672/api/exchanges/虚拟主机/交换器/publish";
                    String payload = "{\"data\":{\"detailData\":{\"logisticsOrder\":{\"fpxTrackingNo\":\""+shippingNo+"\"},\"warehouseOperation\":{\"operationNode\":\"PDS_SIGNED\",\"operationTime\":"+operationTime+",\"operator\":\"\"}},\"masterData\":{\"mandatorEventCode\":\"CN_PDS_DELIVERY_MANDATOR\",\"methodType\":\"NEW\",\"resultCode\":\"0\",\"serialNo\":\""+serialNo+"\",\"taskNo\":"+taskNo+",\"taskType\":\"TASK_PDS_DELIVERY\"}},\"eventCode\":\"CN_PDS_DELIVERY_MANDATOR\"}";
                    payload = StringEscapeUtils.escapeJava(payload);

                    String body = "{\"vhost\":\"pds-pdms\",\"name\":\"amq.default\",\"properties\":{\"delivery_mode\":1,\"headers\":{}},\"routing_key\":\"pds-pdms-rabbit-r-callback-dispatch\",\"delivery_mode\":\"1\",\"payload\":\"" + payload + "\",\"headers\":{},\"props\":{},\"payload_encoding\":\"string\"}";

                    String result = HttpUtils.postTextplain(URL, body);
                    System.out.println(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void resendPaiSongReceived() throws Exception{
        final String URL = "http://mq_pds:p18y10m12s@172.16.5.42:15672/api/exchanges/pds-pdms/pds_xms_4pl_x_lastmile_callback/publish";
        Workbook readWB = ExcelUtils.getWorkbok(new File("E://temp//mq.xlsx"));
        if (readWB != null) {
            Sheet readSheet = readWB.getSheetAt(0);
            // 获取Sheet表中所包含的总行数
            int rsRows = readSheet.getLastRowNum();
            Row row;
            for (int i = 0; i < 28; i++) {
                try {
                    row = readSheet.getRow(i);
                    if (row == null) {
                        continue;
                    }

                    String logisticsCode = row.getCell(0).getStringCellValue();
                    String shippingNo = row.getCell(1).getStringCellValue();
                    String logisticProviderId = row.getCell(2).getStringCellValue();
                    String addressAttribute = row.getCell(3).getStringCellValue();
                    Date opTime = row.getCell(4).getDateCellValue();
                    Pkg pkg = new Pkg();
                    pkg.setLogisticsCode(logisticsCode);
                    pkg.setShippingNo(shippingNo);
                    pkg.setLogisticProviderId(logisticProviderId);
                    pkg.setReceiveTime(opTime);
                    pkg.setAddressAttribute(addressAttribute);
                    MaochaoPushEvent ins = getTianMaoPushEvent(pkg);

                    String payload = JSON.toJSONString(ins);
                    payload = StringEscapeUtils.escapeJava(payload);
                    String body = "{\"vhost\":\"pds-pdms\",\"name\":\"amq.default\",\"properties\":{\"delivery_mode\":1,\"headers\":{}},\"routing_key\":\"pds_xms_4pl_r_lastmile_callback\",\"delivery_mode\":\"1\",\"payload\":\""+payload+"\",\"headers\":{},\"props\":{},\"payload_encoding\":\"string\"}";

                    String result = HttpUtils.postTextplain(URL, body);
                    System.out.println(result);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }


    private static MaochaoPushEvent getTianMaoPushEvent(Pkg pkg) {
        MaochaoPushEvent maochaoPushEvent = new MaochaoPushEvent();
        maochaoPushEvent.setMsg_type("CAINIAO_GLOBAL_LASTMILE_GTMSSIGN_CALLBACK");
        maochaoPushEvent.setEventCode("GTMS_SIGNED");
        maochaoPushEvent.setOrderNo(pkg.getLogisticsCode());
        maochaoPushEvent.setTrackingNumber(pkg.getShippingNo());
        maochaoPushEvent.setLogisticProviderId(pkg.getLogisticProviderId());

        Lastmile lastmile = getLastmile(pkg);
        String lastMileSource = XMLConver.java2Xml(lastmile);
        String base64MD5String = MD5Util.encodeBase64MD5String(lastMileSource + "DFKLJDSHJ253SD2");
        maochaoPushEvent.setDataDigest(base64MD5String);
        maochaoPushEvent.setLogisticsInterface(lastMileSource);

        return maochaoPushEvent;
    }

    private static Lastmile getLastmile(Pkg pkg) {
        Lastmile lastmile = new Lastmile();
        lastmile.setLogisticsOrderCode(pkg.getLogisticsCode());
        lastmile.setTrackingNumber(pkg.getShippingNo());
        EnumHouseTag enumHouseTag = EnumHouseTag.matchCaiNiaoCode(pkg.getAddressAttribute());
        lastmile.setLocationType(enumHouseTag.getCainiaoCode());
        lastmile.setOpTime(pkg.getReceiveTime());

        lastmile.setDeliveriedTimes(1);
        lastmile.setTrackingDescription("包裹已签收");
        lastmile.setOperator("SYSTEM");
        lastmile.setOperatorContact("SYSTEM");
        lastmile.setOpCode("0");
        lastmile.setOpRemark("包裹已签收");
        lastmile.setTimeZone(8);

        return lastmile;
    }
}
