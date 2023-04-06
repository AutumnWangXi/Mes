package com.jotime.web.service.base.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.base.BaseWarehouse;
import com.jotime.web.mapper.base.BaseWarehouseMapper;
import com.jotime.web.service.base.IBaseWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 仓库列Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-16
 */
@Service
public class BaseWarehouseServiceImpl extends ServiceImpl<BaseWarehouseMapper,BaseWarehouse> implements IBaseWarehouseService
{
    @Autowired
    private BaseWarehouseMapper baseWarehouseMapper;

    /**
     * 查询仓库列
     *
     * @param id 仓库列主键
     * @return 仓库列
     */
    @Override
    public BaseWarehouse selectBaseWarehouseById(Long id)
    {
        return baseWarehouseMapper.selectBaseWarehouseById(id);
    }

    /**
     * 查询仓库列列表
     *
     * @param baseWarehouse 仓库列
     * @return 仓库列
     */
    @Override
    public List<BaseWarehouse> selectBaseWarehouseList(BaseWarehouse baseWarehouse)
    {
        return baseWarehouseMapper.selectBaseWarehouseList(baseWarehouse);
    }

    /**
     * 新增仓库列
     *
     * @param baseWarehouse 仓库列
     * @return 结果
     */
    @Override
    public int insertBaseWarehouse(BaseWarehouse baseWarehouse)
    {
//        拷贝编码
        BaseWarehouse baseWarehouse1 = new BaseWarehouse();
        baseWarehouse1.setWhCode(baseWarehouse.getWhCode()==null?null:baseWarehouse.getWhCode());
//        根据编码查询是否有返回数据
        List<BaseWarehouse> baseWarehouses = baseWarehouseMapper.selectBaseWarehouseList(baseWarehouse1);
        if (baseWarehouses.size()>0){
//            插入失败，编码已存在
            return 0;
        }
        baseWarehouse.setCreateBy(SecurityUtils.getUsername());
        baseWarehouse.setCreateTime(DateUtils.getNowDate());
        return baseWarehouseMapper.insertBaseWarehouse(baseWarehouse);
    }

    /**
     * 修改仓库列
     *
     * @param baseWarehouse 仓库列
     * @return 结果
     */
    @Override
    public int updateBaseWarehouse(BaseWarehouse baseWarehouse)
    {
//        拷贝编码
        BaseWarehouse baseWarehouse1 = new BaseWarehouse();
        baseWarehouse1.setWhCode(baseWarehouse.getWhCode()==null?null:baseWarehouse.getWhCode());
//        根据编码查询是否有返回数据
        List<BaseWarehouse> baseWarehouses = baseWarehouseMapper.selectBaseWarehouseList(baseWarehouse1);
//        判断查询出的数据是不是要修改的那条数据
        if (baseWarehouses.size()>0&&!baseWarehouse.getId().equals(baseWarehouses.get(0).getId())){
//            修改失败，编码已存在
            return 0;
        }
        baseWarehouse.setUpdateBy(SecurityUtils.getUsername());
        baseWarehouse.setUpdateTime(DateUtils.getNowDate());
        return baseWarehouseMapper.updateBaseWarehouse(baseWarehouse);
    }

    /**
     * 批量删除仓库列
     *
     * @param ids 需要删除的仓库列主键
     * @return 结果
     */
    @Override
    public int deleteBaseWarehouseByIds(Long[] ids)
    {
        return baseWarehouseMapper.deleteBaseWarehouseByIds(ids);
    }

    /**
     * 删除仓库列信息
     *
     * @param id 仓库列主键
     * @return 结果
     */
    @Override
    public int deleteBaseWarehouseById(Long id)
    {
        return baseWarehouseMapper.deleteBaseWarehouseById(id);
    }

    @Override
    public BaseWarehouse selectBaseWarehouseByWhName(String whName) {
        return baseWarehouseMapper.selectBaseWarehouseByWhName(whName);
    }

    /**
     * 判断仓库是否存在
     * @return 结果
     */
    @Override
    public Long selectBaseWarehouseBywhCode(String whCode) {
        return baseWarehouseMapper.selectBaseWarehouseBywhCode(whCode);
    }


}
