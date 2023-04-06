package com.jotime.web.domain.message;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import com.jotime.common.utils.SecurityUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 站内信消息内容对象 sys_message
 * 
 * @author yunmoqian
 * @date 2022-04-15
 */
public class SysMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 发送人id */
    @Excel(name = "发送人id")
    private Long sendId;

    /** 接收人id */
    @Excel(name = "接收人id")
    private String receiveId;

    /** 站内信标题 */
    @Excel(name = "站内信标题")
    private String messageTitle;

    /** 站内信内容 */
    @Excel(name = "站内信内容")
    private String messageContent;

    /** 接收人类型(1 全员  2 指定人员) */
    @Excel(name = "接收人类型(1 全员  2 指定人员)")
    private Integer receiveType;

    /** 发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    /** 发信人信息状态(1已发送 2删除) */
    @Excel(name = "发信人信息状态(1已发送 2删除)")
    private Integer sendStatus;

    /** 收信人信息状态 (1已接收 2删除) */
    @Excel(name = "收信人信息状态 (1已接收 2删除)")
    private Integer receiveStatus;

    private Integer read;

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

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
    public void setReceiveId(String receiveId)
    {
        this.receiveId = receiveId;
    }

    public String getReceiveId()
    {
        return receiveId;
    }
    public void setMessageTitle(String messageTitle) 
    {
        this.messageTitle = messageTitle;
    }

    public String getMessageTitle() 
    {
        return messageTitle;
    }
    public void setMessageContent(String messageContent) 
    {
        this.messageContent = messageContent;
    }

    public String getMessageContent() 
    {
        return messageContent;
    }
    public void setReceiveType(Integer receiveType) 
    {
        this.receiveType = receiveType;
    }

    public Integer getReceiveType() 
    {
        return receiveType;
    }
    public void setSendTime(Date sendTime) 
    {
        this.sendTime = sendTime;
    }

    public Date getSendTime() 
    {
        return sendTime;
    }
    public void setSendStatus(Integer sendStatus) 
    {
        this.sendStatus = sendStatus;
    }

    public Integer getSendStatus() 
    {
        return sendStatus;
    }
    public void setReceiveStatus(Integer receiveStatus) 
    {
        this.receiveStatus = receiveStatus;
    }

    public Integer getReceiveStatus() 
    {
        return receiveStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sendId", getSendId())
            .append("receiveId", getReceiveId())
            .append("messageTitle", getMessageTitle())
            .append("messageContent", getMessageContent())
            .append("receiveType", getReceiveType())
            .append("sendTime", getSendTime())
            .append("sendStatus", getSendStatus())
            .append("receiveStatus", getReceiveStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
    /**
     * @Author zhengsj
     * @Description //TODO 创建消息对象
     * @Date 2022/4/15 17:32
     * @Param [messageTitle, messageContent, ReceiveId, receiveType]
     * @return com.jotime.web.domain.message.SysMessage
     **/
    public static SysMessage getMessageDo(String messageTitle,String messageContent,String ReceiveId,int receiveType){
        SysMessage sysMessage = new SysMessage();
        sysMessage.setSendId(SecurityUtils.getUserId());
        sysMessage.setReceiveId(ReceiveId);
        sysMessage.setMessageTitle(messageTitle);
        sysMessage.setMessageContent(messageContent);
        sysMessage.setReceiveType(receiveType);
        sysMessage.setSendTime(new Date());
        sysMessage.setSendStatus(1);
        sysMessage.setReceiveStatus(1);
        sysMessage.setCreateBy(SecurityUtils.getNickName());
        sysMessage.setCreateTime(new Date());
        return sysMessage;
    }
}
