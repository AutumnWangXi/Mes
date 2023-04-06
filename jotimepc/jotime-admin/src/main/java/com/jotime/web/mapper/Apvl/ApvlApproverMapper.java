package com.jotime.web.mapper.Apvl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.Apvl.ApvlApprover;
import com.jotime.web.domainVo.apvl.ApvlApproverVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 审批人员Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public interface ApvlApproverMapper extends BaseMapper<ApvlApprover>
{
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

    /**
     * 修改审批人员
     *
     * @param apvlApprover 审批人员
     * @return 结果
     */
    public int updateApvlApprover(ApvlApprover apvlApprover);

    /**
     * 删除审批人员
     *
     * @param id 审批人员主键
     * @return 结果
     */
    public int deleteApvlApproverById(Long id);

    /**
     * 批量删除审批人员
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApvlApproverByIds(Long[] ids);

    /**
     * 根据申请类型查询审批人员列表
     *
     * @param moduleId 流程内码
     * @param nodeId 节点内码
     * @return 审批人员集合
     */
    public List<ApvlApprover> getApvlApproverListByModuleId(@Param("moduleId") Long moduleId, @Param("nodeId") Long nodeId);

    /**
     * 查询审批人员
     *
     * @param approverId 审批人员内码
     * @param moduleId 流程ID
     * @return 审批人员
     */
    public ApvlApprover selectApvlApproverByApproverId(@Param("approverId") Long approverId,@Param("moduleId")Long moduleId);
    /**
     * 查询审批人员
     *
     * @param approverId 审批人员内码
     * @param nodeId 节点内码
     * @param moduleId   流程ID
     * @return 审批人员
     */
    public ApvlApprover selectApvlApproverByApproverIdAndNodeId(@Param("approverId") Long approverId,@Param("nodeId") Long nodeId,@Param("moduleId")Long moduleId);

}
