package com.jotime.web.service.Apvl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.web.domain.Apvl.ApvlApprover;
import com.jotime.web.domainVo.apvl.ApvlApproverVo;

import java.util.List;

/**
 * 审批人员Service接口
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public interface IApvlApproverService extends IService<ApvlApprover> {
    /**
     * 查询审批人员
     *
     * @param id 审批人员主键
     * @return 审批人员
     */
    public ApvlApprover selectApvlApproverById(Long id);

    /**
     * 查询审批人员列表
     *
     * @param apvlApprover 审批人员
     * @return 审批人员集合
     */
    public List<ApvlApprover> selectApvlApproverList(ApvlApprover apvlApprover);

    /**
     * 查询审批人员列表Vo
     *
     * @param apvlApprover 审批人员
     * @return 审批人员集合
     */
    public List<ApvlApproverVo> selectApvlApproverVoList(ApvlApprover apvlApprover);

    /**
     * 新增审批人员
     *
     * @param apvlApprover 审批人员
     * @return 结果
     */
    public int insertApvlApprover(ApvlApprover apvlApprover);

    public int insertApvlApproverVo(ApvlApproverVo apvlApprover, String userName);

    /**
     * 修改审批人员
     *
     * @param apvlApprover 审批人员
     * @return 结果
     */
    public int updateApvlApprover(ApvlApprover apvlApprover);

    /**
     * 修改审批人员
     *
     * @param apvlApprover 审批人员
     * @return 结果
     */
    public int updateApvlApproverVo(ApvlApproverVo apvlApprover, String userName);


    /**
     * 批量删除审批人员
     *
     * @param ids 需要删除的审批人员主键集合
     * @return 结果
     */
    public int deleteApvlApproverByIds(Long[] ids);

    /**
     * 删除审批人员信息
     *
     * @param id 审批人员主键
     * @return 结果
     */
    public int deleteApvlApproverById(Long id);

    /**
     * 根据申请类型查询审批人员列表
     *
     * @param moduleId 流程内码
     * @param nodeId   节点内码
     * @return 审批人员集合
     */
    public List<ApvlApprover> getApvlApproverListByModuleId(Long moduleId, Long nodeId);


    /**
     * 查询审批人员
     *
     * @param approverId 审批人员内码
     * @param moduleId   流程ID
     * @return 审批人员
     */
    public ApvlApprover selectApvlApproverByApproverId(Long approverId, Long moduleId);

    /**
     * 查询审批人员
     *
     * @param approverId 审批人员内码
     * @param nodeId 节点内码
     * @param moduleId   流程ID
     * @return 审批人员
     */
    public ApvlApprover selectApvlApproverByApproverIdAndNodeId(Long approverId, Long nodeId, Long moduleId);

    /**
     * 查询审批人员
     *
     * @param approverId 审批人员内码
     * @return 审批人员
     */
    public List<ApvlApprover> selectApvlApproverByApproverId(Long approverId);

}
