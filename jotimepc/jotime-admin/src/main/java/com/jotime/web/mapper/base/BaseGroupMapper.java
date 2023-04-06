package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseGroup;
import com.jotime.web.domain.employee.EmployeeInfo;
import com.jotime.web.domainVo.base.BaseGroupVo;

import java.util.List;


/**
 * 班组Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-01
 */
public interface BaseGroupMapper
{
    /**
     * 查询班组
     *
     * @param id 班组主键
     * @return 班组
     */
    public BaseGroup selectBaseGroupById(Long id);

    /**
     * 查询班组列表
     *
     * @param baseGroup 班组
     * @return 班组集合
     */
    public List<BaseGroup> selectBaseGroupList(BaseGroup baseGroup);
    public List<BaseGroupVo> selectBaseGroupVoList(BaseGroup baseGroup);

    /**
     * @Author zhengsj
     * @Description //根据员工code查询班组信息
     * @Date 2022/4/2 11:25
     * @Param [eeCode]
     * @return java.util.List<com.jotime.web.domain.base.BaseGroup>
     **/
    public List<BaseGroup> selectGroupList(String eeCode);

    /**
     * 新增班组
     *
     * @param baseGroup 班组
     * @return 结果
     */
    public int insertBaseGroup(BaseGroup baseGroup);

    /**
     * 修改班组
     *
     * @param baseGroup 班组
     * @return 结果
     */
    public int updateBaseGroup(BaseGroup baseGroup);

    /**
     * 删除班组
     *
     * @param id 班组主键
     * @return 结果
     */
    public int deleteBaseGroupById(Long id);

    /**
     * 批量删除班组
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseGroupByIds(Long[] ids);
    //    查询该班组生产订单的班组的负责人
    public EmployeeInfo selectGroupleader(String gpOrdertaskNo);

    BaseGroup selectBaseGroupuserBygroupName(String groupName);
}
