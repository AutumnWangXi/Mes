package com.jotime.web.service.Apvl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.constant.ApvlStatusConstants;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.domain.entity.SysUser;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.joTime.ApplyStatus;
import com.jotime.system.service.ISysUserService;
import com.jotime.web.domain.Apvl.ApvlCommon;
import com.jotime.web.domainVo.apvl.ApvlCommonVo;
import com.jotime.web.mapper.Apvl.ApvlCommonMapper;
import com.jotime.web.service.Apvl.IApvlCommonService;
import com.jotime.web.service.file.IFileManageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


/**
 * 审批共通Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-13
 */
@Service
public class ApvlCommonServiceImpl extends ServiceImpl<ApvlCommonMapper, ApvlCommon> implements IApvlCommonService {
    @Autowired
    private ApvlCommonMapper apvlCommonMapper;
    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private IFileManageService iFileManageService;


    /**
     * 查询审批共通
     *
     * @param id 审批共通ID
     * @return 审批共通
     */
    @Override
    public ApvlCommon selectApvlCommonById(Long id) {
        return apvlCommonMapper.selectApvlCommonById(id);
    }

    /**
     * 查询审批共通列表
     *
     * @param apvlCommon 审批共通
     * @return 审批共通
     */
    @Override
    public List<ApvlCommon> selectApvlCommonList(ApvlCommon apvlCommon) {
        return apvlCommonMapper.selectApvlCommonList(apvlCommon);
    }

    /**
     * 查询审批共通列表
     *
     * @param apvlCommonVo 审批共通
     * @return 审批共通集合
     */
    @Override
    public List<ApvlCommon> selectApvlCommonVoList(ApvlCommonVo apvlCommonVo) {
        if (StringUtils.isNotNull(apvlCommonVo)) {
            if (!StringUtils.isNotEmpty(apvlCommonVo.getApvlNoList())) {
                return Collections.emptyList();
            } else {
                return apvlCommonMapper.selectApvlCommonVoList(apvlCommonVo);
            }
        } else {
            return Collections.emptyList();
        }
    }


    /**
     * 新增审批共通
     *
     * @param apvlCommon 审批共通
     * @return 结果
     */
    @Override
    public int insertApvlCommon(ApvlCommon apvlCommon) {
        apvlCommon.setCreateBy(SecurityUtils.getUsername());
        return apvlCommonMapper.insertApvlCommon(apvlCommon);
    }

    /**
     * 修改审批共通
     *
     * @param apvlCommon 审批共通
     * @return 结果
     */
    @Override
    public int updateApvlCommon(ApvlCommon apvlCommon) {
        return apvlCommonMapper.updateApvlCommon(apvlCommon);
    }

    /**
     * 删除审批共通对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteApvlCommonByIds(Long[] ids) {
        return apvlCommonMapper.deleteApvlCommonByIds(ids);
    }

    /**
     * 删除审批共通信息
     *
     * @param id 审批共通ID
     * @return 结果
     */
    @Override
    public int deleteApvlCommonById(Long id) {
        return apvlCommonMapper.deleteApvlCommonById(id);
    }

    /**
     * 根据审批编号查询信息
     *
     * @param applyNo 审批编号
     * @return 列表数据
     */
    @Override
    public ApvlCommon selectApvlCommonByApplyId(String applyNo) {
        return apvlCommonMapper.selectApvlCommonByApplyId(applyNo);
    }

    /**
     * 查询待处理数据
     *
     * @param apvlCommonVo 审批编号
     * @return 待处理列表
     */
    @Override
    public List<ApvlCommon> selectApvlCommonListByApplyList(ApvlCommonVo apvlCommonVo) {
        return apvlCommonMapper.selectApvlCommonListByApplyList(apvlCommonVo);
    }

    /**
     * 查询待处理数据
     *
     * @param apvlCommonVo 查询参数
     * @return 待处理列表
     */
    @Override
    public List<ApvlCommon> selectPendingListByApvlType(ApvlCommonVo apvlCommonVo) {
        return apvlCommonMapper.selectPendingListByApvlType(apvlCommonVo);

    }


    /**
     * 查询申请记录
     *
     * @param apvlCommon 申请共通
     * @return 申请记录
     */
    @Override
    public List<ApvlCommon> selectInitiatedList(ApvlCommon apvlCommon) {
        return apvlCommonMapper.selectInitiatedList(apvlCommon);
    }

}






