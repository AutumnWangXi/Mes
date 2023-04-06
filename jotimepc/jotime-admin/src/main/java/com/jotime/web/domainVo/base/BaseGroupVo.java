package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.web.domain.base.BaseGroup;

import java.util.List;

/**
 * @author hxh
 * @date 2022/3/1
 **/
public class BaseGroupVo extends BaseGroup {
	/**
	 * ID
	 */
	private static final long serialVersionUID = 1L;
	//班组负责人名称
    String groupLeaderName;
    //生产车间名称
    String workshopName;

    List<BaseGroupuserVo> baseGroupusers;
	String deptName;

	@TableField(exist = false)
	private List<String> userIds;

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	public String getGroupLeaderName() {
		return groupLeaderName;
	}
	public void setGroupLeaderName(String groupLeaderName) {
		this.groupLeaderName = groupLeaderName;
	}
	public String getWorkshopName() {
		return workshopName;
	}
	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<BaseGroupuserVo> getBaseGroupusers() {
		return baseGroupusers;
	}

	public void setBaseGroupusers(List<BaseGroupuserVo> baseGroupusers) {
		this.baseGroupusers = baseGroupusers;
	}
}
