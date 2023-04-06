package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseCir;

import java.util.List;

/**
 * 美国CIR审查安全使用的化妆品原料Service接口
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
public interface IBaseCirService
{
    /**
     * 查询美国CIR审查安全使用的化妆品原料
     *
     * @param id 美国CIR审查安全使用的化妆品原料主键
     * @return 美国CIR审查安全使用的化妆品原料
     */
    public BaseCir selectBaseCirById(Long id);

    /**
     * 查询美国CIR审查安全使用的化妆品原料列表
     *
     * @param baseCir 美国CIR审查安全使用的化妆品原料
     * @return 美国CIR审查安全使用的化妆品原料集合
     */
    public List<BaseCir> selectBaseCirList(BaseCir baseCir);

    /**
     * 新增美国CIR审查安全使用的化妆品原料
     *
     * @param baseCir 美国CIR审查安全使用的化妆品原料
     * @return 结果
     */
    public int insertBaseCir(BaseCir baseCir);

    /**
     * 修改美国CIR审查安全使用的化妆品原料
     *
     * @param baseCir 美国CIR审查安全使用的化妆品原料
     * @return 结果
     */
    public int updateBaseCir(BaseCir baseCir);

    /**
     * 批量删除美国CIR审查安全使用的化妆品原料
     *
     * @param ids 需要删除的美国CIR审查安全使用的化妆品原料主键集合
     * @return 结果
     */
    public int deleteBaseCirByIds(Long[] ids);

    /**
     * 删除美国CIR审查安全使用的化妆品原料信息
     *
     * @param id 美国CIR审查安全使用的化妆品原料主键
     * @return 结果
     */
    public int deleteBaseCirById(Long id);

    /**
     * @Description: 导入
     * @param baseCirList 表格
     * @param isUpdateSupport 是否可更新
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    public int importData(List<BaseCir> baseCirList, Boolean isUpdateSupport);

}
