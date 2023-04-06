package com.jotime.web.domain.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备信息对象 base_device
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 设备id */
    @Excel(name = "设备编码")
    private String deviceCode;
    /** 设备二维码 */
    @Excel(name = "设备二维码")
    private String qrCode;
    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备规格 */
    @Excel(name = "设备规格")
    private String deviceModel;

    /** 设备分组 */
    @Excel(name = "设备分组")
    private String deviceGroup;
    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseDate;

    /** 最大生产值 */
    @Excel(name = "最大生产值")
    private BigDecimal maximumProduction;
    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 流水线 */
    @Excel(name = "流水线")
    private Integer lineId;
    /** 流水线 */
    @TableField(exist = false)
    private String lineName;
    /** 车间 */
    @Excel(name = "车间")
    private Long workshopId;
    /** 车间 */
    @TableField(exist = false)
    private String workshopName;

    /** 设备说明书 */
    @Excel(name = "设备说明书")
    private String content;

    /** 最新保养时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新保养时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date maintenanceDate;

    /** 保养周期 */
    @Excel(name = "保养周期")
    private Integer maintenanceCycle;

    /** 下次保养日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下次保养日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextMaintenanceDate;

    /** 1 工作中 2 空闲中  3 保养中  4 维修中 5 停用 */
    @Excel(name = "1 工作中 2 空闲中  3 保养中  4 维修中 5 停用")
    private String status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;
    /** 二级保养周期(月) */
    @Excel(name = "二级保养周期(月)")
    private Integer twoNdMaintenanceCycle;

    /** 二级保养周期(月) */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "二级保养周期(月)", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextTwoNdMaintenanceDate;

    /** 设备分类 A 重要设备 B  主要设备  C 一般设备 */
    @Excel(name = "设备分类 A 重要设备 B  主要设备  C 一般设备")
    private String deviceClass;

    /** 生产厂及国别 */
    @Excel(name = "生产厂及国别")
    private String deviceMfrs;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pdDate;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactTelephone;

    /** 设备负责人 */
    @Excel(name = "设备负责人")
    private Long deviceLeaderId;

    /** 二级设备负责人 */
    @Excel(name = "二级设备负责人")
    private Long twoDeviceLeaderId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDeviceCode(String deviceCode)
    {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCode()
    {
        return deviceCode;
    }
    public void setDeviceModel(String deviceModel)
    {
        this.deviceModel = deviceModel;
    }

    public String getDeviceModel() { return deviceModel; }
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }
    public void setDeviceGroup(String deviceGroup)
    {
        this.deviceGroup = deviceGroup;
    }

    public String getDeviceGroup()
    {
        return deviceGroup;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setWorkshopId(Long workshopId)
    {
        this.workshopId = workshopId;
    }

    public Long getWorkshopId()
    {
        return workshopId;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setMaintenanceDate(Date maintenanceDate)
    {
        this.maintenanceDate = maintenanceDate;
    }

    public Date getMaintenanceDate()
    {
        return maintenanceDate;
    }
    public void setMaintenanceCycle(Integer maintenanceCycle)
    {
        this.maintenanceCycle = maintenanceCycle;
    }

    public Integer getMaintenanceCycle()
    {
        return maintenanceCycle;
    }
    public void setNextMaintenanceDate(Date nextMaintenanceDate)
    {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public Date getNextMaintenanceDate()
    {
        return nextMaintenanceDate;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getDeviceMfrs() {
        return deviceMfrs;
    }

    public void setDeviceMfrs(String deviceMfrs) {
        this.deviceMfrs = deviceMfrs;
    }

    public Date getPdDate() {
        return pdDate;
    }

    public void setPdDate(Date pdDate) {
        this.pdDate = pdDate;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public Long getDeviceLeaderId() {
        return deviceLeaderId;
    }

    public void setDeviceLeaderId(Long deviceLeaderId) {
        this.deviceLeaderId = deviceLeaderId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getMaximumProduction() {
        return maximumProduction;
    }

    public void setMaximumProduction(BigDecimal maximumProduction) {
        this.maximumProduction = maximumProduction;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getTwoDeviceLeaderId() {
        return twoDeviceLeaderId;
    }

    public void setTwoDeviceLeaderId(Long twoDeviceLeaderId) {
        this.twoDeviceLeaderId = twoDeviceLeaderId;
    }

    @Override
    public String toString() {
        return "BaseDevice{" +
                "id=" + id +
                ", deviceCode='" + deviceCode + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", deviceGroup='" + deviceGroup + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", maximumProduction=" + maximumProduction +
                ", unit='" + unit + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", lineId=" + lineId +
                ", lineName='" + lineName + '\'' +
                ", workshopId=" + workshopId +
                ", workshopName='" + workshopName + '\'' +
                ", content='" + content + '\'' +
                ", maintenanceDate=" + maintenanceDate +
                ", maintenanceCycle=" + maintenanceCycle +
                ", nextMaintenanceDate=" + nextMaintenanceDate +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", twoNdMaintenanceCycle=" + twoNdMaintenanceCycle +
                ", nextTwoNdMaintenanceDate=" + nextTwoNdMaintenanceDate +
                ", deviceClass='" + deviceClass + '\'' +
                ", deviceMfrs='" + deviceMfrs + '\'' +
                ", pdDate=" + pdDate +
                ", contactTelephone='" + contactTelephone + '\'' +
                ", deviceLeaderId=" + deviceLeaderId +
                ", twoDeviceLeaderId=" + twoDeviceLeaderId +
                '}';
    }
}
