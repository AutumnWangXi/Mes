package com.jotime.web.service.Apvl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.constant.ApvlConstants;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.domain.entity.SysUser;
import com.jotime.common.core.text.Convert;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.joTime.ApplyStatus;
import com.jotime.web.domain.Apvl.ApvlApprover;
import com.jotime.web.domain.Apvl.ApvlProcess;
import com.jotime.web.domain.Apvl.ApvlProcessNode;
import com.jotime.web.domainVo.apvl.ApvlProcessConfigurationVo;
import com.jotime.web.domainVo.apvl.ApvlProcessVo;
import com.jotime.web.mapper.Apvl.ApvlProcessMapper;
import com.jotime.web.service.Apvl.IApvlApproverService;
import com.jotime.web.service.Apvl.IApvlProcessConfigurationService;
import com.jotime.web.service.Apvl.IApvlProcessNodeService;
import com.jotime.web.service.Apvl.IApvlProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 审批流程配置Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-13
 */
@Service
public class ApvlProcessServiceImpl extends ServiceImpl<ApvlProcessMapper, ApvlProcess> implements IApvlProcessService {
    @Autowired
    private ApvlProcessMapper apvlProcessMapper;
    @Autowired
    private IApvlApproverService iApvlApproverService;
    @Autowired
    private IApvlProcessNodeService iApvlProcessNodeService;
    @Autowired
    private IApvlProcessConfigurationService apvlProcessConfigurationService;

    /**
     * 查询审批流程配置
     *
     * @param id 审批流程配置ID
     * @return 审批流程配置
     */
    @Override
    public ApvlProcess selectApvlProcessById(Long id) {
        return apvlProcessMapper.selectApvlProcessById(id);
    }

    /**
     * 查询审批流程配置列表
     *
     * @param apvlProcess 审批流程配置
     * @return 审批流程配置
     */
    @Override
    public List<ApvlProcess> selectApvlProcessList(ApvlProcess apvlProcess) {
        return apvlProcessMapper.selectApvlProcessList(apvlProcess);
    }

    @Override
    public List<ApvlProcessVo> selectApvlProcessVoList(ApvlProcess apvlProcess) {
        return apvlProcessMapper.selectApvlProcessVoList(apvlProcess);
    }

    /**
     * 新增审批流程配置
     *
     * @param apvlProcess 审批流程配置
     * @return 结果
     */
    @Override
    public int insertApvlProcess(ApvlProcess apvlProcess) {
        apvlProcess.setCreatorTime(DateUtils.getNowDate());
        return apvlProcessMapper.insertApvlProcess(apvlProcess);
    }

    /**
     * 修改审批流程配置
     *
     * @param apvlProcess 审批流程配置
     * @return 结果
     */
    @Override
    public int updateApvlProcess(ApvlProcess apvlProcess) {
        apvlProcess.setUpdateTime(DateUtils.getNowDate());
        return apvlProcessMapper.updateApvlProcess(apvlProcess);
    }

    /**
     * 修改审批流程配置
     *
     * @param apvlProcess 审批流程配置
     * @return 结果
     */
    @Override
    public int updateHandleApvlProcess(ApvlProcess apvlProcess) {
        apvlProcess.setUpdateTime(DateUtils.getNowDate());
        return apvlProcessMapper.updateHandleApvlProcess(apvlProcess);
    }

    /**
     * 删除审批流程配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteApvlProcessByIds(String ids) {
        return apvlProcessMapper.deleteApvlProcessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除审批流程配置信息
     *
     * @param id 审批流程配置ID
     * @return 结果
     */
    @Override
    public int deleteApvlProcessById(Long id) {
        return apvlProcessMapper.deleteApvlProcessById(id);
    }

    /**
     * 查询流程列表
     *
     * @param apvlProcess 流程
     * @return 打样流程
     */
    @Override
    public List<ApvlProcess> selectApplyApprovalProcessList(ApvlProcess apvlProcess) {
        return apvlProcessMapper.selectApvlProcessList(apvlProcess);
    }

    /**
     * 根据审批编号查询审批记录
     *
     * @param apvlNo 审批编号
     * @return 审批记录
     */
    @Override
    public List<ApvlProcess> selectApvlProcessByApvlNo(String apvlNo) {
        return apvlProcessMapper.selectApvlProcessByApvlNo(apvlNo);
    }

    /**
     * 查询最新审批记录
     *
     * @param apvlNo 审批编号
     * @return 审批记录
     */
    @Override
    public ApvlProcess selectMaxApvlProcess(String apvlNo) {
        return apvlProcessMapper.selectMaxApvlProcess(apvlNo);
    }

    /**
     * 审批编号查询记录
     *
     * @param apvlNo 审批编号
     * @return 审批人列表
     */
    @Override
    public AjaxResult getApvlProcessList(String apvlNo) {
        List<ApvlProcessVo> apvlProcessVoList = apvlProcessMapper.getApvlProcessList(apvlNo);
        if (StringUtils.isNotEmpty(apvlProcessVoList)) {
            for (ApvlProcessVo apvlProcessVo : apvlProcessVoList) {
                ApvlApprover apvlApprover = iApvlApproverService.selectApvlApproverByApproverIdAndNodeId(apvlProcessVo.getApproverId(), apvlProcessVo.getCurNodeId(), apvlProcessVo.getModuleId());
                if (!StringUtils.isNull(apvlApprover)) {
                    ApvlProcessNode apvlProcessNode = iApvlProcessNodeService.selectApvlProcessNodeById(apvlApprover.getNodeId());
                    if (!StringUtils.isNull(apvlProcessNode)) {
                        apvlProcessVo.setNodeName(apvlProcessNode.getNodeName());
                    }
                }
            }
            return AjaxResult.success().put("value", apvlProcessVoList);
        } else {
            return AjaxResult.error(ApplyStatus.STATUS_501, "无审批数据");
        }
    }

    /**
     * 获取审批单号对应的节点的审批人信息
     *
     * @param processList 已经审批记录信息
     * @return 审批人列表
     */
    public List<ApvlProcessVo> getApvlRecordList(List<ApvlProcessVo> processList) {

        // 获取已经审批的审批节点列表
        List<Long> nodeList = new ArrayList<>();
        long nodeId = processList.get(0).getCurNodeId().longValue();
        nodeList.add(nodeId);
        for (ApvlProcessVo apvlProcessVo : processList) {
            if (nodeId != apvlProcessVo.getCurNodeId().longValue()) {
                boolean bChkFlg = true;
                for (Long tmpNodeId : nodeList) {
                    if (tmpNodeId.longValue() == apvlProcessVo.getCurNodeId().longValue()) {
                        bChkFlg = false;
                        break;
                    }
                }

                if (bChkFlg) {
                    nodeList.add(apvlProcessVo.getCurNodeId().longValue());
                }
            } else if (ApvlConstants.COMMON_STS_CANCEL == apvlProcessVo.getApvlResult()) {
                // 撤销场合
                nodeList.add(apvlProcessVo.getCurNodeId().longValue());
            }
        }

        List<ApvlProcessVo> resetProcessList = new ArrayList<>();
        ApvlProcessVo apvlProcessVo = new ApvlProcessVo();
        // 获取已经审批的审批人、审批评论等信息
        for (Long curNodeId : nodeList) {
            boolean bChkFlg = true;
            boolean bApvlStsFlg = true;
            List<SysUser> sysUserList = new ArrayList<>();

            for (int i = 0; i < processList.size(); i++) {
                ApvlProcessVo tmpProcessVo = processList.get(i);
                // 申请人撤销场合
                if (ApvlConstants.COMMON_STS_CANCEL == tmpProcessVo.getApvlResult()) {
                    bApvlStsFlg = false;
                    sysUserList = new ArrayList<>();
                    SysUser addUser = new SysUser();
                    addUser.setUserId(tmpProcessVo.getApproverId());
                    addUser.setNickName(tmpProcessVo.getApprover());
                    addUser.setAvatar(tmpProcessVo.getAvatar());
                    addUser.setStatus(tmpProcessVo.getApvlResult().toString());
                    sysUserList.add(addUser);

                    apvlProcessVo = new ApvlProcessVo();
                    apvlProcessVo.setApvlNo(tmpProcessVo.getApvlNo());
                    apvlProcessVo.setModuleId(tmpProcessVo.getModuleId());
                    apvlProcessVo.setCurNodeId(tmpProcessVo.getCurNodeId());
                    apvlProcessVo.setStatus(tmpProcessVo.getStatus());
                    apvlProcessVo.setApvlMethod(tmpProcessVo.getApvlMethod());
                    apvlProcessVo.setUsers(sysUserList);
                    resetProcessList.add(apvlProcessVo);
                    break;
                }

                // 节点相同
                if (curNodeId.longValue() == tmpProcessVo.getCurNodeId().longValue()) {

                    SysUser addUser = new SysUser();
                    addUser.setUserId(tmpProcessVo.getApproverId());
                    addUser.setNickName(tmpProcessVo.getApprover());
                    addUser.setAvatar(tmpProcessVo.getAvatar());
                    addUser.setStatus(tmpProcessVo.getApvlResult().toString());
                    sysUserList.add(addUser);

                    if (bChkFlg) {
                        bChkFlg = false;
                        apvlProcessVo = new ApvlProcessVo();
                        apvlProcessVo.setApvlNo(tmpProcessVo.getApvlNo());
                        apvlProcessVo.setModuleId(tmpProcessVo.getModuleId());
                        apvlProcessVo.setCurNodeId(tmpProcessVo.getCurNodeId());
                        apvlProcessVo.setStatus(tmpProcessVo.getStatus());
                        apvlProcessVo.setApvlMethod(tmpProcessVo.getApvlMethod());
                        apvlProcessVo.setUsers(sysUserList);
                        resetProcessList.add(apvlProcessVo);
                    }

                    apvlProcessVo.setNodeStatus(ApvlConstants.COMMON_STS_FINISH);
                    apvlProcessVo.setApvlTime(tmpProcessVo.getApvlTime());
                }
            }

            // 申请人撤销,结束循环
            if (!bApvlStsFlg) {
                break;
            }
        }

        // 特殊处理(配合前端)
        apvlProcessVo = resetProcessList.get(0);
        List<SysUser> userList = apvlProcessVo.getUsers();
        if (StringUtils.isNotEmpty(userList)) {
            userList.get(0).setCreateTime(apvlProcessVo.getApvlTime());
            apvlProcessVo.setNodeStatus(ApvlConstants.COMMON_STS_APPLY);
        }

        if (ApvlConstants.COMMON_STS_CANCEL == apvlProcessVo.getStatus()
                || ApvlConstants.COMMON_STS_REJECT == apvlProcessVo.getStatus()) {
            apvlProcessVo = resetProcessList.get(resetProcessList.size() - 1);
            apvlProcessVo.setNodeStatus(apvlProcessVo.getStatus());
        }

        return resetProcessList;
    }

    /**
     * 获取未审批的节点的审批人信息
     *
     * @param processList 已经审批记录信息
     * @return 审批人列表
     */
    public List<ApvlProcessVo> getNotApvProcessList(long curNodeId, List<ApvlProcessVo> processList, List<ApvlProcessConfigurationVo> configurationVosList) {

        // 未审批的审批流程信息
        List<ApvlProcessVo> addProcessList = new ArrayList<>();

        boolean bDoWhileFlg = true;

        while (bDoWhileFlg) {
            boolean bBreakFlg = true;
            long nextNodeId = curNodeId;
            int iApvlMethod = 1;
            List<SysUser> sysUserList = new ArrayList<>();

            // 获取未审批节点列表
            for (ApvlProcessConfigurationVo configurationVo : configurationVosList) {
                // 取得当前节点的审批人员
                if (curNodeId == configurationVo.getNextNode().longValue()) {
                    // 审批人用户信息设定
                    SysUser sysUser = new SysUser();
                    sysUser.setUserId(configurationVo.getApproverId());
                    sysUser.setNickName(configurationVo.getApprover());
                    sysUser.setAvatar(configurationVo.getAvatar());
                    sysUserList.add(sysUser);
                    iApvlMethod = configurationVo.getApvlMethod();
                }

                // 找下个节点值
                if (curNodeId == configurationVo.getPreNode().longValue()) {

                    nextNodeId = configurationVo.getNextNode();
                    bBreakFlg = false;
                }
            }

            // 该节点的审批人、审批方式等信息设定
            ApvlProcessVo addApvlProcess = new ApvlProcessVo();
            addApvlProcess.setUsers(sysUserList);
            addApvlProcess.setCurNodeId(curNodeId);
            addApvlProcess.setApvlMethod(iApvlMethod);
            addProcessList.add(addApvlProcess);

            // 未找到对应的下一个节点，结束循环
            if (bBreakFlg) {
                bDoWhileFlg = false;
                break;
            }

            curNodeId = nextNodeId;
        }

        return addProcessList;
    }

    /**
     * 查询办理人记录
     *
     * @param apvlNo     审批编号
     * @param node       节点 办理人节点为 0
     * @param apvlMethod 审批方式  办理人为 3
     * @return 审批记录
     */
    @Override
    public ApvlProcess selectApvlProcessByApvlNoAndNode(String apvlNo, Long node, Integer apvlMethod) {
        return apvlProcessMapper.selectApvlProcessByApvlNoAndNode(apvlNo, node, apvlMethod);
    }
}
