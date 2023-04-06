package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseWarehouse;

import java.util.List;

/**
 * 仓库列Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-16
 */
public interface BaseWarehouseMapper extends BaseMapper<BaseWarehouse>
{
    /**
     * 查询仓库列
     * 
     * @param id 仓库列主键
     * @return 仓库列
     */
    public BaseWarehouse selectBaseWarehouseById(Long id);

    /**
     * 查询仓库列列表
     * 
     * @param baseWarehouse 仓库列
     * @return 仓库列集合
     */
    public List<BaseWarehouse> selectBaseWarehouseList(BaseWarehouse baseWarehouse);

    /**
     * 新增仓库列
     * 
     * @param baseWarehouse 仓库列
     * @return 结果
     */
    public int insertBaseWarehouse(BaseWarehouse baseWarehouse);

    /**
     * 修改仓库列
     * 
     * @param baseWarehouse 仓库列
     * @return 结果
     */
    public int updateBaseWarehouse(BaseWarehouse baseWarehouse);

    /**
     * 删除仓库列
     * 
     * @param id 仓库列主键
     * @return 结果
     */
    public int deleteBaseWarehouseById(Long id);

    /**
     * 批量删除仓库列
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseWarehouseByIds(Long[] ids);

    BaseWarehouse selectBaseWarehouseByWhName(String whName);
    /**
     * 判断仓库是否存在
     * @return 结果
     */
    Long selectBaseWarehouseBywhCode(String whCode);
}
