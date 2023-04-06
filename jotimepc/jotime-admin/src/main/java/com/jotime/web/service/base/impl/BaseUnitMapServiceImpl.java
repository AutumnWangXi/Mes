package com.jotime.web.service.base.impl;

import com.jotime.common.constant.Constants;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseUnitMap;
import com.jotime.web.mapper.base.BaseUnitMapMapper;
import com.jotime.web.service.base.IBaseUnitMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;


/**
 * 单位转换Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-31
 */
@Service
public class BaseUnitMapServiceImpl implements IBaseUnitMapService 
{
    @Autowired
    private BaseUnitMapMapper baseUnitMapMapper;

    /**
     * 查询单位转换
     * 
     * @param id 单位转换主键
     * @return 单位转换
     */
    @Override
    public BaseUnitMap selectBaseUnitMapById(Long id)
    {
        return baseUnitMapMapper.selectBaseUnitMapById(id);
    }

    /**
     * 查询单位转换列表
     * 
     * @param baseUnitMap 单位转换
     * @return 单位转换
     */
    @Override
    public List<BaseUnitMap> selectBaseUnitMapList(BaseUnitMap baseUnitMap)
    {
        return baseUnitMapMapper.selectBaseUnitMapList(baseUnitMap);
    }

    /**
     * 新增单位转换
     * 
     * @param baseUnitMap 单位转换
     * @return 结果
     */
    @Override
    public int insertBaseUnitMap(BaseUnitMap baseUnitMap)
    {
        int iRtn = 0;
        // 插入数据校验
        BaseUnitMap chkUnitMap = new BaseUnitMap();
        chkUnitMap.setFromUnitName(StringUtils.trim(baseUnitMap.getFromUnitName()));
        chkUnitMap.setToUnitName(StringUtils.trim(baseUnitMap.getToUnitName()));
        // 查询
        List<BaseUnitMap> listChkUnitMap = baseUnitMapMapper.selectBaseUnitMapChkList(chkUnitMap);
        if (StringUtils.isEmpty(listChkUnitMap)) {
            baseUnitMap.setStatus(Constants.STATUS_OK);
            baseUnitMap.setCreateBy(SecurityUtils.getUsername());
            iRtn = baseUnitMapMapper.insertBaseUnitMap(baseUnitMap);
        }

        return iRtn;
    }

    /**
     * 修改单位转换
     * 
     * @param baseUnitMap 单位转换
     * @return 结果
     */
    @Override
    public int updateBaseUnitMap(BaseUnitMap baseUnitMap)
    {
        int iRtn = 0;
        // 更新数据校验
        BaseUnitMap chkUnitMap = new BaseUnitMap();
        chkUnitMap.setFromUnitName(StringUtils.trim(baseUnitMap.getFromUnitName()));
        chkUnitMap.setToUnitName(StringUtils.trim(baseUnitMap.getToUnitName()));
        // 查询
        List<BaseUnitMap> listChkUnitMap = baseUnitMapMapper.selectBaseUnitMapChkList(chkUnitMap);
        if (StringUtils.isNotEmpty(listChkUnitMap)) {
            baseUnitMap.setUpdateBy(SecurityUtils.getUsername());
            iRtn = baseUnitMapMapper.updateBaseUnitMap(baseUnitMap);
        }

        return iRtn;
    }

    /**
     * 批量删除单位转换
     * 
     * @param ids 需要删除的单位转换主键
     * @return 结果
     */
    @Override
    public int deleteBaseUnitMapByIds(Long[] ids)
    {
        return baseUnitMapMapper.deleteBaseUnitMapByIds(ids);
    }

    /**
     * 删除单位转换信息
     * 
     * @param id 单位转换主键
     * @return 结果
     */
    @Override
    public int deleteBaseUnitMapById(Long id)
    {
        return baseUnitMapMapper.deleteBaseUnitMapById(id);
    }

    @Override
    public List<BaseUnitMap> selectBaseUnitMapdistinctlist(BaseUnitMap baseUnitMap) {
        List<BaseUnitMap> baseUnitMaps = baseUnitMapMapper.selectBaseUnitMapList(null);
        baseUnitMaps =  baseUnitMaps.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseUnitMap::getFromUnitName))), ArrayList::new));
        return baseUnitMaps;
    }
}
