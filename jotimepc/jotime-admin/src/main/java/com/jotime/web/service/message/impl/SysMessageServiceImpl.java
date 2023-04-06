package com.jotime.web.service.message.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.message.SysMessage;
import com.jotime.web.mapper.message.SysMessageMapper;
import com.jotime.web.service.message.ISysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 站内信消息内容Service业务层处理
 * 
 * @author yunmoqian
 * @date 2022-04-15
 */
@Service
public class SysMessageServiceImpl implements ISysMessageService
{
    @Autowired
    private SysMessageMapper sysMessageMapper;

    /**
     * 查询站内信消息内容
     * 
     * @param id 站内信消息内容主键
     * @return 站内信消息内容
     */
    @Override
    public SysMessage selectSysMessageById(Long id)
    {
        return sysMessageMapper.selectSysMessageById(id);
    }

    /**
     * 查询站内信消息内容列表
     * 
     * @param sysMessage 站内信消息内容
     * @return 站内信消息内容
     */
    @Override
    public List<SysMessage> selectSysMessageList(SysMessage sysMessage)
    {
        sysMessage.setReceiveId(SecurityUtils.getUserId()+"");
        return sysMessageMapper.selectSysMessageList(sysMessage);
    }

    @Override
    public int selectSysMessageListCount(SysMessage sysMessage) {
        sysMessage.setReceiveId(SecurityUtils.getUserId()+"");
        return sysMessageMapper.selectSysMessageListCount(sysMessage);
    }

    /**
     * 新增站内信消息内容
     * 
     * @param sysMessage 站内信消息内容
     * @return 结果
     */
    @Override
    public int insertSysMessage(SysMessage sysMessage)
    {
        sysMessage.setCreateTime(DateUtils.getNowDate());
        return sysMessageMapper.insertSysMessage(sysMessage);
    }

    /**
     * 修改站内信消息内容
     * 
     * @param sysMessage 站内信消息内容
     * @return 结果
     */
    @Override
    public int updateSysMessage(SysMessage sysMessage)
    {
        sysMessage.setUpdateTime(DateUtils.getNowDate());
        return sysMessageMapper.updateSysMessage(sysMessage);
    }

    /**
     * 批量删除站内信消息内容
     * 
     * @param ids 需要删除的站内信消息内容主键
     * @return 结果
     */
    @Override
    public int deleteSysMessageByIds(Long[] ids)
    {
        return sysMessageMapper.deleteSysMessageByIds(ids);
    }

    /**
     * 删除站内信消息内容信息
     * 
     * @param id 站内信消息内容主键
     * @return 结果
     */
    @Override
    public int deleteSysMessageById(Long id)
    {
        return sysMessageMapper.deleteSysMessageById(id);
    }
}
