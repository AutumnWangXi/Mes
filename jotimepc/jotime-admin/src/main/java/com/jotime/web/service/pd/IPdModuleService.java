package com.jotime.web.service.pd;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.pd.PdModule;

import java.util.List;

/**
 * 描述：生产流程名称Service接口
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
public interface IPdModuleService 
{
    /**
     * 查询描述：生产流程名称
     * 
     * @param id 描述：生产流程名称主键
     * @return 描述：生产流程名称
     */
    public PdModule selectPdModuleById(Long id);

    /**
     * 查询描述：生产流程名称列表
     * 
     * @param pdModule 描述：生产流程名称
     * @return 描述：生产流程名称集合
     */
    public List<PdModule> selectPdModuleList(PdModule pdModule);

    /**
     * 新增描述：生产流程名称
     * 
     * @param pdModule 描述：生产流程名称
     * @return 结果
     */
    public int insertPdModule(PdModule pdModule);

    /**
     * 修改描述：生产流程名称
     * 
     * @param pdModule 描述：生产流程名称
     * @return 结果
     */
    public int updatePdModule(PdModule pdModule);

    /**
     * 批量删除描述：生产流程名称
     * 
     * @param ids 需要删除的描述：生产流程名称主键集合
     * @return 结果
     */
    public int deletePdModuleByIds(Long[] ids);

    /**
     * 删除描述：生产流程名称信息
     * 
     * @param id 描述：生产流程名称主键
     * @return 结果
     */
    public int deletePdModuleById(Long id);

    /**
     * 生产流程详情
     */
    public AjaxResult moduleInfo(PdModule pdModule);
}
