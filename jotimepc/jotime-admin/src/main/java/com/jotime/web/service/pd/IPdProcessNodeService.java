package com.jotime.web.service.pd;

import com.jotime.web.domain.pd.PdProcessNode;
import com.jotime.web.domainVo.pd.PdProcessNodeVo;

import java.util.List;

/**
 * 描述：生产流程节点Service接口
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
public interface IPdProcessNodeService 
{
    /**
     * 查询描述：生产流程节点
     * 
     * @param id 描述：生产流程节点主键
     * @return 描述：生产流程节点
     */
    public PdProcessNode selectPdProcessNodeById(Long id);

    /**
     * 查询描述：生产流程节点列表
     * 
     * @param pdProcessNode 描述：生产流程节点
     * @return 描述：生产流程节点集合
     */
    public List<PdProcessNode> selectPdProcessNodeList(PdProcessNode pdProcessNode);


    /**
     * 查询描述：生产流程节点列表
     *
     * @param pdProcessNodeVo 描述：生产流程节点
     * @return 描述：生产流程节点集合
     */
    public List<PdProcessNodeVo> selectPdProcessNodeVoList(PdProcessNodeVo pdProcessNodeVo);

    /**
     * 新增描述：生产流程节点
     * 
     * @param pdProcessNode 描述：生产流程节点
     * @return 结果
     */
    public int insertPdProcessNode(PdProcessNode pdProcessNode);

    /**
     * 修改描述：生产流程节点
     * 
     * @param pdProcessNode 描述：生产流程节点
     * @return 结果
     */
    public int updatePdProcessNode(PdProcessNode pdProcessNode);

    /**
     * 批量删除描述：生产流程节点
     * 
     * @param ids 需要删除的描述：生产流程节点主键集合
     * @return 结果
     */
    public int deletePdProcessNodeByIds(Long[] ids);

    /**
     * 删除描述：生产流程节点信息
     * 
     * @param id 描述：生产流程节点主键
     * @return 结果
     */
    public int deletePdProcessNodeById(Long id);

    /**
     * 根据生产流程查询起始节点信息
     *
     * @param moduleId 描述：生产流程
     * @return 描述：生产流程节点集合
     */
    public PdProcessNodeVo selectPdProcessStartNodeList(Long moduleId);
}
