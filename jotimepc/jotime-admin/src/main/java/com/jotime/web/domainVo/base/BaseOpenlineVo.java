package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import com.jotime.web.domain.base.BaseOpenlinedtl;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname BaseOpenlineVo
 * @Description
 * @Date 2022/3/4 15:53
 * @Created by 14812
 */
public class BaseOpenlineVo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 设备开线内码
     */
    private Long id;

    /** 设备编号/流水线no */
    @Excel(name = "设备编号/流水线no")
    private String deviceCode;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 开线要求 */
    @Excel(name = "开线要求")
    private String requirement;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 详细 */
    @TableField
    private List<BaseOpenlinedtlVo> baseOpenlinedtl;

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<BaseOpenlinedtlVo> getBaseOpenlinedtl() {
        return baseOpenlinedtl;
    }

    public void setBaseOpenlinedtl(List<BaseOpenlinedtlVo> baseOpenlinedtl) {
        this.baseOpenlinedtl = baseOpenlinedtl;
    }
}
