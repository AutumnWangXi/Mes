package com.jotime.web.service.base;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseGroup;
import com.jotime.web.domain.employee.EmployeeInfo;
import com.jotime.web.domainVo.base.BaseGroupVo;

import java.util.List;

/**
 * 班组Service接口
 *
 * @author ruoyi
 * @date 2022-03-01
 */
public interface IBaseGroupService
{
    /**
     * 查询班组
     *
     * @param id 班组主键
     * @return 班组
     */
    public BaseGroup selectBaseGroupById(Long id);
    /**
     * 查询班组
     *
     * @param id 班组主键
     * @return 班组
     */
    public BaseGroupVo selectBaseGroupVoById(Long id);

    /**
     * 查询班组列表
     *
     * @param baseGroup 班组
     * @return 班组集合
     */
    public List<BaseGroupVo> selectBaseGroupList(BaseGroup baseGroup);

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
     * 修改班组
     *
     * @param baseGroup 班组
     * @return 结果
     */
    public int updateBaseGroupVo(BaseGroupVo baseGroup);

    /**
     * 批量删除班组
     *
     * @param ids 需要删除的班组主键集合
     * @return 结果
     */
    public int deleteBaseGroupByIds(Long[] ids);

    /**
     * 删除班组信息
     *
     * @param id 班组主键
     * @return 结果
     */
    public int deleteBaseGroupById(Long id);
    /**
     * 获取车间对应班组列表
     */
    public List<BaseGroup> getWorkGroupList(Long workShopId);

    //    查询该班组生产订单的班组的负责人
    public EmployeeInfo selectGroupleader(String gpOrdertaskNo);

    BaseGroup selectBaseGroupuserBygroupName(String groupName);

    /**
     * 查询同部门班组数据
     */
    public AjaxResult selectDeptGroup(String depttaskNo, Long deptId);

}
