package com.jotime.web.domainVo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;

import java.util.Date;

/**
 * @Classname BaseDeviceExlVo
 * @Description
 * @Date 2022/4/27 16:54
 * @Created by 14812
 */
public class BaseDeviceExlVo {
    private static final long serialVersionUID = 1L;
    /** 编号 */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备规格 */
    @Excel(name = "设备型号")
    private String deviceModel;

    /** 设备分类 A 重要设备 B  主要设备  C 一般设备 */
    @Excel(name = "设备类别 ")
    private String deviceClass;

    /** 设备编码 */
    @Excel(name = "设备编码")
    private String deviceCode;

    /** 保养周期 */
    @Excel(name = "保养周期")
    private Integer maintenanceCycle;

    /** 最新保养时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新保养时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date maintenanceDate;

    /** 一级下次保养日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "一级下次保养日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextMaintenanceDate;

    /** 设备负责人 */
    @Excel(name = "一级设备负责人")
    private Long deviceLeaderId;

    /** 二级保养周期(月) */
    @Excel(name = "二级保养周期(月)")
    private Integer twoNdMaintenanceCycle;

    /** 二级下次保养日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "二级下次保养日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextTwoNdMaintenanceDate;

    /** 二级设备负责人 */
    @Excel(name = "二级设备负责人")
    private Long twoDeviceLeaderId;

    /** 设备所属车间 */
    @Excel(name = "设备所属车间")
    private String workShopName;

    /** 生产厂及国别 */
    @Excel(name = "生产厂及国别")
    private String deviceMfrs;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactTelephone;

    /** 生产日期 */
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pdDate;

    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseDate;

    /** 1 工作中 2 空闲中  3 保养中  4 维修中 5 停用 */
    @Excel(name = "状态")
    private String status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 设备说明书 */
    @Excel(name = "设备说明书")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Integer getMaintenanceCycle() {
        return maintenanceCycle;
    }

    public void setMaintenanceCycle(Integer maintenanceCycle) {
        this.maintenanceCycle = maintenanceCycle;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public Date getNextMaintenanceDate() {
        return nextMaintenanceDate;
    }

    public void setNextMaintenanceDate(Date nextMaintenanceDate) {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public Long getDeviceLeaderId() {
        return deviceLeaderId;
    }

    public void setDeviceLeaderId(Long deviceLeaderId) {
        this.deviceLeaderId = deviceLeaderId;
    }

    public Integer getTwoNdMaintenanceCycle() {
        return twoNdMaintenanceCycle;
    }

    public void setTwoNdMaintenanceCycle(Integer twoNdMaintenanceCycle) {
        this.twoNdMaintenanceCycle = twoNdMaintenanceCycle;
    }

    public Date getNextTwoNdMaintenanceDate() {
        return nextTwoNdMaintenanceDate;
    }

    public void setNextTwoNdMaintenanceDate(Date nextTwoNdMaintenanceDate) {
        this.nextTwoNdMaintenanceDate = nextTwoNdMaintenanceDate;
    }

    public Long getTwoDeviceLeaderId() {
        return twoDeviceLeaderId;
    }

    public void setTwoDeviceLeaderId(Long twoDeviceLeaderId) {
        this.twoDeviceLeaderId = twoDeviceLeaderId;
    }

    public String getWorkShopName() {
        return workShopName;
    }

    public void setWorkShopName(String workShopName) {
        this.workShopName = workShopName;
    }

    public String getDeviceMfrs() {
        return deviceMfrs;
    }

    public void setDeviceMfrs(String deviceMfrs) {
        this.deviceMfrs = deviceMfrs;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public Date getPdDate() {
        return pdDate;
    }

    public void setPdDate(Date pdDate) {
        this.pdDate = pdDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
