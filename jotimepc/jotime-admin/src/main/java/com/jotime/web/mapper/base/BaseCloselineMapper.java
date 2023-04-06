package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseCloseline;
import com.jotime.web.domain.base.BaseOpenline;
import com.jotime.web.domainVo.base.BaseCloselineVo;

import java.util.List;

/**
 * 清线检查Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public interface BaseCloselineMapper extends BaseMapper<BaseCloseline>
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
     * 修改清线检查
     *
     * @param baseCloseline 清线检查
     * @return 结果
     */
    public int updateBaseCloseline(BaseCloseline baseCloseline);

    /**
     * 删除清线检查
     *
     * @param id 清线检查主键
     * @return 结果
     */
    public int deleteBaseCloselineById(Long id);

    /**
     * 批量删除清线检查
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCloselineByIds(Long[] ids);

    /**
     * 查询清线检查列表
     *
     * @param baseCloseline 清线检查
     * @return 清线检查集合
     */
    public List<BaseCloselineVo> selectBaseCloselineVoList(BaseCloseline baseCloseline);

}
