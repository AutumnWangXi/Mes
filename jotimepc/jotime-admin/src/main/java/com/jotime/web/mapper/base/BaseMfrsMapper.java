package com.jotime.web.mapper.base;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseMfrs;

/**
 * 制造商Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-30
 */
public interface BaseMfrsMapper extends BaseMapper<BaseMfrs>
{
    /**
     * 查询制造商
     *
     * @param id 制造商主键
     * @return 制造商
     */
    public BaseMfrs selectBaseMfrsById(Long id);
    /**
     * 查询制造商
     *
     * @param mfrsCode 制造商code
     * @return 制造商
     */
    public BaseMfrs selectBaseMfrsByCode(String mfrsCode);

    /**
     * 查询制造商列表
     *
     * @param baseMfrs 制造商
     * @return 制造商集合
     */
    public List<BaseMfrs> selectBaseMfrsList(BaseMfrs baseMfrs);

    /**
     * 查询制造商列表
     *
     * @param code 制造商
     * @return 制造商集合
     */
    public List<BaseMfrs> selectBaseMfrsInfoByCode(String code);

    /**
     * 查询制造商列表
     *
     * @param name 制造商
     * @return 制造商集合
     */
    public List<BaseMfrs> selectBaseMfrsInfoByName(String name);

    /**
     * 新增制造商
     *
     * @param baseMfrs 制造商
     * @return 结果
     */
    public int insertBaseMfrs(BaseMfrs baseMfrs);

    /**
     * 修改制造商
     *
     * @param baseMfrs 制造商
     * @return 结果
     */
    public int updateBaseMfrs(BaseMfrs baseMfrs);

    /**
     * 删除制造商
     *
     * @param id 制造商主键
     * @return 结果
     */
    public int deleteBaseMfrsById(Long id);

    /**
     * 批量删除制造商
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseMfrsByIds(Long[] ids);

    /**
     * 查询制造商列表
     *
     * @param status 制造商
     * @return 制造商集合
     */
    public List<BaseMfrs> selectMfrsInfoBySts(Long status);

}
