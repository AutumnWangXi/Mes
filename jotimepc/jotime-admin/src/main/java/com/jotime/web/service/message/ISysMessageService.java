package com.jotime.web.service.message;

import com.jotime.web.domain.message.SysMessage;

import java.util.List;

/**
 * 站内信消息内容Service接口
 * 
 * @author yunmoqian
 * @date 2022-04-15
 */
public interface ISysMessageService 
{
    /**
     * 查询站内信消息内容
     * 
     * @param id 站内信消息内容主键
     * @return 站内信消息内容
     */
    public SysMessage selectSysMessageById(Long id);

    /**
     * 查询站内信消息内容列表
     * 
     * @param sysMessage 站内信消息内容
     * @return 站内信消息内容集合
     */
    public List<SysMessage> selectSysMessageList(SysMessage sysMessage);

    /**
     * 查询站内信消息内容列表(未读数量)
     *
     * @param sysMessage 站内信消息内容
     * @return 站内信消息内容集合
     */
    public int selectSysMessageListCount(SysMessage sysMessage);
    /**
     * 新增站内信消息内容
     * 
     * @param sysMessage 站内信消息内容
     * @return 结果
     */
    public int insertSysMessage(SysMessage sysMessage);

    /**
     * 修改站内信消息内容
     * 
     * @param sysMessage 站内信消息内容
     * @return 结果
     */
    public int updateSysMessage(SysMessage sysMessage);

    /**
     * 批量删除站内信消息内容
     * 
     * @param ids 需要删除的站内信消息内容主键集合
     * @return 结果
     */
    public int deleteSysMessageByIds(Long[] ids);

    /**
     * 删除站内信消息内容信息
     * 
     * @param id 站内信消息内容主键
     * @return 结果
     */
    public int deleteSysMessageById(Long id);
}
