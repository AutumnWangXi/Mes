package com.jotime.web.mapper.pd;

import com.jotime.web.domain.pd.PdProcessConfiguration;
import com.jotime.web.domainVo.pd.PdProcessConfigurationVo;

import java.util.List;

/**
 * 描述：生产流程配置Mapper接口
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
public interface PdProcessConfigurationMapper 
{
    /**
     * 查询描述：生产流程配置
     * 
     * @param id 描述：生产流程配置主键
     * @return 描述：生产流程配置
     */
    public PdProcessConfiguration selectPdProcessConfigurationById(Long id);

    /**
     * 查询描述：生产流程配置列表
     * 
     * @param pdProcessConfiguration 描述：生产流程配置
     * @return 描述：生产流程配置集合
     */
    public List<PdProcessConfiguration> selectPdProcessConfigurationList(PdProcessConfiguration pdProcessConfiguration);


    /**
     * 新增描述：生产流程配置
     * 
     * @param pdProcessConfiguration 描述：生产流程配置
     * @return 结果
     */
    public int insertPdProcessConfiguration(PdProcessConfiguration pdProcessConfiguration);

    /**
     * 修改描述：生产流程配置
     * 
     * @param pdProcessConfiguration 描述：生产流程配置
     * @return 结果
     */
    public int updatePdProcessConfiguration(PdProcessConfiguration pdProcessConfiguration);

    /**
     * 删除描述：生产流程配置
     * 
     * @param id 描述：生产流程配置主键
     * @return 结果
     */
    public int deletePdProcessConfigurationById(Long id);

    /**
     * 批量删除描述：生产流程配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePdProcessConfigurationByIds(Long[] ids);


    /**
     * 查询描述：生产流程配置列表
     *
     * @param pdProcessConfigurationVo 描述：生产流程配置
     * @return 描述：生产流程配置集合
     */
    public List<PdProcessConfigurationVo> selectPdProcessConfigurationVoList(PdProcessConfigurationVo pdProcessConfigurationVo);
}
