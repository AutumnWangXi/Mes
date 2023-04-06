package com.jotime.web.service.sys.impl;

import java.util.List;

import com.jotime.common.core.text.Convert;
import com.jotime.web.domain.sys.SysJobTitle;
import com.jotime.web.mapper.sys.SysJobTitleMapper;
import com.jotime.web.service.sys.ISysJobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 职位Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
@Service
public class SysJobTitleServiceImpl implements ISysJobTitleService
{
    @Autowired
    private SysJobTitleMapper sysJobTitleMapper;

    /**
     * 查询职位
     * 
     * @param id 职位ID
     * @return 职位
     */
    @Override
    public SysJobTitle selectSysJobTitleById(Long id)
    {
        return sysJobTitleMapper.selectSysJobTitleById(id);
    }

    /**
     * 根据职位名称查询
     *
     * @param jobTitle 职位名称
     * @return 职位
     */
    @Override
    public SysJobTitle selectSysJobTitleByName(String jobTitle) {
        return sysJobTitleMapper.selectSysJobTitleByName(jobTitle);
    }

    /**
     * 查询职位列表
     * 
     * @param sysJobTitle 职位
     * @return 职位
     */
    @Override
    public List<SysJobTitle> selectSysJobTitleList(SysJobTitle sysJobTitle)
    {
        return sysJobTitleMapper.selectSysJobTitleList(sysJobTitle);
    }

    /**
     * 新增职位
     * 
     * @param sysJobTitle 职位
     * @return 结果
     */
    @Override
    public int insertSysJobTitle(SysJobTitle sysJobTitle)
    {
        return sysJobTitleMapper.insertSysJobTitle(sysJobTitle);
    }

    /**
     * 修改职位
     * 
     * @param sysJobTitle 职位
     * @return 结果
     */
    @Override
    public int updateSysJobTitle(SysJobTitle sysJobTitle)
    {
        return sysJobTitleMapper.updateSysJobTitle(sysJobTitle);
    }

    /**
     * 删除职位对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysJobTitleByIds(String ids)
    {
        return sysJobTitleMapper.deleteSysJobTitleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除职位信息
     * 
     * @param id 职位ID
     * @return 结果
     */
    @Override
    public int deleteSysJobTitleById(Long id)
    {
        return sysJobTitleMapper.deleteSysJobTitleById(id);
    }
}
