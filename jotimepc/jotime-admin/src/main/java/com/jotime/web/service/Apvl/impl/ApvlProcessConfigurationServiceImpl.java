package com.jotime.web.service.Apvl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.bean.BeanUtils;
import com.jotime.web.domain.Apvl.ApvlProcessConfiguration;
import com.jotime.web.domainVo.apvl.ApvlProcessConfigurationVo;
import com.jotime.web.mapper.Apvl.ApvlProcessConfigurationMapper;
import com.jotime.web.service.Apvl.IApvlProcessConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 审批流程配置Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@Service
public class ApvlProcessConfigurationServiceImpl extends ServiceImpl<ApvlProcessConfigurationMapper, ApvlProcessConfiguration> implements IApvlProcessConfigurationService {
    @Autowired
    private ApvlProcessConfigurationMapper apvlProcessConfigurationMapper;

    /**
     * 查询审批流程配置
     *
     * @param id 审批流程配置主键
     * @return 审批流程配置
     */
    @Override
    public ApvlProcessConfiguration selectApvlProcessConfigurationById(Long id) {
        return apvlProcessConfigurationMapper.selectApvlProcessConfigurationById(id);
    }

    /**
     * 查询审批流程配置列表
     *
     * @param apvlProcessConfiguration 审批流程配置
     * @return 审批流程配置
     */
    @Override
    public List<ApvlProcessConfiguration> selectApvlProcessConfigurationList(ApvlProcessConfiguration apvlProcessConfiguration) {
        return apvlProcessConfigurationMapper.selectApvlProcessConfigurationList(apvlProcessConfiguration);
    }

    //    查询审批流程配置列表
    @Override
    public List<ApvlProcessConfigurationVo> selectApvlProcessConfigurationVoList(ApvlProcessConfiguration apvlProcessConfiguration) {
        return apvlProcessConfigurationMapper.selectApvlProcessConfigurationVoList(apvlProcessConfiguration);
    }

    /**
     * 新增审批流程配置
     *
     * @param apvlProcessConfigurationVo 审批流程配置
     * @return 结果
     */
    @Override
    public int insertApvlProcessConfiguration(ApvlProcessConfigurationVo apvlProcessConfigurationVo) {

        ApvlProcessConfiguration insConfiguration = new ApvlProcessConfiguration();
        // VO内容拷贝
        BeanUtils.copyBeanProp(insConfiguration, apvlProcessConfigurationVo);

        // 获取祖级列表信息
        ApvlProcessConfiguration selConfiguration = new ApvlProcessConfiguration();
        selConfiguration.setModuleId(insConfiguration.getModuleId());
        selConfiguration.setNextNode(insConfiguration.getPreNode());
        selConfiguration.setStatus(2);
        List<ApvlProcessConfiguration> configurationList = apvlProcessConfigurationMapper.selectApvlProcessConfigurationByNode(selConfiguration);
        // 流程配置第一次建场合
        if (configurationList == null || configurationList.size() == 0) {
            insConfiguration.setAncestors(insConfiguration.getPreNode() + "," + insConfiguration.getNextNode());
        } else {
            insConfiguration.setAncestors(configurationList.get(0).getAncestors() + "," + insConfiguration.getNextNode());
        }

        // 创建用户设定
        insConfiguration.setCreateBy(SecurityUtils.getUsername());
        if (StringUtils.isNull(insConfiguration.getStatus())) {
            insConfiguration.setStatus(2);
        }

        return apvlProcessConfigurationMapper.insertApvlProcessConfiguration(insConfiguration);
    }

    /**
     * 查询当前登录用户是否是审批人
     * @param approverId 登录ID
     * @param moduleId 审批名称ID
     * @return 查询结果
     */
    @Override
    public ApvlProcessConfiguration selectNodeByApproverId(Long approverId,Long moduleId) {
        return apvlProcessConfigurationMapper.selectNodeByApproverId(approverId,moduleId);
    }

    /**
     * 修改审批流程配置
     *
     * @param apvlProcessConfiguration 审批流程配置
     * @return 结果
     */
    @Override
    public int updateApvlProcessConfiguration(ApvlProcessConfiguration apvlProcessConfiguration) {
        apvlProcessConfiguration.setUpdateBy(SecurityUtils.getUsername());
        return apvlProcessConfigurationMapper.updateApvlProcessConfiguration(apvlProcessConfiguration);
    }

    /**
     * 批量删除审批流程配置
     *
     * @param ids 需要删除的审批流程配置主键
     * @return 结果
     */
    @Override
    public int deleteApvlProcessConfigurationByIds(Long[] ids) {
        return apvlProcessConfigurationMapper.deleteApvlProcessConfigurationByIds(ids);
    }

    /**
     * 删除审批流程配置信息
     *
     * @param id 审批流程配置主键
     * @return 结果
     */
    @Override
    public int deleteApvlProcessConfigurationById(Long id) {
        return apvlProcessConfigurationMapper.deleteApvlProcessConfigurationById(id);
    }

    /**
     * 根据申请内码查询配置信息
     *
     * @param moduleId 申请内码
     * @return 配置信息
     */
    @Override
    public List<ApvlProcessConfiguration> getConfigurationListByModuleId(Long moduleId) {
        return apvlProcessConfigurationMapper.getConfigurationListByModuleId(moduleId);
    }

    /**
     * 根据申请内码查询配置信息
     *
     * @param moduleId 申请内码
     * @param preNode  上一个节点
     * @return 配置信息
     */
    @Override
    public ApvlProcessConfiguration getConfigurationByModuleIdAndPreNode(Long moduleId, Long preNode) {
        return apvlProcessConfigurationMapper.getConfigurationByModuleIdAndPreNode(moduleId, preNode);
    }

    /**
     * 查询审批流程配置列表
     *
     * @param apvlProcessConfiguration 审批流程配置
     * @return 审批流程配置
     */
    @Override
    public List<ApvlProcessConfigurationVo> selectProcessConfigurationInfo(ApvlProcessConfiguration apvlProcessConfiguration) {
        return apvlProcessConfigurationMapper.selectProcessConfigurationInfo(apvlProcessConfiguration);
    }
}
