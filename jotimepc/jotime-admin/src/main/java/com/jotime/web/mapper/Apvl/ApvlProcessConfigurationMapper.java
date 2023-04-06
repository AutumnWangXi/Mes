package com.jotime.web.mapper.Apvl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.Apvl.ApvlProcessConfiguration;
import com.jotime.web.domainVo.apvl.ApvlProcessConfigurationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 审批流程配置Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public interface ApvlProcessConfigurationMapper extends BaseMapper<ApvlProcessConfiguration>
{
    /**
     * 查询审批流程配置
     *
     * @param id 审批流程配置主键
     * @return 审批流程配置
     */
    public ApvlProcessConfiguration selectApvlProcessConfigurationById(Long id);

    /**
     * 查询审批流程配置列表
     *
     * @param apvlProcessConfiguration 审批流程配置
     * @return 审批流程配置集合
     */
    public List<ApvlProcessConfiguration> selectApvlProcessConfigurationList(ApvlProcessConfiguration apvlProcessConfiguration);
//    页面展示List
    public List<ApvlProcessConfigurationVo> selectApvlProcessConfigurationVoList(ApvlProcessConfiguration apvlProcessConfiguration);

    /**
     * 新增审批流程配置
     *
     * @param apvlProcessConfiguration 审批流程配置
     * @return 结果
     */
    public int insertApvlProcessConfiguration(ApvlProcessConfiguration apvlProcessConfiguration);

    /**
     * 修改审批流程配置
     *
     * @param apvlProcessConfiguration 审批流程配置
     * @return 结果
     */
    public int updateApvlProcessConfiguration(ApvlProcessConfiguration apvlProcessConfiguration);

    /**
     * 删除审批流程配置
     *
     * @param id 审批流程配置主键
     * @return 结果
     */
    public int deleteApvlProcessConfigurationById(Long id);

    /**
     * 批量删除审批流程配置
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApvlProcessConfigurationByIds(Long[] ids);

    /**
     * 根据申请内码查询配置信息
     * @param moduleId 申请内码
     * @return 配置信息
     */
    public List<ApvlProcessConfiguration> getConfigurationListByModuleId(Long moduleId);

    /**
     * 根据申请内码查询配置信息
     * @param moduleId 申请内码
     * @param preNode 上一个节点
     * @return 配置信息
     */
    public ApvlProcessConfiguration getConfigurationByModuleIdAndPreNode(@Param("moduleId") Long moduleId, @Param("preNode") Long preNode);


    /**
     * 查询当前登录用户是否是审批人
     * @param approverId 登录ID
     * @param moduleId 审批名称ID
     * @return 查询结果
     */
    public ApvlProcessConfiguration selectNodeByApproverId(@Param("approverId") Long approverId,@Param("moduleId")Long moduleId);
    /**
     * 根据申请内码查询配置信息
     * @param apvlProcessConfiguration 申配置信息
     * @return 配置信息
     */
    public List<ApvlProcessConfiguration> selectApvlProcessConfigurationByNode(ApvlProcessConfiguration apvlProcessConfiguration);
    /**
     * 根据申请内码查询配置信息
     * @param apvlProcessConfiguration 配置信息
     * @return 配置信息
     */
    public List<ApvlProcessConfigurationVo> selectProcessConfigurationInfo(ApvlProcessConfiguration apvlProcessConfiguration);

}
