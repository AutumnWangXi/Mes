package com.jotime.web.service.Apvl.impl;

import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.Apvl.ApvlModule;
import com.jotime.web.mapper.Apvl.ApvlModuleMapper;
import com.jotime.web.service.Apvl.IApvlModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 审批流程名称Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@Service
public class ApvlModuleServiceImpl implements IApvlModuleService
{
    @Autowired
    private ApvlModuleMapper apvlModuleMapper;

    /**
     * 查询审批流程名称
     *
     * @param id 审批流程名称主键
     * @return 审批流程名称
     */
    @Override
    public ApvlModule selectApvlModuleById(Long id)
    {
        return apvlModuleMapper.selectApvlModuleById(id);
    }

    /**
     * 查询审批流程名称列表
     *
     * @param apvlModule 审批流程名称
     * @return 审批流程名称
     */
    @Override
    public List<ApvlModule> selectApvlModuleList(ApvlModule apvlModule)
    {
        return apvlModuleMapper.selectApvlModuleList(apvlModule);
    }

    /**
     * 新增审批流程名称
     *
     * @param apvlModule 审批流程名称
     * @return 结果
     */
    @Override
    public int insertApvlModule(ApvlModule apvlModule)
    {

        ApvlModule apvlModule1 = new ApvlModule();
        apvlModule1.setModuleNo(apvlModule.getModuleNo());
        List<ApvlModule> apvlModules = apvlModuleMapper.selectApvlModuleList(apvlModule1);
        if (apvlModules.size()==0){
            apvlModule.setCreateBy(SecurityUtils.getUsername());
            return apvlModuleMapper.insertApvlModule(apvlModule);
        }
        return 0;



    }

    /**
     * 修改审批流程名称
     *
     * @param apvlModule 审批流程名称
     * @return 结果
     */
    @Override
    public int updateApvlModule(ApvlModule apvlModule)
    {
        apvlModule.setUpdateBy(SecurityUtils.getUsername());

        ApvlModule apvlModule1 = new ApvlModule();
        apvlModule1.setModuleNo(apvlModule.getModuleNo());
        List<ApvlModule> apvlModules = apvlModuleMapper.selectApvlModuleList(apvlModule1);
        if (apvlModules.size()>0&&!apvlModule.getId().equals(apvlModules.get(0).getId())){
            return 0;
        }
        return apvlModuleMapper.updateApvlModule(apvlModule);
    }

    /**
     * 批量删除审批流程名称
     *
     * @param ids 需要删除的审批流程名称主键
     * @return 结果
     */
    @Override
    public int deleteApvlModuleByIds(Long[] ids)
    {
        return apvlModuleMapper.deleteApvlModuleByIds(ids);
    }

    /**
     * 删除审批流程名称信息
     *
     * @param id 审批流程名称主键
     * @return 结果
     */
    @Override
    public int deleteApvlModuleById(Long id)
    {
        return apvlModuleMapper.deleteApvlModuleById(id);
    }

    /**
     *根据流程名称查询流程信息
     * @param moduleNo 流程编号
     * @return 流程对象
     */
    @Override
    public ApvlModule getNodeByModuleNo(String moduleNo){
        return apvlModuleMapper.getNodeByModuleNo(moduleNo);
    }
}
