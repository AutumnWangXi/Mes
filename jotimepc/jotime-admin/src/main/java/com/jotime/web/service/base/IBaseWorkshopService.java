package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.domainVo.base.BaseWorkshopVo;

import java.util.List;

/**
 * 车间Service接口
 *
 * @author ruoyi
 * @date 2021-12-31
 */
public interface IBaseWorkshopService {
    /**
     * 查询车间
     *
     * @param id 车间主键
     * @return 车间
     */
    public BaseWorkshop selectBaseWorkshopById(Long id);

    /**
     * 查询车间
     *
     * @param id 车间主键
     * @return 车间
     */
    public BaseWorkshopVo selectBaseWorkshopByIdData(Long id);

    /**
     * 查询车间列表
     *
     * @param baseWorkshop 车间
     * @return 车间集合
     */
    public List<BaseWorkshop> selectBaseWorkshopList(BaseWorkshop baseWorkshop);
    public List<BaseWorkshopVo> selectBaseWorkshopVoList(BaseWorkshop baseWorkshop);

    /**
     * 新增车间
     *
     * @param baseWorkshop 车间
     * @return 结果
     */
    public int insertBaseWorkshop(BaseWorkshop baseWorkshop);

    /**
     * 修改车间
     *
     * @param baseWorkshop 车间
     * @return 结果
     */
    public int updateBaseWorkshop(BaseWorkshop baseWorkshop);

    /**
     * 批量删除车间
     *
     * @param ids 需要删除的车间主键集合
     * @return 结果
     */
    public int deleteBaseWorkshopByIds(Long[] ids);

    /**
     * 删除车间信息
     *
     * @param id 车间主键
     * @return 结果
     */
    public int deleteBaseWorkshopById(Long id);

    /**
     * 根据部门id查询车间
     *
     * @param deptId 部门id
     * @return list
     * @author luoYang
     * @date 18:45 2022/1/6
     */
    List<BaseWorkshop> selectAllByDeptId(String deptId);

}
