package com.jotime.web.mapper.base;

import java.util.List;
import com.jotime.web.domain.base.BaseUnitMap;

/**
 * 单位转换Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-31
 */
public interface BaseUnitMapMapper 
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
     * 查询单位转换列表
     *
     * @param baseUnitMap 单位转换
     * @return 单位转换集合
     */
    public List<BaseUnitMap> selectBaseUnitMapChkList(BaseUnitMap baseUnitMap);

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
     * 删除单位转换
     * 
     * @param id 单位转换主键
     * @return 结果
     */
    public int deleteBaseUnitMapById(Long id);

    /**
     * 批量删除单位转换
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseUnitMapByIds(Long[] ids);
}
