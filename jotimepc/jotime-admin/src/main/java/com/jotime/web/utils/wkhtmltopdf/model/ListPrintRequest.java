package com.jotime.web.utils.wkhtmltopdf.model;

import java.util.Map;

/**
 * 打印文件请求体
 *
 * @author qinhouzhen
 * @date 2019/06/03
 */
public class ListPrintRequest {

    /**
     * 导出文件类型
     */
    private String fileType;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单行项目号
     */
    private String poRowNo;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 导出文件类型集合
     */
    private Map<String,String> fileTypeList;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPoRowNo() {
        return poRowNo;
    }

    public void setPoRowNo(String poRowNo) {
        this.poRowNo = poRowNo;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Map<String, String> getFileTypeList() {
        return fileTypeList;
    }

    public void setFileTypeList(Map<String, String> fileTypeList) {
        this.fileTypeList = fileTypeList;
    }

    @Override
    public String toString() {
        return "ListPrintRequest{" +
                "fileType='" + fileType + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", poRowNo='" + poRowNo + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", fileTypeList=" + fileTypeList +
                '}';
    }
}
