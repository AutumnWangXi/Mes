package com.jotime.web.service.base.impl;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.base.BaseOpenline;
import com.jotime.web.domain.base.BaseOpenlinedtl;
import com.jotime.web.domainVo.base.BaseOpenlineVo;
import com.jotime.web.domainVo.base.BaseOpenlinedtlVo;
import com.jotime.web.mapper.base.BaseOpenlineMapper;
import com.jotime.web.service.base.IBaseOpenlineService;
import com.jotime.web.service.base.IBaseOpenlinedtlService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 开线检查Service业务层处理
 *
 * @author YunFei
 * @date 2022-03-04
 */
@Service
public class BaseOpenlineServiceImpl implements IBaseOpenlineService
{
    @Autowired
    private BaseOpenlineMapper baseOpenlineMapper;
    @Autowired
    private IBaseOpenlinedtlService iBaseOpenlinedtlService;
    /**
     * 查询开线检查
     *
     * @param id 开线检查主键
     * @return 开线检查
     */
    @Override
    public BaseOpenline selectBaseOpenlineById(Long id)
    {
        return baseOpenlineMapper.selectBaseOpenlineById(id);
    }

    /**
     * 查询开线检查列表
     *
     * @param baseOpenline 开线检查
     * @return 开线检查
     */
    @Override
    public List<BaseOpenline> selectBaseOpenlineList(BaseOpenline baseOpenline)
    {
        return baseOpenlineMapper.selectBaseOpenlineList(baseOpenline);
    }
    /**
     * 查询开线检查列表Vo
     *
     * @param baseOpenline 开线检查
     * @return 开线检查集合
     */
    public List<BaseOpenlineVo> selectBaseOpenlineVoList(BaseOpenline baseOpenline){
        List<BaseOpenlineVo> baseOpenlineVos = baseOpenlineMapper.selectBaseOpenlineVoList(baseOpenline);
        for (BaseOpenlineVo baseOpenlineVo : baseOpenlineVos) {
            BaseOpenlinedtl baseOpenlinedtl = new BaseOpenlinedtl();
            baseOpenlinedtl.setOpenlineId(baseOpenlineVo.getId());
            List<BaseOpenlinedtlVo> baseOpenlinedtlVos = iBaseOpenlinedtlService.selectBaseOpenlinedtlVoList(baseOpenlinedtl);
            baseOpenlineVo.setBaseOpenlinedtl(baseOpenlinedtlVos);
        }

        return baseOpenlineVos;
    }
    /**
     * 新增开线检查
     *
     * @param baseOpenline 开线检查
     * @return 结果
     */
    @Override
    public int insertBaseOpenline(BaseOpenline baseOpenline)
    {
        baseOpenline.setCreateTime(DateUtils.getNowDate());
        return baseOpenlineMapper.insertBaseOpenline(baseOpenline);
    }

    /**
     * 修改开线检查
     *
     * @param baseOpenline 开线检查
     * @return 结果
     */
    @Override
    public int updateBaseOpenline(BaseOpenline baseOpenline)
    {
        baseOpenline.setUpdateTime(DateUtils.getNowDate());
        return baseOpenlineMapper.updateBaseOpenline(baseOpenline);
    }

    /**
     * 批量删除开线检查
     *
     * @param ids 需要删除的开线检查主键
     * @return 结果
     */
    @Override
    public int deleteBaseOpenlineByIds(Long[] ids)
    {
        return baseOpenlineMapper.deleteBaseOpenlineByIds(ids);
    }

    /**
     * 删除开线检查信息
     *
     * @param id 开线检查主键
     * @return 结果
     */
    @Override
    public int deleteBaseOpenlineById(Long id)
    {
        return baseOpenlineMapper.deleteBaseOpenlineById(id);
    }

    /**
     * @Description 添加开线检查表
     * @param
     * @return
     * @auther
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addOpenline(BaseOpenlineVo baseOpenlineVo) {
//        获取要插入的dtl
        List<BaseOpenlinedtlVo> baseOpenlinedtlList = baseOpenlineVo.getBaseOpenlinedtl();
        BaseOpenline baseOpenline = new BaseOpenline();
//        Vo数据拷贝
        BeanUtils.copyProperties(baseOpenlineVo,baseOpenline);
        baseOpenline.setCreateBy(SecurityUtils.getUserId().toString());
        baseOpenline.setCreateTime(DateUtils.getNowDate());
//        利用mybatisPlus插入数据并把id回传到对象
        int insert = baseOpenlineMapper.insert(baseOpenline);
        for (BaseOpenlinedtlVo baseOpenlinedtlVo : baseOpenlinedtlList) {
            BaseOpenlinedtl baseOpenlinedtl = new BaseOpenlinedtl();
//            Vo数据拷贝
            BeanUtils.copyProperties(baseOpenlinedtlVo,baseOpenlinedtl);
            if (baseOpenlinedtl.getSort()==null){
                baseOpenlinedtl.setSort(1);
            }
            baseOpenlinedtl.setCreateBy(SecurityUtils.getUserId().toString());
            baseOpenlinedtl.setCreateTime(DateUtils.getNowDate());
//                设置开线检查信息id并插入数据
            baseOpenlinedtl.setOpenlineId(baseOpenline.getId());
            iBaseOpenlinedtlService.insertBaseOpenlinedtl(baseOpenlinedtl);
        }
        return AjaxResult.success(insert);
    }
    /**
     * @Description 添加开线检查表
     * @param
     * @return
     * @auther
     */
    @Override
    public AjaxResult getOpenline(Long id) {
        BaseOpenline baseOpenline = baseOpenlineMapper.selectBaseOpenlineById(id);
        BaseOpenlinedtl baseOpenlinedtl = new BaseOpenlinedtl();
        baseOpenlinedtl.setOpenlineId(id);
        List<BaseOpenlinedtl> baseOpenlinedtls = iBaseOpenlinedtlService.selectBaseOpenlinedtlList(baseOpenlinedtl);
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put(AjaxResult.DATA_TAG,baseOpenline);
        ajaxResult.put("baseOpenlinedtlList",baseOpenlinedtls);
        return ajaxResult;
    }

    /**
     * @Description 添加开线检查表
     * @param
     * @return
     * @auther
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult UpdateOpenline(BaseOpenlineVo baseOpenlineVo) {
//        获取要更新的dtl数据
        List<BaseOpenlinedtlVo> baseOpenlinedtl = baseOpenlineVo.getBaseOpenlinedtl();
        BaseOpenline baseOpenline = new BaseOpenline();
//        数据拷贝
        BeanUtils.copyProperties(baseOpenlineVo,baseOpenline);
        BaseOpenlinedtl baseOpenlinedtl1 = new BaseOpenlinedtl();
        baseOpenlinedtl1.setOpenlineId(baseOpenlineVo.getId());
//        获取原本dtl数据并删除
        List<BaseOpenlinedtl> baseOpenlinedtls = iBaseOpenlinedtlService.selectBaseOpenlinedtlList(baseOpenlinedtl1);
        Long[] ids = new Long[baseOpenlinedtls.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = baseOpenlinedtls.get(i).getId();
        }
        iBaseOpenlinedtlService.deleteBaseOpenlinedtlByIds(ids);
        for (BaseOpenlinedtlVo baseOpenlinedtlVo : baseOpenlinedtl) {
//                设置开线检查信息id并插入数据
                BaseOpenlinedtl baseOpenlinedtl2 = new BaseOpenlinedtl();
                BeanUtils.copyProperties(baseOpenlinedtlVo,baseOpenlinedtl2);
//                判断数据是否有重复
                if (baseOpenlinedtl2.getCreateBy()==null)baseOpenlinedtl2.setCreateBy(SecurityUtils.getUserId().toString());
                if (baseOpenlinedtl2.getCreateTime()==null)baseOpenlinedtl2.setCreateTime(DateUtils.getNowDate());
                baseOpenlinedtl2.setUpdateBy(SecurityUtils.getUserId().toString());
                baseOpenlinedtl2.setUpdateTime(DateUtils.getNowDate());
                baseOpenlinedtl2.setOpenlineId(baseOpenline.getId());
                iBaseOpenlinedtlService.insertBaseOpenlinedtl(baseOpenlinedtl2);

        }
        baseOpenline.setUpdateTime(DateUtils.getNowDate());
        baseOpenline.setUpdateBy(SecurityUtils.getUserId().toString());
        return AjaxResult.success(baseOpenlineMapper.updateBaseOpenline(baseOpenline));
    }
    /**
     * 批量删除开线检查
     *
     * @param ids 需要删除的开线检查主键
     * @return 结果
     */
    @Override
    public AjaxResult deleteBaseOpenlineAndDtlByIds(Long[] ids)
    {
        int row = baseOpenlineMapper.deleteBaseOpenlineByIds(ids);
        for (Long id : ids) {
            BaseOpenlinedtl baseOpenlinedtl = new BaseOpenlinedtl();
            baseOpenlinedtl.setOpenlineId(id);
            List<BaseOpenlinedtl> baseOpenlinedtls = iBaseOpenlinedtlService.selectBaseOpenlinedtlList(baseOpenlinedtl);
            Long [] dtlIds = new Long[baseOpenlinedtls.size()];
            for (int i = 0; i < dtlIds.length; i++) {
                dtlIds[i] = baseOpenlinedtls.get(i).getId();
            }
            if (dtlIds.length>0){
                iBaseOpenlinedtlService.deleteBaseOpenlinedtlByIds(dtlIds);
            }

        }
        return AjaxResult.success(row);
    }
}
