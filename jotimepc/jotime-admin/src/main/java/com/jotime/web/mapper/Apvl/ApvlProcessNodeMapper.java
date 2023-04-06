package com.jotime.web.mapper.Apvl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.Apvl.ApvlProcessNode;
import com.jotime.web.domainVo.apvl.ApvlProcessNodeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 审批流程节点Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public interface ApvlProcessNodeMapper extends BaseMapper<ApvlProcessNode>
{
    /**
     * 查询审批流程节点
     *
     * @param id 审批流程节点主键
     * @return 审批流程节点
     */
    public ApvlProcessNode selectApvlProcessNodeById(Long id);

    /**
     * 查询审批流程节点列表
     *
     * @param apvlProcessNode 审批流程节点
     * @return 审批流程节点集合
     */
    public List<ApvlProcessNode> selectApvlProcessNodeList(ApvlProcessNode apvlProcessNode);

    /**
     * 查询审批流程节点列表
     *
     * @param apvlProcessNode 审批流程节点
     * @return 审批流程节点集合
     */
    public List<ApvlProcessNodeVo> selectApvlProcessNodeVoList(ApvlProcessNode apvlProcessNode);

    /**
     * 新增审批流程节点
     *
     * @param apvlProcessNode 审批流程节点
     * @return 结果
     */
    public int insertApvlProcessNode(ApvlProcessNode apvlProcessNode);

    /**
     * 修改审批流程节点
     *
     * @param apvlProcessNode 审批流程节点
     * @return 结果
     */
    public int updateApvlProcessNode(ApvlProcessNode apvlProcessNode);

    /**
     * 删除审批流程节点
     *
     * @param id 审批流程节点主键
     * @return 结果
     */
    public int deleteApvlProcessNodeById(Long id);

    /**
     * 批量删除审批流程节点
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApvlProcessNodeByIds(Long[] ids);

    /**
     *根据流程内码查询流程信息
     * @param moduleId 流程内码
     * @param isProposer 是否是审批人
     * @return 流程对象
     */
    public ApvlProcessNode getNodeListByModuleIdAndIsProposer(@Param("moduleId") Long moduleId, @Param("isProposer") Long isProposer);
}
