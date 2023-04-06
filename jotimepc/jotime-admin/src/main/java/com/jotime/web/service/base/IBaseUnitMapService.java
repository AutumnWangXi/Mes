package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseUnitMap;

import java.util.List;

/**
 * 单位转换Service接口
 * 
 * @author ruoyi
 * @date 2021-12-31
 */
public interface IBaseUnitMapService 
{
    /**
     * 查询单位转换
     * 
     * @param id 单位转换主键
     * @return 单位转换
     */
    public BaseUnitMap selectBaseUnitMapById(Long id);

    /**
     * 查询单位转换列表
     * 
     * @param baseUnitMap 单位转换
     * @return 单位转换集合
     */
    public List<BaseUnitMap> selectBaseUnitMapList(BaseUnitMap baseUnitMap);

    /**
     * 新增单位转换
     * 
     * @param baseUnitMap 单位转换
     * @return 结果
     */
    public int insertBaseUnitMap(BaseUnitMap baseUnitMap);

    /**
     * 修改单位转换
     * 
     * @param baseUnitMap 单位转换
     * @return 结果
     */
    public int updateBaseUnitMap(BaseUnitMap baseUnitMap);

    /**
     * 批量删除单位转换
     * 
     * @param ids 需要删除的单位转换主键集合
     * @return 结果
     */
    public int deleteBaseUnitMapByIds(Long[] ids);

    /**
     * 删除单位转换信息
     * 
     * @param id 单位转换主键
     * @return 结果
     */
    public int deleteBaseUnitMapById(Long id);

    List<BaseUnitMap> selectBaseUnitMapdistinctlist(BaseUnitMap baseUnitMap);
}
