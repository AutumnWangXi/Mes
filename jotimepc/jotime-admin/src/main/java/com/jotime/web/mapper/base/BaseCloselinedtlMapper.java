package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseCloselinedtl;

import java.util.List;

/**
 * 清线检查内容Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-04
 */
public interface BaseCloselinedtlMapper 
{
    /**
     * 查询清线检查内容
     * 
     * @param id 清线检查内容主键
     * @return 清线检查内容
     */
    public BaseCloselinedtl selectBaseCloselinedtlById(Long id);

    /**
     * 查询清线检查内容列表
     * 
     * @param baseCloselinedtl 清线检查内容
     * @return 清线检查内容集合
     */
    public List<BaseCloselinedtl> selectBaseCloselinedtlList(BaseCloselinedtl baseCloselinedtl);

    /**
     * 新增清线检查内容
     * 
     * @param baseCloselinedtl 清线检查内容
     * @return 结果
     */
    public int insertBaseCloselinedtl(BaseCloselinedtl baseCloselinedtl);

    /**
     * 修改清线检查内容
     * 
     * @param baseCloselinedtl 清线检查内容
     * @return 结果
     */
    public int updateBaseCloselinedtl(BaseCloselinedtl baseCloselinedtl);

    /**
     * 删除清线检查内容
     * 
     * @param id 清线检查内容主键
     * @return 结果
     */
    public int deleteBaseCloselinedtlById(Long id);

    /**
     * 批量删除清线检查内容
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCloselinedtlByIds(Long[] ids);

    /**
     * 批量删除清线检查内容
     *
     * @param closelineId 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCloselinedtlByLineId(Long closelineId);
}
