package com.jotime.common.utils.joTime;

import com.jotime.common.constant.Constants;
import com.jotime.common.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * 根据复选框内容转换
 */
public class ConstantConversionUnit {

    private static final String RETURN_VALUE = "";

    /**
     * 使用功效
     */
    public static final Integer EFFECT_VALUE_TYPE = 1;
    /**
     * 配方要求
     */
    public static final Integer FORMULA_VALUE_TYPE = 2;

    /**
     * 根据使用功效内容转换展示名称
     *
     * @param effectValue 使用功效值
     * @return 转换结果
     */
    public static List<String> nameTransformation(String effectValue, Integer type) {
        List<String> returnList = new ArrayList<>();
        if (StringUtils.isNotNull(effectValue)) {
            String[] arrayList = effectValue.split(Constants.DASH_COMMA);
            if (StringUtils.isNotEmpty(arrayList)) {
                if (type.equals(EFFECT_VALUE_TYPE)) {
                    for (String value : arrayList) {
                        returnList.add(ConstantConversionUnit.effectNameTransformation(value));
                    }
                }
            } else if (type.equals(FORMULA_VALUE_TYPE)) {
                for (String value : arrayList) {
                    returnList.add(ConstantConversionUnit.formulaValueTransformation(value));
                }
            }
        }
        return returnList;

    }

    /**
     * 根据销售渠道内容转换展示名称
     *
     * @param salesChannelValue 销售渠道
     * @return 转换结果
     */
    public static String salesChannelValueTransformation(String salesChannelValue) {
        if (StringUtils.isNotNull(salesChannelValue)) {
            String[] arrays = salesChannelValue.split(Constants.DASH_COMMA);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.isNotEmpty(arrays)) {
                for (String s : arrays) {
                    ConstantConversionEnum constantConversionEnum = ConstantConversionEnum.salesSalesChannelValueTransformation(s);
                    if (!constantConversionEnum.getName().equals(ConstantConversionEnum.Return_Null.getName())) {
                        stringBuilder.append(constantConversionEnum.getName()).append(Constants.DASH_COMMA);
                    }
                }
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return RETURN_VALUE;
    }

    /**
     * 根据销售地区内容转换展示名称
     *
     * @param salesDistrictValue 销售地区
     * @return 转换结果
     */
    public static String salesDistrictValueTransformation(String salesDistrictValue) {
        if (StringUtils.isNotNull(salesDistrictValue)) {
            String[] arrays = salesDistrictValue.split(Constants.DASH_COMMA);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.isNotEmpty(arrays)) {
                for (String s : arrays) {
                    ConstantConversionEnum constantConversionEnum = ConstantConversionEnum.salesDistrictValueTransformation(s);
                    if (!constantConversionEnum.getName().equals(ConstantConversionEnum.Return_Null.getName())) {
                        stringBuilder.append(constantConversionEnum.getName()).append(Constants.DASH_COMMA);
                    }
                }
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return RETURN_VALUE;
    }

    /**
     * 根据使用功效内容转换展示名称
     *
     * @param effectValue 使用功效值
     * @return 转换结果
     */
    public static String effectValueTransformation(String effectValue) {
        if (StringUtils.isNotNull(effectValue)) {
            String[] arrays = effectValue.split(Constants.DASH_COMMA);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.isNotEmpty(arrays)) {
                for (String s : arrays) {
                    ConstantConversionEnum constantConversionEnum = ConstantConversionEnum.effectValueTransformation(s);
                    if (!constantConversionEnum.getName().equals(ConstantConversionEnum.Return_Null.getName())) {
                        stringBuilder.append(constantConversionEnum.getName()).append(Constants.DASH_COMMA);
                    }
                }
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return RETURN_VALUE;
    }

    /**
     * 根据使用功效内容转换展示名称
     *
     * @param formulaValue 使用功效值
     * @return 转换结果
     */
    public static String formulaValueTransformation(String formulaValue) {
        if (StringUtils.isNotNull(formulaValue)) {
            String[] arrays = formulaValue.split(Constants.DASH_COMMA);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.isNotEmpty(arrays)) {
                for (String s : arrays) {
                    ConstantConversionEnum constantConversionEnum = ConstantConversionEnum.formulaValueTransformation(s);
                    if (!constantConversionEnum.getName().equals(ConstantConversionEnum.Return_Null.getName())) {
                        stringBuilder.append(constantConversionEnum.getName()).append(Constants.DASH_COMMA);
                    }
                }
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return RETURN_VALUE;
    }

    /**
     * 根据配方要求展示名称转换使用功效内容
     *
     * @param name 配方要求展示名称
     * @return 转换结果
     */
    public static String formulaNameTransformation(String name) {
        if (StringUtils.isNotNull(name)) {
            String[] arrays = name.split(Constants.DASH_COMMA);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.isNotEmpty(arrays)) {
                for (String s : arrays) {
                    ConstantConversionEnum constantConversionEnum = ConstantConversionEnum.nameTransformation(s);
                    if (!constantConversionEnum.getName().equals(ConstantConversionEnum.Return_Null.getName())) {
                        stringBuilder.append(constantConversionEnum.getFormulaValue()).append(Constants.DASH_COMMA);
                    }
                }
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return RETURN_VALUE;
    }

    /**
     * 根据使用功效展示名称转换使用功效内容
     *
     * @param name 使用功效展示名称
     * @return 转换结果
     */
    public static String effectNameTransformation(String name) {
        if (StringUtils.isNotNull(name)) {
            String[] arrays = name.split(Constants.DASH_COMMA);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.isNotEmpty(arrays)) {
                for (String s : arrays) {
                    ConstantConversionEnum constantConversionEnum = ConstantConversionEnum.nameTransformation(s);
                    if (!constantConversionEnum.getName().equals(ConstantConversionEnum.Return_Null.getName())) {
                        stringBuilder.append(constantConversionEnum.getEffectValue()).append(Constants.DASH_COMMA);
                    }
                }
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return RETURN_VALUE;
    }

    /**
     * 根据销售地区名称转换使用功效内容
     *
     * @param name 使用功效展示名称
     * @return 转换结果
     */
    public static String salesDistrictNameTransformation(String name) {
        if (StringUtils.isNotNull(name)) {
            String[] arrays = name.split(Constants.DASH_COMMA);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.isNotEmpty(arrays)) {
                for (String s : arrays) {
                    ConstantConversionEnum constantConversionEnum = ConstantConversionEnum.nameTransformation(s);
                    if (!constantConversionEnum.getName().equals(ConstantConversionEnum.Return_Null.getName())) {
                        stringBuilder.append(constantConversionEnum.getSalesChannel()).append(Constants.DASH_COMMA);
                    }
                }
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return RETURN_VALUE;
    }


}
