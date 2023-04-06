package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseLine;
import com.jotime.web.domainVo.base.BaseLineVo;

import java.util.List;

/**
 * 流水线信息Service接口
 *
 * @author ruoyi
 * @date 2022-03-16
 */
public interface IBaseLineService
{
    /**
     * 查询流水线信息
     *
     * @param id 流水线信息主键
     * @return 流水线信息
     */
    public BaseLine selectBaseLineById(Long id);

    /**
     * 查询流水线信息列表
     *
     * @param baseLine 流水线信息
     * @return 流水线信息集合
     */
    public List<BaseLine> selectBaseLineList(BaseLine baseLine);

    /**
     * 新增流水线信息
     *
     * @param baseLine 流水线信息
     * @return 结果
     */
    public int insertBaseLine(BaseLine baseLine);

    /**
     * 修改流水线信息
     *
     * @param baseLine 流水线信息
     * @return 结果
     */
    public int updateBaseLine(BaseLine baseLine);

    /**
     * 批量删除流水线信息
     *
     * @param ids 需要删除的流水线信息主键集合
     * @return 结果
     */
    public int deleteBaseLineByIds(Long[] ids);

    /**
     * 删除流水线信息信息
     *
     * @param id 流水线信息主键
     * @return 结果
     */
    public int deleteBaseLineById(Long id);

    /**
     * 查询流水线信息列表
     *
     * @param baseLine 流水线信息
     * @return 流水线信息集合
     */
    public List<BaseLineVo> selectBaseLineVoList(BaseLine baseLine);


    /**
     * 流水线下拉框
     */
    public List<BaseLine> lineList();
}
