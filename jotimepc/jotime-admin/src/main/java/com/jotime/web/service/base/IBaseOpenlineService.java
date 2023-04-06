package com.jotime.web.service.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseOpenline;
import com.jotime.web.domainVo.base.BaseOpenlineVo;

import java.util.List;

/**
 * 开线检查Service接口
 *
 * @author YunFei
 * @date 2022-03-04
 */
public interface IBaseOpenlineService
{
    /**
     * 查询开线检查
     *
     * @param id 开线检查主键
     * @return 开线检查
     */
    public BaseOpenline selectBaseOpenlineById(Long id);

    /**
     * 查询开线检查列表
     *
     * @param baseOpenline 开线检查
     * @return 开线检查集合
     */
    public List<BaseOpenline> selectBaseOpenlineList(BaseOpenline baseOpenline);
    /**
     * 查询开线检查列表
     *
     * @param baseOpenline 开线检查
     * @return 开线检查集合
     */
    public List<BaseOpenlineVo> selectBaseOpenlineVoList(BaseOpenline baseOpenline);

    /**
     * 新增开线检查
     *
     * @param baseOpenline 开线检查
     * @return 结果
     */
    public int insertBaseOpenline(BaseOpenline baseOpenline);

    /**
     * 修改开线检查
     *
     * @param baseOpenline 开线检查
     * @return 结果
     */
    public int updateBaseOpenline(BaseOpenline baseOpenline);

    /**
     * 批量删除开线检查
     *
     * @param ids 需要删除的开线检查主键集合
     * @return 结果
     */
    public int deleteBaseOpenlineByIds(Long[] ids);

    /**
     * 删除开线检查信息
     *
     * @param id 开线检查主键
     * @return 结果
     */
    public int deleteBaseOpenlineById(Long id);
    /**
     * 新增开线检查
     *
     * @param baseOpenlineVo 开线检查
     * @return 结果
     */
    public AjaxResult addOpenline(BaseOpenlineVo baseOpenlineVo) ;
    /**
     * 获取开线检查
     *
     * @return 结果
     */
    public AjaxResult getOpenline(Long id);
    public AjaxResult UpdateOpenline(BaseOpenlineVo baseOpenlineVo);
    public AjaxResult deleteBaseOpenlineAndDtlByIds(Long[] ids);
}
