package com.jotime.web.mapper.pd;

import com.jotime.web.domain.pd.PdProcessNode;
import com.jotime.web.domainVo.pd.PdProcessNodeVo;

import java.util.List;

/**
 * 描述：生产流程节点Mapper接口
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
public interface PdProcessNodeMapper 
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
     * 删除描述：生产流程节点
     * 
     * @param id 描述：生产流程节点主键
     * @return 结果
     */
    public int deletePdProcessNodeById(Long id);

    /**
     * 批量删除描述：生产流程节点
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePdProcessNodeByIds(Long[] ids);


    /**
     * 查询描述：生产流程节点列表
     *
     * @param pdProcessNodeVo 描述：生产流程节点
     * @return 描述：生产流程节点集合
     */
    public List<PdProcessNodeVo> selectPdProcessNodeVoList(PdProcessNodeVo pdProcessNodeVo);

    /**
     * 根据生产流程查询起始节点信息
     *
     * @param moduleId 描述：生产流程
     * @return 描述：生产流程节点集合
     */
    public PdProcessNodeVo selectPdProcessStartNodeList(Long moduleId);

    /**
     * 节点详细信息
     */
    public List<PdProcessNodeVo> moduleInfo(Long moduleId);

}
