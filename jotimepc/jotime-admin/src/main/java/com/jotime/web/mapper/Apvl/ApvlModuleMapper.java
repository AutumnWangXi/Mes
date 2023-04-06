package com.jotime.web.mapper.Apvl;


import com.jotime.web.domain.Apvl.ApvlModule;

import java.util.List;

/**
 * 审批流程名称Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-26
 */
public interface ApvlModuleMapper 
{
    /**
     * 查询审批流程名称
     * 
     * @param id 审批流程名称主键
     * @return 审批流程名称
     */
    public ApvlModule selectApvlModuleById(Long id);

    /**
     * 查询审批流程名称列表
     * 
     * @param apvlModule 审批流程名称
     * @return 审批流程名称集合
     */
    public List<ApvlModule> selectApvlModuleList(ApvlModule apvlModule);

    /**
     * 新增审批流程名称
     * 
     * @param apvlModule 审批流程名称
     * @return 结果
     */
    public int insertApvlModule(ApvlModule apvlModule);

    /**
     * 修改审批流程名称
     * 
     * @param apvlModule 审批流程名称
     * @return 结果
     */
    public int updateApvlModule(ApvlModule apvlModule);

    /**
     * 删除审批流程名称
     * 
     * @param id 审批流程名称主键
     * @return 结果
     */
    public int deleteApvlModuleById(Long id);

    /**
     * 批量删除审批流程名称
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApvlModuleByIds(Long[] ids);

    /**
     *根据流程名称查询流程信息
     * @param moduleNo 流程编号
     * @return 流程对象
     */
    public ApvlModule getNodeByModuleNo(String moduleNo);
}
