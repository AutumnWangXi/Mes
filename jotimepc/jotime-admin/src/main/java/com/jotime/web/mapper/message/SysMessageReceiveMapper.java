package com.jotime.web.mapper.message;

import com.jotime.web.domain.message.SysMessageReceive;

import java.util.List;

/**
 * 站内信消息状态Mapper接口
 * 
 * @author yunmoqian
 * @date 2022-04-15
 */
public interface SysMessageReceiveMapper 
{
    /**
     * 查询站内信消息状态
     * 
     * @param id 站内信消息状态主键
     * @return 站内信消息状态
     */
    public SysMessageReceive selectSysMessageReceiveById(Long id);

    /**
     * 查询站内信消息状态列表
     * 
     * @param sysMessageReceive 站内信消息状态
     * @return 站内信消息状态集合
     */
    public List<SysMessageReceive> selectSysMessageReceiveList(SysMessageReceive sysMessageReceive);

    /**
     * 新增站内信消息状态
     * 
     * @param sysMessageReceive 站内信消息状态
     * @return 结果
     */
    public int insertSysMessageReceive(SysMessageReceive sysMessageReceive);

    /**
     * 修改站内信消息状态
     * 
     * @param sysMessageReceive 站内信消息状态
     * @return 结果
     */
    public int updateSysMessageReceive(SysMessageReceive sysMessageReceive);

    /**
     * 删除站内信消息状态
     * 
     * @param id 站内信消息状态主键
     * @return 结果
     */
    public int deleteSysMessageReceiveById(Long id);

    /**
     * 批量删除站内信消息状态
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMessageReceiveByIds(Long[] ids);
}
