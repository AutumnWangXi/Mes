package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseItemNetcontent;
import com.jotime.web.mapper.base.BaseItemNetcontentMapper;
import com.jotime.web.service.base.IBaseItemNetcontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：成品净含量Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-05-07
 */
@Service
public class BaseItemNetcontentServiceImpl implements IBaseItemNetcontentService {
    @Autowired
    private BaseItemNetcontentMapper baseItemNetcontentMapper;

    /**
     * 查询描述：成品净含量
     *
     * @param id 描述：成品净含量主键
     * @return 描述：成品净含量
     */
    @Override
    public BaseItemNetcontent selectBaseItemNetcontentById(Long id) {
        return baseItemNetcontentMapper.selectBaseItemNetcontentById(id);
    }

    /**
     * 查询描述：成品净含量列表
     *
     * @param baseItemNetcontent 描述：成品净含量
     * @return 描述：成品净含量
     */
    @Override
    public List<BaseItemNetcontent> selectBaseItemNetcontentList(BaseItemNetcontent baseItemNetcontent) {
        return baseItemNetcontentMapper.selectBaseItemNetcontentList(baseItemNetcontent);
    }

    /**
     * 根据物料编号查询计算依据
     *
     * @param itemId      物料ID
     * @param innerItemId 套装内物料编号
     * @return 描述：成品净含量集合
     */
    @Override
    public BaseItemNetcontent selectBaseItemNetcontentData(Long itemId, Long innerItemId,String bomNo,String version) {
        if (StringUtils.isNotNull(itemId)) {
            return baseItemNetcontentMapper.selectBaseItemNetcontentData(itemId, innerItemId,bomNo,version);
        } else {
            return baseItemNetcontentMapper.selectBaseItemNetcontentDataByItemId(innerItemId,bomNo,version);
        }
    }

    /**
     * 新增描述：成品净含量
     *
     * @param baseItemNetcontent 描述：成品净含量
     * @return 结果
     */
    @Override
    public int insertBaseItemNetcontent(BaseItemNetcontent baseItemNetcontent) {
        baseItemNetcontent.setCreateBy(SecurityUtils.getUsername());
        baseItemNetcontent.setCreateTime(DateUtils.getNowDate());
        return baseItemNetcontentMapper.insertBaseItemNetcontent(baseItemNetcontent);
    }

    /**
     * 修改描述：成品净含量
     *
     * @param baseItemNetcontent 描述：成品净含量
     * @return 结果
     */
    @Override
    public int updateBaseItemNetcontent(BaseItemNetcontent baseItemNetcontent) {
        baseItemNetcontent.setUpdateBy(SecurityUtils.getUsername());
        baseItemNetcontent.setUpdateTime(DateUtils.getNowDate());
        return baseItemNetcontentMapper.updateBaseItemNetcontent(baseItemNetcontent);
    }

    /**
     * 批量删除描述：成品净含量
     *
     * @param ids 需要删除的描述：成品净含量主键
     * @return 结果
     */
    @Override
    public int deleteBaseItemNetcontentByIds(Long[] ids) {
        return baseItemNetcontentMapper.deleteBaseItemNetcontentByIds(ids);
    }

    /**
     * 删除描述：成品净含量信息
     *
     * @param id 描述：成品净含量主键
     * @return 结果
     */
    @Override
    public int deleteBaseItemNetcontentById(Long id) {
        return baseItemNetcontentMapper.deleteBaseItemNetcontentById(id);
    }
}
