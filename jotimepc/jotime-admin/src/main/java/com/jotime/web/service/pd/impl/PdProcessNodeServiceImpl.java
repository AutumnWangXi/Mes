package com.jotime.web.service.pd.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.pd.PdProcessNode;
import com.jotime.web.domainVo.pd.PdProcessNodeVo;
import com.jotime.web.mapper.pd.PdProcessNodeMapper;
import com.jotime.web.service.pd.IPdProcessNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：生产流程节点Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-05-06
 */
@Service
public class PdProcessNodeServiceImpl implements IPdProcessNodeService {
    @Autowired
    private PdProcessNodeMapper pdProcessNodeMapper;

    /**
     * 查询描述：生产流程节点
     *
     * @param id 描述：生产流程节点主键
     * @return 描述：生产流程节点
     */
    @Override
    public PdProcessNode selectPdProcessNodeById(Long id) {
        return pdProcessNodeMapper.selectPdProcessNodeById(id);
    }

    /**
     * 查询描述：生产流程节点列表
     *
     * @param pdProcessNode 描述：生产流程节点
     * @return 描述：生产流程节点
     */
    @Override
    public List<PdProcessNode> selectPdProcessNodeList(PdProcessNode pdProcessNode) {
        return pdProcessNodeMapper.selectPdProcessNodeList(pdProcessNode);
    }


    /**
     * 查询描述：生产流程节点列表
     *
     * @param pdProcessNodeVo 描述：生产流程节点
     * @return 描述：生产流程节点集合
     */
    @Override
    public List<PdProcessNodeVo> selectPdProcessNodeVoList(PdProcessNodeVo pdProcessNodeVo) {
        return pdProcessNodeMapper.selectPdProcessNodeVoList(pdProcessNodeVo);
    }

    /**
     * 新增描述：生产流程节点
     *
     * @param pdProcessNode 描述：生产流程节点
     * @return 结果
     */
    @Override
    public int insertPdProcessNode(PdProcessNode pdProcessNode) {
        pdProcessNode.setCreateTime(DateUtils.getNowDate());
        pdProcessNode.setCreateBy(String.valueOf(SecurityUtils.getUserId()));
        return pdProcessNodeMapper.insertPdProcessNode(pdProcessNode);
    }

    /**
     * 修改描述：生产流程节点
     *
     * @param pdProcessNode 描述：生产流程节点
     * @return 结果
     */
    @Override
    public int updatePdProcessNode(PdProcessNode pdProcessNode) {
        pdProcessNode.setUpdateTime(DateUtils.getNowDate());
        return pdProcessNodeMapper.updatePdProcessNode(pdProcessNode);
    }

    /**
     * 批量删除描述：生产流程节点
     *
     * @param ids 需要删除的描述：生产流程节点主键
     * @return 结果
     */
    @Override
    public int deletePdProcessNodeByIds(Long[] ids) {
        return pdProcessNodeMapper.deletePdProcessNodeByIds(ids);
    }

    /**
     * 删除描述：生产流程节点信息
     *
     * @param id 描述：生产流程节点主键
     * @return 结果
     */
    @Override
    public int deletePdProcessNodeById(Long id) {
        return pdProcessNodeMapper.deletePdProcessNodeById(id);
    }

    /**
     * 根据生产流程查询起始节点信息
     *
     * @param moduleId 描述：生产流程
     * @return 描述：生产流程节点集合
     */
    @Override
    public PdProcessNodeVo selectPdProcessStartNodeList(Long moduleId) {
        return pdProcessNodeMapper.selectPdProcessStartNodeList(moduleId);
    }
}
