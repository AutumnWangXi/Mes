package com.jotime.web.service.Apvl.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.joTime.ApplyStatus;
import com.jotime.web.domain.Apvl.ApvlApprover;
import com.jotime.web.domain.Apvl.ApvlProcessConfiguration;
import com.jotime.web.domainVo.apvl.ApvlApproverVo;
import com.jotime.web.mapper.Apvl.ApvlApproverMapper;
import com.jotime.web.service.Apvl.IApvlApproverService;
import com.jotime.web.service.Apvl.IApvlProcessConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 审批人员Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@Service
public class ApvlApproverServiceImpl extends ServiceImpl<ApvlApproverMapper, ApvlApprover> implements IApvlApproverService {
    @Autowired
    private ApvlApproverMapper apvlApproverMapper;
    @Autowired
    private IApvlProcessConfigurationService iApvlProcessConfigurationService;

    /**
     * 查询审批人员
     *
     * @param id 审批人员主键
     * @return 审批人员
     */
    @Override
    public ApvlApprover selectApvlApproverById(Long id) {
        return apvlApproverMapper.selectApvlApproverById(id);
    }

    /**
     * 查询审批人员列表
     *
     * @param apvlApprover 审批人员
     * @return 审批人员
     */
    @Override
    public List<ApvlApprover> selectApvlApproverList(ApvlApprover apvlApprover) {
        return apvlApproverMapper.selectApvlApproverList(apvlApprover);
    }

    /**
     * 查询审批人员列表Vo
     *
     * @param apvlApprover 审批人员
     * @return 审批人员
     */
    @Override
    public List<ApvlApproverVo> selectApvlApproverVoList(ApvlApprover apvlApprover) {
        return apvlApproverMapper.selectApvlApproverVoList(apvlApprover);
    }

    /**
     * 新增审批人员
     *
     * @param apvlApprover 审批人员
     * @return 结果
     */
    @Override
    public int insertApvlApprover(ApvlApprover apvlApprover) {
        apvlApprover.setCreateTime(DateUtils.getNowDate());
        return apvlApproverMapper.insertApvlApprover(apvlApprover);
    }

    @Override
    public int insertApvlApproverVo(ApvlApproverVo apvlApprover, String userName) {
        apvlApprover.setCreateTime(DateUtils.getNowDate());


        if (apvlApprover.getApproverId() == null || "".equals(apvlApprover.getApproverId())) {
            return 0;
        }
        int sum = 0;
        String[] splitId = apvlApprover.getApproverId().split(",");
        String[] splitName = apvlApprover.getApprover().split(",");
        ApvlApprover approver = new ApvlApprover();
        approver.setCreateBy(userName);
        approver.setModuleId(apvlApprover.getModuleId());
        approver.setNodeId(apvlApprover.getNodeId());
        approver.setNote(apvlApprover.getNote());
        approver.setStatus(apvlApprover.getStatus());
        approver.setCreateTime(DateUtils.getNowDate());
        approver.setUpdateBy(userName);
        approver.setUpdateTime(DateUtils.getNowDate());

        for (int i = 0; i < splitId.length; i++) {
            approver.setApproverId(Integer.valueOf(splitId[i]).longValue());
            approver.setApprover(splitName[i]);
            sum += apvlApproverMapper.insertApvlApprover(approver);
        }
        return sum;
    }


    /**
     * 修改审批人员
     *
     * @param apvlApprover 审批人员
     * @return 结果
     */
    @Override
    public int updateApvlApprover(ApvlApprover apvlApprover) {
        apvlApprover.setUpdateTime(DateUtils.getNowDate());
        return apvlApproverMapper.updateApvlApprover(apvlApprover);
    }

    @Override
    public int updateApvlApproverVo(ApvlApproverVo apvlApprover, String userName) {
        String[] splitId = apvlApprover.getApproverId().split(",");
        String[] splitName = apvlApprover.getApprover().split(",");
        ApvlApprover approver = new ApvlApprover();
        approver.setModuleId(apvlApprover.getModuleId());
        approver.setNodeId(apvlApprover.getNodeId());
        approver.setNote(apvlApprover.getNote());
        approver.setStatus(apvlApprover.getStatus());
        approver.setUpdateBy(userName);
        approver.setUpdateTime(new Date());
        if (splitId.length == 1) {
            approver.setId(apvlApprover.getId());
            approver.setApproverId(Integer.valueOf(splitId[0]).longValue());
            approver.setApprover(splitName[0]);
            return apvlApproverMapper.updateApvlApprover(approver);
        }
        int sum = 0;
        approver.setCreateTime(new Date());
        approver.setCreateBy(userName);
        for (int i = 0; i < splitId.length; i++) {
            approver.setApproverId(Integer.valueOf(splitId[i]).longValue());
            approver.setApprover(splitName[i]);
            sum += insertApvlApprover(approver);
        }
        return sum;
    }

    /**
     * 批量删除审批人员
     *
     * @param ids 需要删除的审批人员主键
     * @return 结果
     */
    @Override
    public int deleteApvlApproverByIds(Long[] ids) {
        return apvlApproverMapper.deleteApvlApproverByIds(ids);
    }

    /**
     * 删除审批人员信息
     *
     * @param id 审批人员主键
     * @return 结果
     */
    @Override
    public int deleteApvlApproverById(Long id) {
        return apvlApproverMapper.deleteApvlApproverById(id);
    }

    /**
     * 根据申请类型查询审批人员列表
     *
     * @param moduleId 流程内码
     * @param nodeId   节点内码
     * @return 审批人员集合
     */
    @Override
    public List<ApvlApprover> getApvlApproverListByModuleId(Long moduleId, Long nodeId) {
        return apvlApproverMapper.getApvlApproverListByModuleId(moduleId, nodeId);
    }

    /**
     * 查询审批人员
     *
     * @param approverId 审批人员内码
     * @param moduleId   流程ID
     * @return 审批人员
     */
    @Override
    public ApvlApprover selectApvlApproverByApproverId(Long approverId, Long moduleId) {

        return apvlApproverMapper.selectApvlApproverByApproverId(approverId, moduleId);
    }

    /**
     * 查询审批人员
     *
     * @param approverId 审批人员内码
     * @param nodeId 节点内码
     * @param moduleId   流程ID
     * @return 审批人员
     */
    @Override
    public ApvlApprover selectApvlApproverByApproverIdAndNodeId(Long approverId, Long nodeId, Long moduleId) {
        return apvlApproverMapper.selectApvlApproverByApproverIdAndNodeId(approverId, nodeId, moduleId);
    }

    /**
     * 查询审批人员
     *
     * @param approverId 审批人员内码
     * @return 审批人员
     */
    @Override
    public List<ApvlApprover> selectApvlApproverByApproverId(Long approverId) {
        ApvlApprover apvlApprover = new ApvlApprover();
        apvlApprover.setApproverId(approverId);
        return apvlApproverMapper.selectApvlApproverList(apvlApprover);
    }

}
