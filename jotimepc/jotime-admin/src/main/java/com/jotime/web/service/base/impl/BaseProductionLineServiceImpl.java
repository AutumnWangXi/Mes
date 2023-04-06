package com.jotime.web.service.base.impl;

import com.jotime.web.domain.base.BaseProductionLine;
import com.jotime.web.mapper.base.BaseProductionLineMapper;
import com.jotime.web.service.base.IBaseProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 生产线Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@Service
public class BaseProductionLineServiceImpl implements IBaseProductionLineService
{
    @Autowired
    private BaseProductionLineMapper baseProductionLineMapper;

    /**
     * 查询生产线
     * 
     * @param id 生产线主键
     * @return 生产线
     */
    @Override
    public BaseProductionLine selectBaseProductionLineById(Long id)
    {
        return baseProductionLineMapper.selectBaseProductionLineById(id);
    }

    /**
     * 查询生产线列表
     * 
     * @param baseProductionLine 生产线
     * @return 生产线
     */
    @Override
    public List<BaseProductionLine> selectBaseProductionLineList(BaseProductionLine baseProductionLine)
    {
        return baseProductionLineMapper.selectBaseProductionLineList(baseProductionLine);
    }

    /**
     * 新增生产线
     * 
     * @param baseProductionLine 生产线
     * @return 结果
     */
    @Override
    public int insertBaseProductionLine(BaseProductionLine baseProductionLine)
    {
        return baseProductionLineMapper.insertBaseProductionLine(baseProductionLine);
    }

    /**
     * 修改生产线
     * 
     * @param baseProductionLine 生产线
     * @return 结果
     */
    @Override
    public int updateBaseProductionLine(BaseProductionLine baseProductionLine)
    {
        return baseProductionLineMapper.updateBaseProductionLine(baseProductionLine);
    }

    /**
     * 批量删除生产线
     * 
     * @param ids 需要删除的生产线主键
     * @return 结果
     */
    @Override
    public int deleteBaseProductionLineByIds(Long[] ids)
    {
        return baseProductionLineMapper.deleteBaseProductionLineByIds(ids);
    }

    /**
     * 删除生产线信息
     * 
     * @param id 生产线主键
     * @return 结果
     */
    @Override
    public int deleteBaseProductionLineById(Long id)
    {
        return baseProductionLineMapper.deleteBaseProductionLineById(id);
    }
}
