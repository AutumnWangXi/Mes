package com.jotime.web.service.pd.impl;

import com.jotime.common.constant.ApvlStatusConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.pd.PdProcessConfiguration;
import com.jotime.web.domainVo.pd.PdProcessConfigurationVo;
import com.jotime.web.mapper.pd.PdProcessConfigurationMapper;
import com.jotime.web.service.pd.IPdProcessConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 描述：生产流程配置Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-05-06
 */
@Service
public class PdProcessConfigurationServiceImpl implements IPdProcessConfigurationService {
    @Autowired
    private PdProcessConfigurationMapper pdProcessConfigurationMapper;

    /**
     * 查询描述：生产流程配置
     *
     * @param id 描述：生产流程配置主键
     * @return 描述：生产流程配置
     */
    @Override
    public PdProcessConfiguration selectPdProcessConfigurationById(Long id) {
        return pdProcessConfigurationMapper.selectPdProcessConfigurationById(id);
    }

    /**
     * 查询描述：生产流程配置列表
     *
     * @param pdProcessConfiguration 描述：生产流程配置
     * @return 描述：生产流程配置
     */
    @Override
    public List<PdProcessConfiguration> selectPdProcessConfigurationList(PdProcessConfiguration pdProcessConfiguration) {
        return pdProcessConfigurationMapper.selectPdProcessConfigurationList(pdProcessConfiguration);
    }

    /**
     * 新增描述：生产流程配置
     *
     * @param pdProcessConfiguration 描述：生产流程配置
     * @return 结果
     */
    @Override
    public int insertPdProcessConfiguration(PdProcessConfiguration pdProcessConfiguration) {
        pdProcessConfiguration.setCreateTime(DateUtils.getNowDate());
        return pdProcessConfigurationMapper.insertPdProcessConfiguration(pdProcessConfiguration);
    }

    /**
     * 修改描述：生产流程配置
     *
     * @param pdProcessConfiguration 描述：生产流程配置
     * @return 结果
     */
    @Override
    public int updatePdProcessConfiguration(PdProcessConfiguration pdProcessConfiguration) {
        pdProcessConfiguration.setUpdateTime(DateUtils.getNowDate());
        return pdProcessConfigurationMapper.updatePdProcessConfiguration(pdProcessConfiguration);
    }

    /**
     * 批量删除描述：生产流程配置
     *
     * @param ids 需要删除的描述：生产流程配置主键
     * @return 结果
     */
    @Override
    public int deletePdProcessConfigurationByIds(Long[] ids) {
        return pdProcessConfigurationMapper.deletePdProcessConfigurationByIds(ids);
    }

    /**
     * 删除描述：生产流程配置信息
     *
     * @param id 描述：生产流程配置主键
     * @return 结果
     */
    @Override
    public int deletePdProcessConfigurationById(Long id) {
        return pdProcessConfigurationMapper.deletePdProcessConfigurationById(id);
    }


    /**
     * @param pdProcessConfigurationVo 描述：生产流程配置
     * @return 描述：生产流程配置集合
     * @Author: chenKuo
     * @Date: 2022-05-07 11:18
     * 查询描述：生产流程配置列表
     */
    @Override
    public List<PdProcessConfigurationVo> selectPdProcessConfigurationVoList(PdProcessConfigurationVo pdProcessConfigurationVo) {
        return pdProcessConfigurationMapper.selectPdProcessConfigurationVoList(pdProcessConfigurationVo);
    }

    /**
     * 新增流程配置
     *
     * @param pdProcessConfiguration 描述：生产流程配置
     * @return 结果
     * @Author: chen
     */
    @Override
    public int addToPdProcessConfiguration(PdProcessConfiguration pdProcessConfiguration) {
        //查询祖列表
        PdProcessConfiguration configuration = new PdProcessConfiguration();
        configuration.setModuleId(pdProcessConfiguration.getModuleId());
        configuration.setNextNode(pdProcessConfiguration.getPreNode());
        configuration.setStatus(ApvlStatusConstants.NORMAL_STATUS);
        List<PdProcessConfiguration> processConfigurations = pdProcessConfigurationMapper.selectPdProcessConfigurationList(configuration);
        //设置祖级列表信息
        if (StringUtils.isNotEmpty(processConfigurations)) {
            pdProcessConfiguration.setAncestors(processConfigurations.get(0).getAncestors() + Constants.DASH_COMMA + configuration.getNextNode());
        } else {
            pdProcessConfiguration.setAncestors(pdProcessConfiguration.getPreNode() + Constants.DASH_COMMA + pdProcessConfiguration.getNextNode());
        }
        return pdProcessConfigurationMapper.insertPdProcessConfiguration(pdProcessConfiguration);
    }
}
