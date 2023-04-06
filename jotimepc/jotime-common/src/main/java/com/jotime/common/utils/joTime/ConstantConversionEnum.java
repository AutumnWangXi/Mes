package com.jotime.common.utils.joTime;

import com.jotime.common.utils.StringUtils;

/**
 * 常量转换枚举类
 *
 * @author chen
 */
public enum ConstantConversionEnum {

    UsedEfficacyReq_保湿("保湿", "01", null),
    UsedEfficacyReq_祛斑美白("祛斑美白", "02", null),
    UsedEfficacyReq_防晒("防晒", "03", null),
    UsedEfficacyReq_祛痘("祛痘", "04", null),
    UsedEfficacyReq_滋养("滋养", "05", null),
    UsedEfficacyReq_修护("修护", "06", null),
    UsedEfficacyReq_清洁("清洁", "07", null),
    UsedEfficacyReq_卸妆("卸妆", "08", null),
    UsedEfficacyReq_抗皱("抗皱", "09", null),
    UsedEfficacyReq_紧致("紧致", "10", null),
    UsedEfficacyReq_舒缓("舒缓", "11", null),
    UsedEfficacyReq_控油("控油", "12", null),
    UsedEfficacyReq_去角质("去角质", "13", null),
    UsedEfficacyReq_爽身("爽身", "14", null),
    UsedEfficacyReq_护发("护发", "15", null),
    UsedEfficacyReq_防断发("防断发", "16", null),
    UsedEfficacyReq_去屑("去屑", "17", null),
    UsedEfficacyReq_发色护理("发色护理", "18", null),
    UsedEfficacyReq_脱毛("脱毛", "19", null),
    UsedEfficacyReq_辅助剃须剃毛("辅助剃须剃毛", "20", null),
    UsedEfficacyReq_美容修饰("美容修饰", "21", null),
    UsedEfficacyReq_裸妆("裸妆", "22", null),
    UsedEfficacyReq_亮光("亮光", "23", null),
    UsedEfficacyReq_哑光("哑光", "24", null),
    UsedEfficacyReq_持久("持久", "25", null),
    UsedEfficacyReq_水润("水润", "26", null),
    UsedEfficacyReq_丝滑("丝滑", "27", null),
    UsedEfficacyReq_色彩高饱和度("色彩高饱和度", "28", null),
    UsedEfficacyReq_不沾杯("不沾杯", "29", null),
    UsedEfficacyReq_防水("防水", "30", null),
    UsedEfficacyReq_遮瑕("遮瑕", "31", null),
    UsedEfficacyReq_多色("多色", "32", null),
    UsedEfficacyReq_新功效("新功效", "33", null),
    SpecificaReq_无特别要求("无特别要求", null, "01"),
    SpecificaReq_美修全绿("美修全绿", null, "02"),
    SpecificaReq_无致痘成份("无致痘成份", null, "03"),
    SpecificaReq_无酒精("无酒精", null, "04"),
    SpecificaReq_无矿物油("无矿物油", null, "05"),
    SpecificaReq_无色素("无色素", null, "06"),
    SpecificaReq_无防腐剂("无防腐剂", null, "07"),
    SpecificaReq_如无法满足特别需求("如无法满足特别需求的，通知业务与客户沟通", null, "08"),
    SalesChannel_线上("线上(天猫,淘宝,京东,自营)", "01",1,null),
    SalesChannel_实体店("实体店", "02",1,null),
    SalesChannel_直销("直销", "03",1,null),
    SalesChannel_院线("院线", "04",1,null),
    SalesDistrict_中国("中国", "01",2,null),
    SalesDistrict_美国("美国", "02",2,null),
    SalesDistrict_欧盟("欧盟", "03",2,null),
    SalesDistrict_东南亚("东南亚", "04",2,null),
    SalesDistrict_其他("其他", "99",2,null),
    Return_Null("未匹配到内容", null, null);


    /**
     * 页面展示值
     */
    private String name;


    /**
     * 使用功效要求
     */
    private String effectValue;

    /**
     * 配方特别要求值
     */
    private String formulaValue;

    /**
     * 配方特别要求值
     */
    private String salesChannel;

    private String salesDistrict;

    public String getSalesDistrict() {
        return salesDistrict;
    }

    public void setSalesDistrict(String salesDistrict) {
        this.salesDistrict = salesDistrict;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffectValue() {
        return effectValue;
    }

    public void setEffectValue(String effectValue) {
        this.effectValue = effectValue;
    }

    public String getFormulaValue() {
        return formulaValue;
    }

    public void setFormulaValue(String formulaValue) {
        this.formulaValue = formulaValue;
    }

    /**
     * @param name        传递值
     * @param effectValue 数据库存储值
     */
    ConstantConversionEnum(String name, String effectValue, String formulaValue) {
        this.name = name;
        this.effectValue = effectValue;
        this.formulaValue = formulaValue;
    }

    /**
     * @param name 传递值
     * @param data 销售渠道 / 销售地区
     */
    ConstantConversionEnum(String name, String data, Integer type,String nullData) {
        if (type == 1) {
            this.name = name;
            this.salesChannel = data;
        } else {
            this.name = name;
            this.salesDistrict = data;
        }

    }

    /**
     * 根据使用功效值匹配展示内容
     *
     * @param effectValue 使用功效值
     * @return 匹配结果
     */
    public static ConstantConversionEnum effectValueTransformation(String effectValue) {
        for (ConstantConversionEnum constantConversionEnum : ConstantConversionEnum.values()) {
            if (StringUtils.isNotNull(constantConversionEnum.effectValue)) {
                if (constantConversionEnum.effectValue.equals(effectValue)) {
                    return constantConversionEnum;
                }
            }
        }
        return ConstantConversionEnum.Return_Null;
    }


    /**
     * 根据名称匹配值
     *
     * @param name 展示名称
     * @return 匹配结果
     */
    public static ConstantConversionEnum nameTransformation(String name) {
        for (ConstantConversionEnum constantConversionEnum : ConstantConversionEnum.values()) {
            if (constantConversionEnum.name.equals(name)) {
                return constantConversionEnum;
            }
        }
        return ConstantConversionEnum.Return_Null;
    }

    /**
     * 根据配方要求值匹配展示内容
     *
     * @param formulaValue 配方要求值
     * @return 匹配结果
     */
    public static ConstantConversionEnum formulaValueTransformation(String formulaValue) {
        for (ConstantConversionEnum constantConversionEnum : ConstantConversionEnum.values()) {
            if (StringUtils.isNotNull(constantConversionEnum.formulaValue)) {
                if (constantConversionEnum.formulaValue.equals(formulaValue)) {
                    return constantConversionEnum;
                }
            } else {
                continue;
            }
        }
        return ConstantConversionEnum.Return_Null;
    }

    /**
     * 根据销售渠道要求值匹配展示内容
     *
     * @param salesChannelValue 配方要求值
     * @return 匹配结果
     */
    public static ConstantConversionEnum salesSalesChannelValueTransformation(String salesChannelValue) {
        for (ConstantConversionEnum constantConversionEnum : ConstantConversionEnum.values()) {
            if (StringUtils.isNotNull(constantConversionEnum.salesChannel)) {
                if (constantConversionEnum.salesChannel.equals(salesChannelValue)) {
                    return constantConversionEnum;
                }
            } else {
                continue;
            }
        }
        return ConstantConversionEnum.Return_Null;
    }

    /**
     * 根据销售地区要求值匹配展示内容
     *
     * @param salesDistrictValue 配方要求值
     * @return 匹配结果
     */
    public static ConstantConversionEnum salesDistrictValueTransformation(String salesDistrictValue) {
        for (ConstantConversionEnum constantConversionEnum : ConstantConversionEnum.values()) {
            if (StringUtils.isNotNull(constantConversionEnum.salesDistrict)) {
                if (constantConversionEnum.salesDistrict.equals(salesDistrictValue)) {
                    return constantConversionEnum;
                }
            } else {
                continue;
            }
        }
        return ConstantConversionEnum.Return_Null;
    }


}
