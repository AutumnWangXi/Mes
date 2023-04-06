package com.jotime.web.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.web.domain.base.BaseWarehouse;

import java.util.List;

/**
 * 仓库列Service接口
 * 
 * @author ruoyi
 * @date 2022-01-16
 */
public interface IBaseWarehouseService extends IService<BaseWarehouse>
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
     * 批量删除仓库列
     * 
     * @param ids 需要删除的仓库列主键集合
     * @return 结果
     */
    public int deleteBaseWarehouseByIds(Long[] ids);

    /**
     * 删除仓库列信息
     * 
     * @param id 仓库列主键
     * @return 结果
     */
    public int deleteBaseWarehouseById(Long id);

    public BaseWarehouse selectBaseWarehouseByWhName(String whName);


    /**
     * 判断仓库是否存在
     * @return 结果
     */
    Long selectBaseWarehouseBywhCode(String whCode);
}
