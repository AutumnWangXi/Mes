package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;
import com.jotime.web.domain.base.BaseDeviceType;
import com.jotime.web.domain.base.BaseDeviceTypedtl;

import java.util.List;

/**
 * @Classname BaseDeviceTypeExlVo
 * @Description
 * @Date 2022/5/30 15:05
 * @Created by 14812
 */
public class BaseDeviceTypeExlVo {
    private static final long serialVersionUID = 1L;
    /** 编号 */
    private Long id;

    /** 设备编码 */
    @Excel(name = "设备编码")
    private String deviceCode;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 类型标签 */
    @Excel(name = "名称")
    private String typeLabel;

    /**
     * 是否合并行
     */
    private boolean mergeFlag;

    /** 类型列表 */
    private List<BaseDeviceType> baseDeviceTypeList;

    /** 类型详细 */
    private List<BaseDeviceTypedtl> baseDeviceTypedtlList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    public boolean getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(boolean mergeFlag) {
        this.mergeFlag = mergeFlag;
    }
}
