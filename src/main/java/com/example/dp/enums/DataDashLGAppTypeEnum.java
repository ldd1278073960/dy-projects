package com.example.dp.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * 萝岗运营数据-应用类型枚举
 */
public enum DataDashLGAppTypeEnum {

    SUPER_SIM("超级SIM", "超级SIM"),
    SIM_FAST("SIM快捷认证", "SIM快捷认证"),
    SIM_CERT("SIM认证", "SIM认证"),
    SIM_MESSAGE("SIM消息", "SIM消息"),
    SIM_CARD_SMALL("卡小程序", "卡小程序"),
    SIM_SHIELD("SIM盾", "SIM盾"),
    SIM_TRAFFIC("SIM交通卡", "SIM交通卡"),
    SIM_ACCESS_CARD("SIM门禁卡", "SIM门禁卡"),
    SCHOOL_ENTERPRISE_CARD("校企一卡通", "校企一卡通"),
    PACKAGE_TRAVEL("和包出行", "和包出行"),
    SIM_DIGITAL_IDENTITY("SIM数字身份", "SIM数字身份"),
    SIM_PAY_ICBC("SIMPAY工行", "SIMPAY工行"),
    SIM_5G_FAST_SIGN("5G快签", "5G快签");

    private final String type;

    private final String value;

    DataDashLGAppTypeEnum(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }


    public static DataDashLGAppTypeEnum getEnumByType(String code) {
        for (DataDashLGAppTypeEnum enums : DataDashLGAppTypeEnum.values()) {
            if (StringUtils.equals(code, enums.getType())) {
                return enums;
            }
        }
        return null;
    }
}
