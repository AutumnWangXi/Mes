package com.jotime.web.mapper.base;


import com.jotime.web.domain.base.BaseGroupuser;
import com.jotime.web.domainVo.base.BaseGroupuserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 班组人员管理Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-01
 */
public interface BaseGroupuserMapper
{
    /**
     * 查询班组人员管理
     *
     * @param id 班组人员管理主键
     * @return 班组人员管理
     */
    public BaseGroupuser selectBaseGroupuserById(Integer id);

    /**
     * 查询班组人员管理列表
     *
     * @param baseGroupuser 班组人员管理
     * @return 班组人员管理集合
     */
    public List<BaseGroupuser> selectBaseGroupuserList(BaseGroupuser baseGroupuser);
    /**
     * 查询班组人员管理列表
     *
     * @param baseGroupuser 班组人员管理
     * @return 班组人员管理集合
     */
    public List<BaseGroupuserVo> selectBaseGroupuserVoList(BaseGroupuser baseGroupuser);

    /**
     * 新增班组人员管理
     *
     * @param baseGroupuser 班组人员管理
     * @return 结果
     */
    public int insertBaseGroupuser(BaseGroupuser baseGroupuser);

    /**
     * 修改班组人员管理
     *
     * @param baseGroupuser 班组人员管理
     * @return 结果
     */
    public int updateBaseGroupuser(BaseGroupuser baseGroupuser);

    /**
     * 删除班组人员管理
     *
     * @param id 班组人员管理主键
     * @return 结果
     */
    public int deleteBaseGroupuserById(Integer id);

    /**
     * 批量删除班组人员管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseGroupuserByIds(Integer[] ids);

    /**
     * 查询该班组下是否有该人员信息
     *
     * @param groupId 班组
     * @param getId 用户id
     * @return 结果
     */
    BaseGroupuser selelctByGroupId(@Param("groupId") Long groupId,@Param("getId") Long getId);

    /**
     * 查询该班组下有几个员工
     *
     * @param groupId 班组
     * @param groupId 用户id
     * @return 结果
     */
    int selelctByGroupIds(Long groupId);

    /**
     * @Description 判断是否在别的班组工作
     * @auther by 14812
     */
    BaseGroupuserVo selelctByUserId(@Param("groupId") Long groupId,@Param("getId") Long getId);

    /**
     * @Description 修改班组人员状态
     * @auther by 14812
     */
    int updateBaseGroupuserByGroupId(@Param("groupId") Long groupId,@Param("getId") Long getId);
}
