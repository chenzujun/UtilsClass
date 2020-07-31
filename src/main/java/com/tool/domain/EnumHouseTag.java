package com.tool.domain;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * EnumHouseTag 住宅标识
 *
 * @author suxingwei
 * @date 2017-12-12
 * @since v1.1.0
 */
public enum EnumHouseTag {
    WAITING("0", "", "等确认"),
    OFFICE("-5", "Office", "商业"),
    HOUSE("5", "Home", "住宅"),
    REMOTE("1", "Remote", "偏远");
    private String code;

    private String cainiaoCode;

    private String name;

    public String getCode() {
        return code;
    }

    public String getCainiaoCode() {
        return cainiaoCode;
    }

    public String getName() {
        return name;
    }

    EnumHouseTag(String code, String cainiaoCode, String name) {
        this.code = code;
        this.cainiaoCode = cainiaoCode;
        this.name = name;
    }

    public static List<EnumHouseTag> takeHouseTagList() {
        EnumHouseTag[] enumhousetags = EnumHouseTag.values();
        return Arrays.asList(enumhousetags);
    }

    public static EnumHouseTag matchCaiNiaoCode(String code) {
        if (StringUtils.isNotEmpty(code)) {
            for (EnumHouseTag houseTag : takeHouseTagList()) {
                if (houseTag.getCode().equals(code)) {
                    return houseTag;
                }
            }
        }
        return EnumHouseTag.HOUSE;
    }

    /**
     * 根据菜鸟code 获取 pds code
     *
     * @Author: Daniel.huang
     * @Date: 2017/12/13 17:25
     */
    public static EnumHouseTag getWhCodeByCainiaoCode(String cainiaoCode) {
        if (StringUtils.isNotEmpty(cainiaoCode)) {
            for (EnumHouseTag houseTag : takeHouseTagList()) {
                if (houseTag.getCainiaoCode().equals(cainiaoCode)) {
                    return houseTag;
                }
            }
        }
        return EnumHouseTag.HOUSE;
    }


}
