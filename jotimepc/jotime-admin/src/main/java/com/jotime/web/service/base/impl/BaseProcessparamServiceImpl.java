package com.jotime.web.service.base.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseProcessparam;
import com.jotime.web.mapper.base.BaseProcessparamMapper;
import com.jotime.web.service.base.IBaseProcessparamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 设备工艺参数Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-18
 */
@Service
public class BaseProcessparamServiceImpl implements IBaseProcessparamService
{
    @Autowired
    private BaseProcessparamMapper baseProcessparamMapper;

    /**
     * 查询设备工艺参数
     *
     * @param id 设备工艺参数主键
     * @return 设备工艺参数
     */
    @Override
    public BaseProcessparam selectBaseProcessparamById(Integer id)
    {
        return baseProcessparamMapper.selectBaseProcessparamById(id);
    }

    /**
     * 查询设备工艺参数列表
     *
     * @param baseProcessparam 设备工艺参数
     * @return 设备工艺参数
     */
    @Override
    public List<BaseProcessparam> selectBaseProcessparamList(BaseProcessparam baseProcessparam)
    {
        return baseProcessparamMapper.selectBaseProcessparamList(baseProcessparam);
    }

    /**
     * 新增设备工艺参数
     *
     * @param baseProcessparam 设备工艺参数
     * @return 结果
     */
    @Override
    public int insertBaseProcessparam(BaseProcessparam baseProcessparam)
    {
        baseProcessparam.setCreateTime(DateUtils.getNowDate());
//        判断值是否重复
        BaseProcessparam baseProcessparam1 = new BaseProcessparam();
        baseProcessparam1.setParamValue(baseProcessparam.getParamValue());
        List<BaseProcessparam> baseProcessparams = baseProcessparamMapper.selectBaseProcessparamList(baseProcessparam1);
//        重复，不执行写操作，直接返回-1
        if (baseProcessparams.size()>0){
            return -1;
        }
        return baseProcessparamMapper.insertBaseProcessparam(baseProcessparam);
    }

    /**
     * 修改设备工艺参数
     *
     * @param baseProcessparam 设备工艺参数
     * @return 结果
     */
    @Override
    public int updateBaseProcessparam(BaseProcessparam baseProcessparam)
    {
        baseProcessparam.setUpdateTime(DateUtils.getNowDate());
        BaseProcessparam baseProcessparam1 = new BaseProcessparam();
        baseProcessparam1.setParamValue(baseProcessparam.getParamValue());
        List<BaseProcessparam> baseProcessparams = baseProcessparamMapper.selectBaseProcessparamList(baseProcessparam1);
//        查询数据库中是否有值重复的情况
        if (baseProcessparams.size()>0){
//            判断那一条是否是本条要更新的数据，不是则表明重复，不是则更新数据
            if (baseProcessparams.get(0).getId()!=baseProcessparam.getId()){
                return -1;
            }
        }
        return baseProcessparamMapper.updateBaseProcessparam(baseProcessparam);
    }

    /**
     * 批量删除设备工艺参数
     *
     * @param ids 需要删除的设备工艺参数主键
     * @return 结果
     */
    @Override
    public int deleteBaseProcessparamByIds(Integer[] ids)
    {
        return baseProcessparamMapper.deleteBaseProcessparamByIds(ids);
    }

    /**
     * 删除设备工艺参数信息
     *
     * @param id 设备工艺参数主键
     * @return 结果
     */
    @Override
    public int deleteBaseProcessparamById(Integer id)
    {
        return baseProcessparamMapper.deleteBaseProcessparamById(id);
    }
}
