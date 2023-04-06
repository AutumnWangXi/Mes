package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.base.BaseLine;
import com.jotime.web.domainVo.base.BaseLineVo;
import com.jotime.web.mapper.base.BaseLineMapper;
import com.jotime.web.service.base.IBaseLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 流水线信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-16
 */
@Service
public class BaseLineServiceImpl implements IBaseLineService
{
    @Autowired
    private BaseLineMapper baseLineMapper;

    /**
     * 查询流水线信息
     *
     * @param id 流水线信息主键
     * @return 流水线信息
     */
    @Override
    public BaseLine selectBaseLineById(Long id)
    {
        return baseLineMapper.selectBaseLineById(id);
    }

    /**
     * 查询流水线信息列表
     *
     * @param baseLine 流水线信息
     * @return 流水线信息
     */
    @Override
    public List<BaseLine> selectBaseLineList(BaseLine baseLine)
    {
        return baseLineMapper.selectBaseLineList(baseLine);
    }

    /**
     * 新增流水线信息
     *
     * @param baseLine 流水线信息
     * @return 结果
     */
    @Override
    public int insertBaseLine(BaseLine baseLine)
    {
//        判断是否已有该编码
        BaseLine baseLine1 = new BaseLine();
        baseLine1.setLineCode(baseLine.getLineCode());
        List<BaseLine> baseLines = baseLineMapper.selectBaseLineList(baseLine1);
        if (baseLines.size()==0){
            baseLine.setCreateTime(DateUtils.getNowDate());
            baseLine.setCreateBy(SecurityUtils.getUsername());
            return baseLineMapper.insertBaseLine(baseLine);
        }

        return 0;
    }

    /**
     * 修改流水线信息
     *
     * @param baseLine 流水线信息
     * @return 结果
     */
    @Override
    public int updateBaseLine(BaseLine baseLine)
    {
        baseLine.setUpdateTime(DateUtils.getNowDate());
        return baseLineMapper.updateBaseLine(baseLine);
    }

    /**
     * 批量删除流水线信息
     *
     * @param ids 需要删除的流水线信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseLineByIds(Long[] ids)
    {
        return baseLineMapper.deleteBaseLineByIds(ids);
    }

    /**
     * 删除流水线信息信息
     *
     * @param id 流水线信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseLineById(Long id)
    {
        return baseLineMapper.deleteBaseLineById(id);
    }

    /**
     * 查询流水线信息列表
     *
     * @param baseLine 流水线信息
     * @return 流水线信息集合
     */
    @Override
    public List<BaseLineVo> selectBaseLineVoList(BaseLine baseLine){
        return baseLineMapper.selectBaseLineVoList(baseLine);
    }

    @Override
    public List<BaseLine> lineList() {
        return baseLineMapper.selectBaseLineList(null);
    }

}
