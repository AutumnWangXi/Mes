package com.jotime.web.service.base;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseCloseline;
import com.jotime.web.domainVo.base.BaseCloselineVo;

import java.util.List;

/**
 * 清线检查Service接口
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public interface IBaseCloselineService
{
    /**
     * 查询清线检查
     *
     * @param id 清线检查主键
     * @return 清线检查
     */
    public BaseCloseline selectBaseCloselineById(Long id);

    /**
     * 查询清线检查列表
     *
     * @param baseCloseline 清线检查
     * @return 清线检查集合
     */
    public List<BaseCloseline> selectBaseCloselineList(BaseCloseline baseCloseline);

    /**
     * 新增清线检查
     *
     * @param baseCloseline 清线检查
     * @return 结果
     */
    public int insertBaseCloseline(BaseCloseline baseCloseline);
    /**
     * 新增清线检查和对应dtl
     *
     * @param baseCloselineVo 清线检查
     * @return 结果
     */
    public AjaxResult insertBaseCloselineAndDtl(BaseCloselineVo baseCloselineVo);

    /**
     * 修改清线检查
     *
     * @param baseCloseline 清线检查
     * @return 结果
     */
    public int updateBaseCloseline(BaseCloseline baseCloseline);
    /**
     * 修改清线检查
     *
     * @param baseCloseline 清线检查
     * @return 结果
     */
    public AjaxResult updateBaseCloselineAndDtl(BaseCloselineVo baseCloselineVo);

    /**
     * 批量删除清线检查
     *
     * @param ids 需要删除的清线检查主键集合
     * @return 结果
     */
    public int deleteBaseCloselineByIds(Long[] ids);
    /**
     * 批量删除清线检查
     *
     * @param ids 需要删除的清线检查主键集合
     * @return 结果
     */
    public int deleteBaseCloselineAndDtlByIds(Long[] ids);

    /**
     * 删除清线检查信息
     *
     * @param id 清线检查主键
     * @return 结果
     */
    public int deleteBaseCloselineById(Long id);

    /**
     * 新增清线检查
     *
     * @param baseCloseline 清线检查
     * @return 结果
     */
    public AjaxResult addAnddtl(BaseCloselineVo baseCloselineVo);
    /**
     * 查询清线检查列表
     *
     * @param baseCloseline 清线检查
     * @return 清线检查集合
     */
    public List<BaseCloselineVo> selectBaseCloselineVoList(BaseCloseline baseCloseline);

    /**
     * 查询清线检查
     *
     * @param id 清线检查主键
     * @return 清线检查
     */
    public AjaxResult getCloselineAndDtl(Long id);

}
