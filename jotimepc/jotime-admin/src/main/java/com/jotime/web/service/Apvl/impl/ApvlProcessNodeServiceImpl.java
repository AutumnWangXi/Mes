package com.jotime.web.service.Apvl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.Apvl.ApvlModule;
import com.jotime.web.domain.Apvl.ApvlProcessNode;
import com.jotime.web.domainVo.apvl.ApvlProcessNodeVo;
import com.jotime.web.mapper.Apvl.ApvlProcessNodeMapper;
import com.jotime.web.service.Apvl.IApvlModuleService;
import com.jotime.web.service.Apvl.IApvlProcessNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 审批流程节点Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@Service
public class ApvlProcessNodeServiceImpl extends ServiceImpl<ApvlProcessNodeMapper,ApvlProcessNode> implements IApvlProcessNodeService
{
    @Autowired
    private ApvlProcessNodeMapper apvlProcessNodeMapper;

    @Autowired
    private IApvlModuleService iApvlModuleService;

    /**
     * 查询审批流程节点
     *
     * @param id 审批流程节点主键
     * @return 审批流程节点
     */
    @Override
    public ApvlProcessNode selectApvlProcessNodeById(Long id)
    {
        return apvlProcessNodeMapper.selectApvlProcessNodeById(id);
    }

    /**
     * 查询审批流程节点列表
     *
     * @param apvlProcessNode 审批流程节点
     * @return 审批流程节点
     */
    @Override
    public List<ApvlProcessNode> selectApvlProcessNodeList(ApvlProcessNode apvlProcessNode)
    {
//        ApvlModule apvlModule = iApvlModuleService.selectApvlModuleById(apvlProcessNode.getModuleId());
        List<ApvlProcessNode> apvlProcessNodes = apvlProcessNodeMapper.selectApvlProcessNodeList(apvlProcessNode);
        for (ApvlProcessNode processNode : apvlProcessNodes) {
            ApvlModule apvlModule = iApvlModuleService.selectApvlModuleById(processNode.getModuleId());
            processNode.setModuleName(apvlModule==null?"":apvlModule.getModuleName());
        }
        return apvlProcessNodes;
    }
    /**
     * 获取流程对应节点列表
     * @param isProposer 是否申请人，1，不是，2，是
     */
    public List<ApvlProcessNode> getNodeList( Long moduleId,Integer isProposer){
        ApvlProcessNode apvlProcessNode = new ApvlProcessNode();
        apvlProcessNode.setModuleId(moduleId);
        if (isProposer==1){
            apvlProcessNode.setIsProposer(1L);
        }
        apvlProcessNode.setStatus(2);
        List<ApvlProcessNode> apvlProcessNodes = apvlProcessNodeMapper.selectApvlProcessNodeList(apvlProcessNode);
        return apvlProcessNodes;
    }
    /**
     * 查询审批流程节点列表Vo
     *
     * @param apvlProcessNode 审批流程节点
     * @return 审批流程节点
     */
    @Override
    public List<ApvlProcessNodeVo> selectApvlProcessNodeVoList(ApvlProcessNode apvlProcessNode) {

        return apvlProcessNodeMapper.selectApvlProcessNodeVoList(apvlProcessNode);
    }

    /**
     * 新增审批流程节点
     *
     * @param apvlProcessNode 审批流程节点
     * @return 结果
     */
    @Override
    public int insertApvlProcessNode(ApvlProcessNode apvlProcessNode)
    {
        apvlProcessNode.setCreateBy(SecurityUtils.getUsername());
        return apvlProcessNodeMapper.insertApvlProcessNode(apvlProcessNode);
    }

    /**
     * 修改审批流程节点
     *
     * @param apvlProcessNode 审批流程节点
     * @return 结果
     */
    @Override
    public int updateApvlProcessNode(ApvlProcessNode apvlProcessNode)
    {
        apvlProcessNode.setUpdateBy(SecurityUtils.getUsername());
        return apvlProcessNodeMapper.updateApvlProcessNode(apvlProcessNode);
    }

    /**
     * 批量删除审批流程节点
     *
     * @param ids 需要删除的审批流程节点主键
     * @return 结果
     */
    @Override
    public int deleteApvlProcessNodeByIds(Long[] ids)
    {
        return apvlProcessNodeMapper.deleteApvlProcessNodeByIds(ids);
    }

    /**
     * 删除审批流程节点信息
     *
     * @param id 审批流程节点主键
     * @return 结果
     */
    @Override
    public int deleteApvlProcessNodeById(Long id)
    {
        return apvlProcessNodeMapper.deleteApvlProcessNodeById(id);
    }

    /**
     *根据流程内码查询流程信息
     * @param moduleId 流程内码
     * @param isProposer 是否是审批人
     * @return 流程对象
     */
    @Override
    public ApvlProcessNode getNodeListByModuleIdAndIsProposer(Long moduleId,Long isProposer) {
        return apvlProcessNodeMapper.getNodeListByModuleIdAndIsProposer(moduleId,isProposer);
    }


}
