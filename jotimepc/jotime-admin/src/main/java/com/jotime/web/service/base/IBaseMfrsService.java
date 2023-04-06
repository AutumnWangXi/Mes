package com.jotime.web.service.base;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.web.domain.base.BaseMfrs;

/**
 * 制造商Service接口
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public interface IBaseMfrsService extends IService<BaseMfrs>
{
    /**
     * 查询制造商
     * 
     * @param id 制造商主键
     * @return 制造商
     */
    public BaseMfrs selectBaseMfrsById(Long id);

    /**
     * 查询制造商列表
     * 
     * @param baseMfrs 制造商
     * @return 制造商集合
     */
    public List<BaseMfrs> selectBaseMfrsList(BaseMfrs baseMfrs);

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
     * 批量删除制造商
     * 
     * @param ids 需要删除的制造商主键集合
     * @return 结果
     */
    public int deleteBaseMfrsByIds(Long[] ids);

    /**
     * 删除制造商信息
     * 
     * @param id 制造商主键
     * @return 结果
     */
    public int deleteBaseMfrsById(Long id);

    /**
     * 校验生产Code是否唯一性
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */
    public String checkMfrsCodeUnique(BaseMfrs baseMfrs);

    /**
     * 校验生产name是否唯一性
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */

    public String checkMfrsNameUnique(BaseMfrs baseMfrs);

    /**
     * 校验生产Code是否唯一性
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */
    public String checkUpMfrsIdUnique(BaseMfrs baseMfrs);

    /**
     * 校验生产name是否唯一性
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */

    public String checkUpMfrsCodeUnique(BaseMfrs baseMfrs);

    /**
     * 校验生产name是否唯一性
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */

    public String checkUpMfrsNameUnique(BaseMfrs baseMfrs);

    /**
     * 查询制造商
     *
     * @param baseMfrs 制造商信息
     * @return 制造商
     */
    public List<BaseMfrs> getMfrsOptionsList(BaseMfrs baseMfrs);

    /**
     * 查询制造商名称
     * @return 名称合集
     */
    public List<BaseMfrs> selectMfrsName();
}
