package com.jotime.web.service.base.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseCir;
import com.jotime.web.domain.base.BaseRiskSubstances;
import com.jotime.web.mapper.base.BaseCirMapper;
import com.jotime.web.service.base.IBaseCirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * 美国CIR审查安全使用的化妆品原料Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
@Service
public class BaseCirServiceImpl implements IBaseCirService
{
    @Autowired
    private BaseCirMapper baseCirMapper;

    /**
     * 查询美国CIR审查安全使用的化妆品原料
     *
     * @param id 美国CIR审查安全使用的化妆品原料主键
     * @return 美国CIR审查安全使用的化妆品原料
     */
    @Override
    public BaseCir selectBaseCirById(Long id)
    {
        return baseCirMapper.selectBaseCirById(id);
    }

    /**
     * 查询美国CIR审查安全使用的化妆品原料列表
     *
     * @param baseCir 美国CIR审查安全使用的化妆品原料
     * @return 美国CIR审查安全使用的化妆品原料
     */
    @Override
    public List<BaseCir> selectBaseCirList(BaseCir baseCir)
    {
        return baseCirMapper.selectBaseCirList(baseCir);
    }

    /**
     * 新增美国CIR审查安全使用的化妆品原料
     *
     * @param baseCir 美国CIR审查安全使用的化妆品原料
     * @return 结果
     */
    @Override
    public int insertBaseCir(BaseCir baseCir)
    {
        baseCir.setCreateBy(SecurityUtils.getUsername());
        baseCir.setCreateTime(DateUtils.getNowDate());
        //      判断重复
        if (!ObjectUtils.isEmpty(baseCirMapper.selectBaseCirByNameEn(baseCir.getInciNameEn()))){
            throw new RuntimeException("名称重复！");
        }
        return baseCirMapper.insertBaseCir(baseCir);
    }

    /**
     * 修改美国CIR审查安全使用的化妆品原料
     *
     * @param baseCir 美国CIR审查安全使用的化妆品原料
     * @return 结果
     */
    @Override
    public int updateBaseCir(BaseCir baseCir)
    {
        BaseCir baseCir1 = baseCirMapper.selectBaseCirByNameEn(baseCir.getInciNameEn());
//      判断重复
        if (!ObjectUtils.isEmpty(baseCir1)){
            if (!baseCir1.getId().equals(baseCir.getId())){
                throw new RuntimeException("名称重复！");
            }
        }
        baseCir.setUpdateBy(SecurityUtils.getUsername());
        baseCir.setUpdateTime(DateUtils.getNowDate());
        return baseCirMapper.updateBaseCir(baseCir);
    }

    /**
     * 批量删除美国CIR审查安全使用的化妆品原料
     *
     * @param ids 需要删除的美国CIR审查安全使用的化妆品原料主键
     * @return 结果
     */
    @Override
    public int deleteBaseCirByIds(Long[] ids)
    {
        return baseCirMapper.deleteBaseCirByIds(ids);
    }

    /**
     * 删除美国CIR审查安全使用的化妆品原料信息
     *
     * @param id 美国CIR审查安全使用的化妆品原料主键
     * @return 结果
     */
    @Override
    public int deleteBaseCirById(Long id)
    {
        return baseCirMapper.deleteBaseCirById(id);
    }

    /**
     * @param baseCirList     表格
     * @param isUpdateSupport 是否可更新
     * @Description: 导入
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    @Override
    @Transactional
    public int importData(List<BaseCir> baseCirList, Boolean isUpdateSupport) {
        int row = 0;
        for (BaseCir baseCir : baseCirList) {
            if (StringUtils.isNotEmpty(baseCir.getInciNameEn())){
//                查询数据库中是否有该名称的数据，有则更新，无则插入
                BaseCir baseCirDataBase = baseCirMapper.selectBaseCirByNameEn(baseCir.getInciNameEn());
                //                更新操作
                if (!ObjectUtils.isEmpty(baseCirDataBase)){
                    baseCir.setUpdateBy(SecurityUtils.getUsername());
                    baseCir.setUpdateTime(DateUtils.getNowDate());
                    baseCir.setId(baseCirDataBase.getId());
                    row+=baseCirMapper.updateBaseCir(baseCir);
                }else {
                    //插入操作
                    baseCir.setCreateTime(DateUtils.getNowDate());
                    baseCir.setCreateBy(SecurityUtils.getUsername());
                    row+=baseCirMapper.insertBaseCir(baseCir);
                }
            }
        }
        return row;
    }
}
