package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseProductionLine;

import java.util.List;

/**
 * 生产线Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface BaseProductionLineMapper 
{
    /**
     * 查询生产线
     * 
     * @param id 生产线主键
     * @return 生产线
     */
    public BaseProductionLine selectBaseProductionLineById(Long id);

    /**
     * 查询生产线列表
     * 
     * @param baseProductionLine 生产线
     * @return 生产线集合
     */
    public List<BaseProductionLine> selectBaseProductionLineList(BaseProductionLine baseProductionLine);

    /**
     * 新增生产线
     * 
     * @param baseProductionLine 生产线
     * @return 结果
     */
    public int insertBaseProductionLine(BaseProductionLine baseProductionLine);

    /**
     * 修改生产线
     * 
     * @param baseProductionLine 生产线
     * @return 结果
     */
    public int updateBaseProductionLine(BaseProductionLine baseProductionLine);

    /**
     * 删除生产线
     * 
     * @param id 生产线主键
     * @return 结果
     */
    public int deleteBaseProductionLineById(Long id);

    /**
     * 批量删除生产线
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseProductionLineByIds(Long[] ids);
}
