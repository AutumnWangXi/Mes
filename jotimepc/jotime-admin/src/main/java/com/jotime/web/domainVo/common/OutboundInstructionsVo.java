package com.jotime.web.domainVo.common;

import java.util.List;

/**
 * @author chenkuo
 * 出库指示Vo对象
 */
public class OutboundInstructionsVo {
	/**
     * 出库类型  '1预混料出库 2 内料出库 3 半成品出库 4销售出库 5 补料出库 99其他入库',  6 生产出库
     */
    private Integer outType;
    /**
     * 是否合并 1 合并 2 不合并
     */
    private Integer whetherToMerge;
    /**
     * 出库指示子类Vo列表
     */
	private List<OutboundVo> outboundVoList;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 订单内码
	 */
	private Long orderId;

    /** 来源类型（1：车间领料）*/
    private int sourceType;

	public int getSourceType() {
		return sourceType;
	}

	public void setSourceType(int sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getOutType() {
		return outType;
	}
	public void setOutType(Integer outType) {
		this.outType = outType;
	}
	public Integer getWhetherToMerge() {
		return whetherToMerge;
	}
	public void setWhetherToMerge(Integer whetherToMerge) {
		this.whetherToMerge = whetherToMerge;
	}
	public List<OutboundVo> getOutboundVoList() {
		return outboundVoList;
	}
	public void setOutboundVoList(List<OutboundVo> outboundVoList) {
		this.outboundVoList = outboundVoList;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
