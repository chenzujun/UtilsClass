package com.common.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
public class JsonUtil {

    private static class SingletonHolder {
        private static final Gson INSTANCE = new Gson();
    }

    private JsonUtil (){}

    public static final Gson getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static String toJson(Object obj) {
        return getInstance().toJson(obj);
    }

    public static <T> T toObj(String json, Class<T> classOfT) {
        return getInstance().fromJson(json, classOfT);
    }

    /**
     *
     * Error:(34, 47) java: 常量字符串过长  修改File | Settings | Build, Execution, Deployment | Compiler | Java Compiler 为eclipse
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("[{\"id\":\"15868\",\"name\":\"揽收司机\",\"type\":\"\",\"url\":\"/driver/main\",\"parentId\":\"15867\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.driver\"},{\"id\":\"15878\",\"name\":\"揽收管理\",\"type\":\"\",\"url\":\"\",\"parentId\":\"15794\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.pickup.manage\"},{\"id\":\"15879\",\"name\":\"揽收批次\",\"type\":\"\",\"url\":\"/batch/main\",\"parentId\":\"15878\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.batch\"},{\"id\":\"16044\",\"name\":\"推送日志\",\"type\":\"\",\"url\":\"/callback/event/main\",\"parentId\":\"16043\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"\"},{\"id\":\"16130\",\"name\":\"揽收区域\",\"type\":\"\",\"url\":\"/region/gaoDe/main\",\"parentId\":\"15867\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"\"},{\"id\":\"16700\",\"name\":\"录单列表\",\"type\":\"\",\"url\":\"/handover/main\",\"parentId\":\"16698\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.handover\"},{\"id\":\"16921\",\"name\":\"揽收大包查询\",\"type\":\"\",\"url\":\"/container/main\",\"parentId\":\"15878\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.container\"},{\"id\":\"15916\",\"name\":\"分配任务\",\"type\":\"\",\"url\":\"/task/main\",\"parentId\":\"15878\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.task\"},{\"id\":\"16698\",\"name\":\"录单管理\",\"type\":\"\",\"url\":\"\",\"parentId\":\"15794\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.handover.manage\"},{\"id\":\"16043\",\"name\":\"系统工具\",\"type\":\"\",\"url\":\"\",\"parentId\":\"15794\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.system.tools\"},{\"id\":\"15867\",\"name\":\"基础设置\",\"type\":\"\",\"url\":\"\",\"parentId\":\"15794\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.base.manage\"},{\"id\":\"17088\",\"name\":\"揽收异常管理\",\"type\":\"\",\"url\":\"/issue/handle/main\",\"parentId\":\"15878\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"pds.pms.menu.issue.handle\"},{\"id\":\"17113\",\"name\":\"货量分布图\",\"type\":\"\",\"url\":\"/region/distribution/main\",\"parentId\":\"15878\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"\"},{\"id\":\"17180\",\"name\":\"数据字典\",\"type\":\"\",\"url\":\"/dic/main\",\"parentId\":\"15867\",\"style\":\"\",\"elementId\":\"\",\"i18nCode\":\"\"}]");
        List<JsonBean> ps = JsonUtil.getInstance().fromJson(str.toString(), new TypeToken<List<JsonBean>>(){}.getType());
        StringBuffer sb = new StringBuffer();
        ps.stream().forEach(e->sb.append(e.getName()).append(" ").append(e.getUrl()).append("\n"));
        System.out.println(sb.toString());
    }
}
class JsonBean {

    private Long id;
    private String name;
    private String type;
    private String url;
    private Long parentId;
    private String style;
    private String elementId;
    private String children;
    private String i18nCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getI18nCode() {
        return i18nCode;
    }

    public void setI18nCode(String i18nCode) {
        this.i18nCode = i18nCode;
    }
}
