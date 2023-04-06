package com.jotime.web.mapper.sys;


import com.jotime.web.domain.sys.SysJobTitle;

import java.util.List;

/**
 * 职位Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
public interface SysJobTitleMapper 
{
    /**
     * 查询职位
     * 
     * @param id 职位ID
     * @return 职位
     */
    public SysJobTitle selectSysJobTitleById(Long id);

    /**
     * 根据职位名称查询
     *
     * @param jobTitle 职位名称
     * @return 职位
     */
    public SysJobTitle selectSysJobTitleByName(String jobTitle);

    /**
     * 查询职位列表
     * 
     * @param sysJobTitle 职位
     * @return 职位集合
     */
    public List<SysJobTitle> selectSysJobTitleList(SysJobTitle sysJobTitle);

    /**
     * 新增职位
     * 
     * @param sysJobTitle 职位
     * @return 结果
     */
    public int insertSysJobTitle(SysJobTitle sysJobTitle);

    /**
     * 修改职位
     * 
     * @param sysJobTitle 职位
     * @return 结果
     */
    public int updateSysJobTitle(SysJobTitle sysJobTitle);

    /**
     * 删除职位
     * 
     * @param id 职位ID
     * @return 结果
     */
    public int deleteSysJobTitleById(Long id);

    /**
     * 批量删除职位
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysJobTitleByIds(String[] ids);
}
