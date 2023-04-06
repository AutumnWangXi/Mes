package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseCir;

import java.util.List;

/**
 * 美国CIR审查安全使用的化妆品原料Mapper接口
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
public interface BaseCirMapper
{
    /**
     * 查询美国CIR审查安全使用的化妆品原料
     *
     * @param id 美国CIR审查安全使用的化妆品原料主键
     * @return 美国CIR审查安全使用的化妆品原料
     */
    public BaseCir selectBaseCirById(Long id);
    /**
     * 查询美国CIR审查安全使用的化妆品原料
     *
     * @param nameEn 美国CIR审查安全使用的化妆品原料nameEn
     * @return 美国CIR审查安全使用的化妆品原料
     */
    public BaseCir selectBaseCirByNameEn(String nameEn);

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
     * 删除美国CIR审查安全使用的化妆品原料
     *
     * @param id 美国CIR审查安全使用的化妆品原料主键
     * @return 结果
     */
    public int deleteBaseCirById(Long id);

    /**
     * 批量删除美国CIR审查安全使用的化妆品原料
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCirByIds(Long[] ids);
}
