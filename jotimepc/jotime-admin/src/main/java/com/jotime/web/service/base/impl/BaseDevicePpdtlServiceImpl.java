package com.jotime.web.service.base.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseDevicePpdtl;
import com.jotime.web.domainVo.base.BaseDevicePpdtlVo;
import com.jotime.web.mapper.base.BaseDevicePpdtlMapper;
import com.jotime.web.service.base.IBaseDevicePpdtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 设备工艺参数Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Service
public class BaseDevicePpdtlServiceImpl implements IBaseDevicePpdtlService
{
    @Autowired
    private BaseDevicePpdtlMapper baseDevicePpdtlMapper;

    /**
     * 查询设备工艺参数
     *
     * @param id 设备工艺参数主键
     * @return 设备工艺参数
     */
    @Override
    public BaseDevicePpdtl selectBaseDevicePpdtlById(Long id)
    {
        return baseDevicePpdtlMapper.selectBaseDevicePpdtlById(id);
    }

    /**
     * 查询设备工艺参数列表
     *
     * @param baseDevicePpdtl 设备工艺参数
     * @return 设备工艺参数
     */
    @Override
    public List<BaseDevicePpdtl> selectBaseDevicePpdtlList(BaseDevicePpdtl baseDevicePpdtl)
    {
        return baseDevicePpdtlMapper.selectBaseDevicePpdtlList(baseDevicePpdtl);
    }
    /**
     * 查询设备工艺参数列表
     *
     * @param baseDevicePpdtl 设备工艺参数
     * @return 设备工艺参数集合
     */
    public List<BaseDevicePpdtlVo> selectBaseDevicePpdtlVoList(BaseDevicePpdtl baseDevicePpdtl){
        return baseDevicePpdtlMapper.selectBaseDevicePpdtlVoList(baseDevicePpdtl);
    }

    /**
     * 新增设备工艺参数
     *
     * @param baseDevicePpdtl 设备工艺参数
     * @return 结果
     */
    @Override
    public int insertBaseDevicePpdtl(BaseDevicePpdtl baseDevicePpdtl)
    {
        baseDevicePpdtl.setCreateTime(DateUtils.getNowDate());
        return baseDevicePpdtlMapper.insertBaseDevicePpdtl(baseDevicePpdtl);
    }

    /**
     * 修改设备工艺参数
     *
     * @param baseDevicePpdtl 设备工艺参数
     * @return 结果
     */
    @Override
    public int updateBaseDevicePpdtl(BaseDevicePpdtl baseDevicePpdtl)
    {
        baseDevicePpdtl.setUpdateTime(DateUtils.getNowDate());
        return baseDevicePpdtlMapper.updateBaseDevicePpdtl(baseDevicePpdtl);
    }

    /**
     * 批量删除设备工艺参数
     *
     * @param ids 需要删除的设备工艺参数主键
     * @return 结果
     */
    @Override
    public int deleteBaseDevicePpdtlByIds(Long[] ids)
    {
        return baseDevicePpdtlMapper.deleteBaseDevicePpdtlByIds(ids);
    }

    /**
     * 删除设备工艺参数信息
     *
     * @param id 设备工艺参数主键
     * @return 结果
     */
    @Override
    public int deleteBaseDevicePpdtlById(Long id)
    {
        return baseDevicePpdtlMapper.deleteBaseDevicePpdtlById(id);
    }
}
