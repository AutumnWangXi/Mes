package com.jotime.web.mapper.Apvl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.Apvl.ApvlProcess;
import com.jotime.web.domainVo.apvl.ApvlProcessVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 审批流程配置Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-13
 */
public interface ApvlProcessMapper extends BaseMapper<ApvlProcess> {
    /**
     * 查询审批流程配置
     *
     * @param id 审批流程配置ID
     * @return 审批流程配置
     */
    public ApvlProcess selectApvlProcessById(Long id);

    /**
     * 查询审批流程配置列表
     *
     * @param apvlProcess 审批流程配置
     * @return 审批流程配置集合
     */
    public List<ApvlProcess> selectApvlProcessList(ApvlProcess apvlProcess);

    public List<ApvlProcessVo> selectApvlProcessVoList(ApvlProcess apvlProcess);

    /**
     * 新增审批流程配置
     *
     * @param apvlProcess 审批流程配置
     * @return 结果
     */
    public int insertApvlProcess(ApvlProcess apvlProcess);

    /**
     * 修改审批流程配置
     *
     * @param apvlProcess 审批流程配置
     * @return 结果
     */
    public int updateApvlProcess(ApvlProcess apvlProcess);
    /**
     * 修改审批流程配置
     *
     * @param apvlProcess 审批流程配置
     * @return 结果
     */
    public int updateHandleApvlProcess(ApvlProcess apvlProcess);

    /**
     * 删除审批流程配置
     *
     * @param id 审批流程配置ID
     * @return 结果
     */
    public int deleteApvlProcessById(Long id);

    /**
     * 批量删除审批流程配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteApvlProcessByIds(String[] ids);

    /**
     * 根据审批编号查询审批记录
     *
     * @param apvlNo 审批编号
     * @return 审批记录
     */
    public List<ApvlProcess> selectApvlProcessByApvlNo(String apvlNo);

    /**
     * 查询最新审批
     *
     * @param apvlNo 审批编号
     * @return 审批记录
     */
    public ApvlProcess selectMaxApvlProcess(String apvlNo);

    /**
     * 根据审批编号查询记录
     *
     * @param apvlNo 审批编号
     * @return 审批人列表
     */
    public List<ApvlProcessVo> getApvlProcessList(String apvlNo);

    /**
     * 根据审批编号查询审批记录
     *
     * @param apvlNo 审批编号
     * @return 审批记录
     */
    public List<ApvlProcessVo> selectApvlProcessListByApvlNo(String apvlNo);

    /**
     * 查询办理人记录
     *
     * @param apvlNo     审批编号
     * @param node       节点 办理人节点为 0
     * @param apvlMethod 审批方式  办理人为 3
     * @return 审批记录
     */
    public ApvlProcess selectApvlProcessByApvlNoAndNode(@Param("apvlNo") String apvlNo, @Param("node") Long node, @Param("apvlMethod") Integer apvlMethod);
}
