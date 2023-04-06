package com.jotime.web.service.Apvl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.web.domain.Apvl.ApvlProcessNode;
import com.jotime.web.domainVo.apvl.ApvlProcessNodeVo;

import java.util.List;

/**
 * 审批流程节点Service接口
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public interface IApvlProcessNodeService extends IService<ApvlProcessNode>
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
     * 获取流程对应节点列表
     * @param isProposer 是否申请人，1，不是，2，是
     */
    public List<ApvlProcessNode> getNodeList( Long moduleId,Integer isProposer);
    /**
     * 查询审批流程节点列表,页面显示
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
     * 批量删除审批流程节点
     *
     * @param ids 需要删除的审批流程节点主键集合
     * @return 结果
     */
    public int deleteApvlProcessNodeByIds(Long[] ids);

    /**
     * 删除审批流程节点信息
     *
     * @param id 审批流程节点主键
     * @return 结果
     */
    public int deleteApvlProcessNodeById(Long id);

    /**
     *根据流程内码查询流程信息
     * @param moduleId 流程内码
     * @param isProposer 是否是申请人 2 是 1 不是
     * @return 流程对象
     */
    public ApvlProcessNode getNodeListByModuleIdAndIsProposer(Long moduleId,Long isProposer);
}
