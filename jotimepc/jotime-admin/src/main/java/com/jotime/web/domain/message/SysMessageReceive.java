package com.jotime.web.domain.message;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 站内信消息状态对象 sys_message_receive
 * 
 * @author yunmoqian
 * @date 2022-04-15
 */
public class SysMessageReceive extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 发送人id */
    @Excel(name = "发送人id")
    private Long sendId;

    /** 站内信id */
    @Excel(name = "站内信id")
    private Integer messageId;

    /** 接收人id */
    @Excel(name = "接收人id")
    private Long receiveId;

    /** 状态(1未读 2已读 3删除) */
    @Excel(name = "状态(1未读 2已读 3删除)")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSendId(Long sendId) 
    {
        this.sendId = sendId;
    }

    public Long getSendId() 
    {
        return sendId;
    }
    public void setMessageId(Integer messageId) 
    {
        this.messageId = messageId;
    }

    public Integer getMessageId() 
    {
        return messageId;
    }
    public void setReceiveId(Long receiveId) 
    {
        this.receiveId = receiveId;
    }

    public Long getReceiveId() 
    {
        return receiveId;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sendId", getSendId())
            .append("messageId", getMessageId())
            .append("receiveId", getReceiveId())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
