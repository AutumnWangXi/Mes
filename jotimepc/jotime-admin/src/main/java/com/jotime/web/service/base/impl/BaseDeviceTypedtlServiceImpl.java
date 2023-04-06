package com.jotime.web.service.base.impl;

import java.util.ArrayList;
import java.util.List;

import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseDeviceTypedtl;
import com.jotime.web.mapper.base.BaseDeviceTypedtlMapper;
import com.jotime.web.service.base.IBaseDeviceTypedtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 设备类型详细Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-02
 */
@Service
public class BaseDeviceTypedtlServiceImpl implements IBaseDeviceTypedtlService
{
    @Autowired
    private BaseDeviceTypedtlMapper baseDeviceTypedtlMapper;

    /**
     * 查询设备类型详细
     *
     * @param id 设备类型详细主键
     * @return 设备类型详细
     */
    @Override
    public BaseDeviceTypedtl selectBaseDeviceTypedtlById(Integer id)
    {
        return baseDeviceTypedtlMapper.selectBaseDeviceTypedtlById(id);
    }

    /**
     * 查询设备类型详细列表
     *
     * @param baseDeviceTypedtl 设备类型详细
     * @return 设备类型详细
     */
    @Override
    public List<BaseDeviceTypedtl> selectBaseDeviceTypedtlList(BaseDeviceTypedtl baseDeviceTypedtl)
    {
        return baseDeviceTypedtlMapper.selectBaseDeviceTypedtlList(baseDeviceTypedtl);
    }

    /**
     * 新增设备类型详细
     *
     * @param baseDeviceTypedtl 设备类型详细
     * @return 结果
     */
    @Override
    public int insertBaseDeviceTypedtl(BaseDeviceTypedtl baseDeviceTypedtl)
    {
//        查询是否已有typeValue
        int i = baseDeviceTypedtlMapper.selectTypeValueWhetherRepetition(baseDeviceTypedtl.getDeviceType(), baseDeviceTypedtl.getTypeValue());
        if (i>0){
            return -1;
        }
        baseDeviceTypedtl.setCreateTime(DateUtils.getNowDate());
        baseDeviceTypedtl.setCreateBy(SecurityUtils.getUserId().toString());
        return baseDeviceTypedtlMapper.insertBaseDeviceTypedtl(baseDeviceTypedtl);
    }

    /**
     * 修改设备类型详细
     *
     * @param baseDeviceTypedtl 设备类型详细
     * @return 结果
     */
    @Override
    public int updateBaseDeviceTypedtl(BaseDeviceTypedtl baseDeviceTypedtl)
    {
        baseDeviceTypedtl.setUpdateTime(DateUtils.getNowDate());
        baseDeviceTypedtl.setUpdateBy(SecurityUtils.getUserId().toString());
        return baseDeviceTypedtlMapper.updateBaseDeviceTypedtl(baseDeviceTypedtl);
    }

    /**
     * 批量删除设备类型详细
     *
     * @param ids 需要删除的设备类型详细主键
     * @return 结果
     */
    @Override
    public int deleteBaseDeviceTypedtlByIds(Integer[] ids)
    {
        return baseDeviceTypedtlMapper.deleteBaseDeviceTypedtlByIds(ids);
    }

    /**
     * 删除设备类型详细信息
     *
     * @param id 设备类型详细主键
     * @return 结果
     */
    @Override
    public int deleteBaseDeviceTypedtlById(Integer id)
    {
        return baseDeviceTypedtlMapper.deleteBaseDeviceTypedtlById(id);
    }
    /**
     * 查询设备大分类对应的可用设备详细列表
     *
     * @param deviceType 设备类型
     * @return 设备大分类对应的可用设备详细列表
     */
    @Override
    public List<BaseDeviceTypedtl> selectBaseDeviceTypedtlDetailedListList(String deviceType) {
        BaseDeviceTypedtl baseDeviceTypedtl = new BaseDeviceTypedtl();
        baseDeviceTypedtl.setDeviceType(deviceType);
        baseDeviceTypedtl.setStatus(CodeRuleConstants.STATUS_OK);
        List<BaseDeviceTypedtl> baseDeviceTypedtls = new ArrayList<>();
        if (StringUtils.isNotEmpty(deviceType)){
            baseDeviceTypedtls = baseDeviceTypedtlMapper.selectBaseDeviceTypedtlList(baseDeviceTypedtl);
        }
        return baseDeviceTypedtls;
    }
}
