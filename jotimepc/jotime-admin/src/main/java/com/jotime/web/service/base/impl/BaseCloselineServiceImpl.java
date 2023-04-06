package com.jotime.web.service.base.impl;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.base.BaseCloseline;
import com.jotime.web.domain.base.BaseCloselinedtl;
import com.jotime.web.domainVo.base.BaseCloselineVo;
import com.jotime.web.mapper.base.BaseCloselineMapper;
import com.jotime.web.mapper.base.BaseCloselinedtlMapper;
import com.jotime.web.service.base.IBaseCloselineService;
import com.jotime.web.service.base.IBaseCloselinedtlService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 清线检查Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@Service
public class BaseCloselineServiceImpl implements IBaseCloselineService
{
    @Autowired
    private BaseCloselineMapper baseCloselineMapper;
    @Autowired
    private BaseCloselinedtlMapper baseCloselinedtlMapper;
    @Autowired
    private IBaseCloselinedtlService iBaseCloselinedtlService;
    /**
     * 查询清线检查
     *
     * @param id 清线检查主键
     * @return 清线检查
     */
    @Override
    public BaseCloseline selectBaseCloselineById(Long id)
    {
        return baseCloselineMapper.selectBaseCloselineById(id);
    }

    /**
     * 查询清线检查列表
     *
     * @param baseCloseline 清线检查
     * @return 清线检查
     */
    @Override
    public List<BaseCloseline> selectBaseCloselineList(BaseCloseline baseCloseline)
    {
        return baseCloselineMapper.selectBaseCloselineList(baseCloseline);
    }

    /**
     * 新增清线检查
     *
     * @param baseCloseline 清线检查
     * @return 结果
     */
    @Override
    public int insertBaseCloseline(BaseCloseline baseCloseline)
    {
        baseCloseline.setCreateTime(DateUtils.getNowDate());
        return baseCloselineMapper.insertBaseCloseline(baseCloseline);
    }

    @Override
    public AjaxResult insertBaseCloselineAndDtl(BaseCloselineVo baseCloselineVo) {
        //        获取要插入的dtl
        List<BaseCloselinedtl> baseCloselinedtls = baseCloselineVo.getBaseCloselinedtls();
        BaseCloseline baseCloseline = new BaseCloseline();
//        Vo数据拷贝
        BeanUtils.copyProperties(baseCloselineVo,baseCloseline);
        baseCloseline.setCreateBy(SecurityUtils.getUserId().toString());
        baseCloseline.setCreateTime(DateUtils.getNowDate());
//        利用mybatisPlus插入数据并把id回传到对象
        int insert = baseCloselineMapper.insert(baseCloseline);
        for (BaseCloselinedtl baseCloselinedtl : baseCloselinedtls) {
//            判断数据是否有空值
//                设置开线检查信息id并插入数据
            if (baseCloselinedtl.getSort()==null){
                baseCloselinedtl.setSort(1);
            }
            baseCloselinedtl.setCloselineId(baseCloseline.getId());
            baseCloselinedtl.setCreateBy(SecurityUtils.getUserId().toString());
            baseCloselinedtl.setCreateTime(DateUtils.getNowDate());
            iBaseCloselinedtlService.insertBaseCloselinedtl(baseCloselinedtl);
        }
        return AjaxResult.success(insert);
    }

    /**
     * 修改清线检查
     *
     * @param baseCloseline 清线检查
     * @return 结果
     */
    @Override
    public int updateBaseCloseline(BaseCloseline baseCloseline)
    {
        baseCloseline.setUpdateTime(DateUtils.getNowDate());
        return baseCloselineMapper.updateBaseCloseline(baseCloseline);
    }

    /**
     * 修改清线检查和对应dtl数据
     * @param baseCloselineVo
     * @return
     */
    @Override
    @Transactional
    public AjaxResult updateBaseCloselineAndDtl(BaseCloselineVo baseCloselineVo) {
//        获取要更新的dtl数据
        List<BaseCloselinedtl> baseCloselinedtls = baseCloselineVo.getBaseCloselinedtls();
        BaseCloseline baseCloseline = new BaseCloseline();
//        数据拷贝
        BeanUtils.copyProperties(baseCloselineVo,baseCloseline);
//        BaseCloselinedtl baseCloselinedtl = new BaseCloselinedtl();
//        baseCloselinedtl.setCloselineId(baseCloselineVo.getId());
////        获取原本dtl数据并删除
//        List<BaseCloselinedtl> baseCloselinedtls1 = iBaseCloselinedtlService.selectBaseCloselinedtlList(baseCloselinedtl);
//        Long[] ids = new Long[baseCloselinedtls1.size()];
//        for (int i = 0; i < ids.length; i++) {
//            ids[i] = baseCloselinedtls1.get(i).getId();
//        }
//        iBaseCloselinedtlService.deleteBaseCloselinedtlByIds(ids);
        baseCloselinedtlMapper.deleteBaseCloselinedtlByLineId(baseCloselineVo.getId());
        for (BaseCloselinedtl baseCloselinedtl1 : baseCloselinedtls) {
//                设置开线检查信息id并插入数据
                if (baseCloselinedtl1.getCreateBy()==null)
                {
                    baseCloselinedtl1.setCreateBy(SecurityUtils.getUserId().toString());
                }
                if (baseCloselinedtl1.getCreateTime()==null)
                {
                    baseCloselinedtl1.setCreateTime(DateUtils.getNowDate());
                }
                baseCloselinedtl1.setUpdateBy(SecurityUtils.getUserId().toString());
                baseCloselinedtl1.setUpdateTime(DateUtils.getNowDate());
                baseCloselinedtl1.setCloselineId(baseCloseline.getId());
                iBaseCloselinedtlService.insertBaseCloselinedtl(baseCloselinedtl1);

        }
        baseCloseline.setUpdateTime(DateUtils.getNowDate());
        baseCloseline.setUpdateBy(SecurityUtils.getUserId().toString());
        return AjaxResult.success(baseCloselineMapper.updateBaseCloseline(baseCloseline));
    }

    /**
     * 批量删除清线检查
     *
     * @param ids 需要删除的清线检查主键
     * @return 结果
     */
    @Override
    public int deleteBaseCloselineByIds(Long[] ids)
    {
        return baseCloselineMapper.deleteBaseCloselineByIds(ids);
    }

    /**
     * 批量删除清线检查和详情信息
     * @param ids 需要删除的清线检查主键集合
     * @return
     */
    @Override
    public int deleteBaseCloselineAndDtlByIds(Long[] ids) {
        int row = baseCloselineMapper.deleteBaseCloselineByIds(ids);
        for (Long id : ids) {
            BaseCloselinedtl baseCloselinedtl = new BaseCloselinedtl();
            baseCloselinedtl.setCloselineId(id);
            List<BaseCloselinedtl> baseCloselinedtls = iBaseCloselinedtlService.selectBaseCloselinedtlList(baseCloselinedtl);
            Long [] dtlIds = new Long[baseCloselinedtls.size()];
            for (int i = 0; i < dtlIds.length; i++) {
                dtlIds[i] = baseCloselinedtls.get(i).getId();
            }
            if (dtlIds.length>0){
                iBaseCloselinedtlService.deleteBaseCloselinedtlByIds(dtlIds);
            }

        }
        return row;
    }

    /**
     * 删除清线检查信息
     *
     * @param id 清线检查主键
     * @return 结果
     */
    @Override
    public int deleteBaseCloselineById(Long id)
    {
        return baseCloselineMapper.deleteBaseCloselineById(id);
    }
    /**
     * 新增清线检查和详情
     *
     * @param baseCloselineVo 清线检查
     * @return 结果
     */
    @Override
    public AjaxResult addAnddtl(BaseCloselineVo baseCloselineVo) {
//        获取要插入的dtl
        List<BaseCloselinedtl> baseCloselinedtls = baseCloselineVo.getBaseCloselinedtls();
        BaseCloseline baseCloseline = new BaseCloseline();
//        Vo数据拷贝
        BeanUtils.copyProperties(baseCloselineVo,baseCloseline);
        baseCloseline.setCreateTime(DateUtils.getNowDate());
        baseCloseline.setCreateBy(SecurityUtils.getUserId().toString());
//        利用mybatisPlus插入数据并把id回传到对象
        int row = baseCloselineMapper.insert(baseCloseline);
        for (BaseCloselinedtl baseCloselinedtl : baseCloselinedtls) {
//            判断数据是否有空值

                    baseCloselinedtl.setCloselineId(baseCloseline.getId());
                iBaseCloselinedtlService.insertBaseCloselinedtl(baseCloselinedtl);

        }
        return AjaxResult.success(row);
    }

    /**
     * 获取清线检查和对应dtl数据列表
     * @param baseCloseline 清线检查
     * @return
     */
    @Override
    public List<BaseCloselineVo> selectBaseCloselineVoList(BaseCloseline baseCloseline) {
        List<BaseCloselineVo> baseCloselineVos = baseCloselineMapper.selectBaseCloselineVoList(baseCloseline);
        BaseCloselinedtl baseCloselinedtl = new BaseCloselinedtl();
        for (BaseCloselineVo baseCloselineVo : baseCloselineVos) {
            baseCloselinedtl.setCloselineId(baseCloselineVo.getId());
            List<BaseCloselinedtl> baseCloselinedtls = iBaseCloselinedtlService.selectBaseCloselinedtlList(baseCloselinedtl);
            baseCloselineVo.setBaseCloselinedtls(baseCloselinedtls);
        }
        return baseCloselineVos;
    }
    /**
     * 查询清线检查
     *
     * @param id 清线检查主键
     * @return 清线检查
     */
    public AjaxResult getCloselineAndDtl(Long id){
        BaseCloseline baseCloseline = baseCloselineMapper.selectBaseCloselineById(id);
        BaseCloselinedtl baseCloselinedtl = new BaseCloselinedtl();
        baseCloselinedtl.setCloselineId(baseCloseline.getId());
        List<BaseCloselinedtl> baseCloselinedtls = iBaseCloselinedtlService.selectBaseCloselinedtlList(baseCloselinedtl);
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put(AjaxResult.DATA_TAG,baseCloseline);
        ajaxResult.put("baseCloselinedtls",baseCloselinedtls);
        return ajaxResult;
    }
}
