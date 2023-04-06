package com.jotime.web.service.Apvl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.web.domain.Apvl.ApvlCommon;
import com.jotime.web.domainVo.apvl.ApvlCommonVo;

import java.util.List;

/**
 * 审批共通Service接口
 *
 * @author ruoyi
 * @date 2021-12-13
 */
public interface IApvlCommonService extends IService<ApvlCommon> {
    /**
     * 查询审批共通
     *
     * @param id 审批共通ID
     * @return 审批共通
     */
    public ApvlCommon selectApvlCommonById(Long id);

    /**
     * 查询审批共通列表
     *
     * @param apvlCommon 审批共通
     * @return 审批共通集合
     */
    public List<ApvlCommon> selectApvlCommonList(ApvlCommon apvlCommon);

    /**
     * 查询审批共通列表
     *
     * @param apvlCommonVo 审批共通
     * @return 审批共通集合
     */
    public List<ApvlCommon> selectApvlCommonVoList(ApvlCommonVo apvlCommonVo);

    /**
     * 新增审批共通
     *
     * @param apvlCommon 审批共通
     * @return 结果
     */
    public int insertApvlCommon(ApvlCommon apvlCommon);

    /**
     * 修改审批共通
     *
     * @param apvlCommon 审批共通
     * @return 结果
     */
    public int updateApvlCommon(ApvlCommon apvlCommon);

    /**
     * 批量删除审批共通
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteApvlCommonByIds(Long[] ids);

    /**
     * 删除审批共通信息
     *
     * @param id 审批共通ID
     * @return 结果
     */
    public int deleteApvlCommonById(Long id);


    /**
     * 根据审批编号查询信息
     *
     * @param applyNo 审批编号
     * @return
     */
    public ApvlCommon selectApvlCommonByApplyId(String applyNo);

    /**
     * 查询待处理数据
     * @param apvlCommonVo 查询参数
     * @return 待处理列表
     */
    public List<ApvlCommon> selectApvlCommonListByApplyList(ApvlCommonVo apvlCommonVo);

    /**
     * 查询待处理数据
     * @param apvlCommonVo 查询参数
     * @return 待处理列表
     */
    public List<ApvlCommon> selectPendingListByApvlType(ApvlCommonVo apvlCommonVo);


    /**
     * 查询当前登陆用户发起的申请
     *
     * @param apvlCommon 审批对象
     * @return 审批对象集合
     */
    List<ApvlCommon> selectInitiatedList(ApvlCommon apvlCommon);



}
