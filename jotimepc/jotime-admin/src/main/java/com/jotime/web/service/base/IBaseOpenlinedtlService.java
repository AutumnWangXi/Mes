package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseOpenlinedtl;
import com.jotime.web.domainVo.base.BaseOpenlinedtlVo;

import java.util.List;


/**
 * 开线检查内容Service接口
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public interface IBaseOpenlinedtlService
{
    /**
     * 查询开线检查内容
     *
     * @param id 开线检查内容主键
     * @return 开线检查内容
     */
    public BaseOpenlinedtl selectBaseOpenlinedtlById(Long id);

    /**
     * 查询开线检查内容列表
     *
     * @param baseOpenlinedtl 开线检查内容
     * @return 开线检查内容集合
     */
    public List<BaseOpenlinedtl> selectBaseOpenlinedtlList(BaseOpenlinedtl baseOpenlinedtl);
    /**
     * 查询开线检查内容列表
     *
     * @param baseOpenlinedtl 开线检查内容
     * @return 开线检查内容集合
     */
    public List<BaseOpenlinedtlVo> selectBaseOpenlinedtlVoList(BaseOpenlinedtl baseOpenlinedtl);

    /**
     * 新增开线检查内容
     *
     * @param baseOpenlinedtl 开线检查内容
     * @return 结果
     */
    public int insertBaseOpenlinedtl(BaseOpenlinedtl baseOpenlinedtl);

    /**
     * 修改开线检查内容
     *
     * @param baseOpenlinedtl 开线检查内容
     * @return 结果
     */
    public int updateBaseOpenlinedtl(BaseOpenlinedtl baseOpenlinedtl);

    /**
     * 批量删除开线检查内容
     *
     * @param ids 需要删除的开线检查内容主键集合
     * @return 结果
     */
    public int deleteBaseOpenlinedtlByIds(Long[] ids);

    /**
     * 删除开线检查内容信息
     *
     * @param id 开线检查内容主键
     * @return 结果
     */
    public int deleteBaseOpenlinedtlById(Long id);
}
