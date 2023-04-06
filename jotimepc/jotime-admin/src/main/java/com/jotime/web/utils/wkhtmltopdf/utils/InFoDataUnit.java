package com.jotime.web.utils.wkhtmltopdf.utils;

import com.jotime.common.core.domain.entity.SysDept;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.system.service.ISysDeptService;
import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.domain.employee.EmployeeInfo;
import com.jotime.web.service.base.IBaseWorkshopService;
import com.jotime.web.service.employee.IEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: chenkuo
 * @Date: 2022/04/27/14:15
 * @Description:
 */
@Component
public class InFoDataUnit {
    private static InFoDataUnit inFoDataUnit;

    @PostConstruct
    public void init() {
        inFoDataUnit = this;
        inFoDataUnit.iEmployeeInfoService = this.iEmployeeInfoService;
        inFoDataUnit.iBaseWorkshopService = this.iBaseWorkshopService;
        inFoDataUnit.iSysDeptService = this.iSysDeptService;
    }

    @Autowired
    private IEmployeeInfoService iEmployeeInfoService;
    @Autowired
    private IBaseWorkshopService iBaseWorkshopService;
    @Autowired
    private ISysDeptService iSysDeptService;

    /**
     * 获取当前员工所属车间
     *
     * @return 车间内码
     */
    public static Map<Boolean, Long> workShopInfo() {
        Map<Boolean, Long> map = new HashMap<>();
        EmployeeInfo employeeInfo = inFoDataUnit.iEmployeeInfoService.selectEmployeeInfoByEmployeeCode(SecurityUtils.getEeCode());
        if (StringUtils.isNotNull(employeeInfo)) {
            if (StringUtils.isNotNull(employeeInfo.getWorkshopId())) {
                map.put(true, employeeInfo.getWorkshopId());
            } else {
                map.put(false, employeeInfo.getDeptId());
            }
        } else {
            map.put(true, -1000L);
        }
        return map;
    }

    /**
     * 获取当前登录用户的权限数据
     *
     * @return 结果数据
     */
    public static Map<Boolean, List<Long>> getSubDepartments() {
        Map<Boolean, List<Long>> map = new HashMap<>();
        Long deptId = SecurityUtils.getDeptId();
        SysDept sysDept = new SysDept();
        sysDept.setAncestors(String.valueOf(deptId));
        //部门数据
        List<SysDept> sysDepts = inFoDataUnit.iSysDeptService.selectDeptList(sysDept);
        //员工信息
        EmployeeInfo employeeInfo = inFoDataUnit.iEmployeeInfoService.selectEmployeeInfoByEmployeeCode(SecurityUtils.getEeCode());
        List<Long> idList = new ArrayList<>();
        if (StringUtils.isNotNull(employeeInfo)) {
            if (StringUtils.isNotNull(employeeInfo.getWorkshopId())) {
                idList.add(employeeInfo.getWorkshopId());
                map.put(true, idList);
            } else {
                if (StringUtils.isNotEmpty(sysDepts)) {
                    idList.add(deptId);
                    sysDepts.forEach(obj -> {
                        idList.add(obj.getDeptId());
                    });
                    map.put(false, idList);
                }
            }
        } else {
            idList.add(-10000L);
            map.put(true, idList);
        }
        return map;
    }

    /**
     * 查询所有车间信息
     *
     * @return 车间列表
     */
    public static List<BaseWorkshop> workShopList(BaseWorkshop baseWorkshop) {
        return inFoDataUnit.iBaseWorkshopService.selectBaseWorkshopList(baseWorkshop);
    }
}
