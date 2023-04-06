package com.jotime.web.service.message.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.message.SysMessageReceive;
import com.jotime.web.mapper.message.SysMessageReceiveMapper;
import com.jotime.web.service.message.ISysMessageReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 站内信消息状态Service业务层处理
 * 
 * @author yunmoqian
 * @date 2022-04-15
 */
@Service
public class SysMessageReceiveServiceImpl implements ISysMessageReceiveService
{
    @Autowired
    private SysMessageReceiveMapper sysMessageReceiveMapper;

    /**
     * 查询站内信消息状态
     * 
     * @param id 站内信消息状态主键
     * @return 站内信消息状态
     */
    @Override
    public SysMessageReceive selectSysMessageReceiveById(Long id)
    {
        return sysMessageReceiveMapper.selectSysMessageReceiveById(id);
    }

    /**
     * 查询站内信消息状态列表
     * 
     * @param sysMessageReceive 站内信消息状态
     * @return 站内信消息状态
     */
    @Override
    public List<SysMessageReceive> selectSysMessageReceiveList(SysMessageReceive sysMessageReceive)
    {
        return sysMessageReceiveMapper.selectSysMessageReceiveList(sysMessageReceive);
    }

    /**
     * 新增站内信消息状态
     * 
     * @param sysMessageReceive 站内信消息状态
     * @return 结果
     */
    @Override
    public int insertSysMessageReceive(SysMessageReceive sysMessageReceive)
    {
        sysMessageReceive.setReceiveId(SecurityUtils.getUserId());
        sysMessageReceive.setCreateBy(SecurityUtils.getNickName());
        sysMessageReceive.setCreateTime(DateUtils.getNowDate());
        return sysMessageReceiveMapper.insertSysMessageReceive(sysMessageReceive);
    }

    /**
     * 修改站内信消息状态
     * 
     * @param sysMessageReceive 站内信消息状态
     * @return 结果
     */
    @Override
    public int updateSysMessageReceive(SysMessageReceive sysMessageReceive)
    {
        sysMessageReceive.setUpdateTime(DateUtils.getNowDate());
        return sysMessageReceiveMapper.updateSysMessageReceive(sysMessageReceive);
    }

    /**
     * 批量删除站内信消息状态
     * 
     * @param ids 需要删除的站内信消息状态主键
     * @return 结果
     */
    @Override
    public int deleteSysMessageReceiveByIds(Long[] ids)
    {
        return sysMessageReceiveMapper.deleteSysMessageReceiveByIds(ids);
    }

    /**
     * 删除站内信消息状态信息
     * 
     * @param id 站内信消息状态主键
     * @return 结果
     */
    @Override
    public int deleteSysMessageReceiveById(Long id)
    {
        return sysMessageReceiveMapper.deleteSysMessageReceiveById(id);
    }
}
