package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.domainVo.base.BaseWorkshopVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 车间Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-31
 */
public interface BaseWorkshopMapper {
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
    public BaseWorkshop selectBaseWorkshopByCode(String workshopCode);
/**
     * 查询车间
     *
     * @param workshopName
     * @return 车间
     */
    public BaseWorkshop checkWorkShopNameUnique(String workshopName);

    /**
     * 查询车间列表
     *
     * @param baseWorkshop 车间
     * @return 车间集合
     */
    public List<BaseWorkshop> selectBaseWorkshopList(BaseWorkshop baseWorkshop);
    public List<BaseWorkshopVo> selectBaseWorkshopVoList(BaseWorkshop baseWorkshop);
    /**
     * @Author zhengsj
     * @Description //根据角色查询车间信息
     * @Date 2022/6/29 16:07
     * @Param [baseWorkshop]
     * @return java.util.List<com.jotime.web.domainVo.base.BaseWorkshopVo>
     **/
    public List<BaseWorkshopVo> selectRoleBaseWorkshopList(BaseWorkshop baseWorkshop);

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
     * 删除车间
     *
     * @param id 车间主键
     * @return 结果
     */
    public int deleteBaseWorkshopById(Long id);

    /**
     * 批量删除车间
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseWorkshopByIds(Long[] ids);

    /**
     * 根据部门id查询车间
     *
     * @param deptId 部门id
     * @return list
     * @author luoYang
     * @date 18:45 2022/1/6
     */
    List<BaseWorkshop> selectAllByDeptId(@Param("deptId") String deptId);


    /**
     * 查询车间
     *
     * @param id 车间主键
     * @return 车间
     */
    public BaseWorkshopVo selectBaseWorkshopByIdData(Long id);
}
