package com.jotime.web.service.base.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseCodeRuledtl;
import com.jotime.web.domain.base.BaseCodeRulevalue;
import com.jotime.web.domainVo.base.BaseCodeRuleVo;
import com.jotime.web.domainVo.base.BaseCodeRuledtlVo;
import com.jotime.web.domainVo.base.BaseCodeRulevalueVo;
import com.jotime.web.mapper.base.BaseCodeRuledtlMapper;
import com.jotime.web.mapper.base.BaseCodeRulevalueMapper;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jotime.web.mapper.base.BaseCodeRuleMapper;
import com.jotime.web.domain.base.BaseCodeRule;
import com.jotime.web.service.base.IBaseCodeRuleService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 编码规则Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
@Service
public class BaseCodeRuleServiceImpl implements IBaseCodeRuleService 
{
    @Autowired
    private BaseCodeRuleMapper baseCodeRuleMapper;
    @Autowired
    private BaseCodeRuledtlMapper baseCodeRuledtlMapper;
    @Autowired
    private BaseCodeRulevalueMapper baseCodeRulevalueMapper;

    /**
     * 查询编码规则
     * 
     * @param id 编码规则主键
     * @return 编码规则
     */
    @Override
    public BaseCodeRuleVo selectBaseCodeRuleById(Integer id)
    {
        return baseCodeRuleMapper.selectBaseCodeRuleById(id);
    }

    /**
     * 查询编码规则列表
     * 
     * @param baseCodeRule 编码规则
     * @return 编码规则
     */
    @Override
    public List<BaseCodeRuleVo> selectBaseCodeRuleList(BaseCodeRule baseCodeRule)
    {
        return baseCodeRuleMapper.selectBaseCodeRuleList(baseCodeRule);
    }

    /**
     * 新增编码规则
     * 
     * @param baseCodeRule 编码规则
     * @return 结果
     */
    @Override
    public int insertBaseCodeRule(BaseCodeRule baseCodeRule)
    {
        baseCodeRule.setCreateTime(DateUtils.getNowDate());
        baseCodeRule.setCreateBy(SecurityUtils.getUsername());
        return baseCodeRuleMapper.insertBaseCodeRule(baseCodeRule);
    }

    /**
     * 修改编码规则
     * 
     * @param baseCodeRule 编码规则
     * @return 结果
     */
    @Override
    public int updateBaseCodeRule(BaseCodeRule baseCodeRule)
    {
        baseCodeRule.setUpdateTime(DateUtils.getNowDate());
        return baseCodeRuleMapper.updateBaseCodeRule(baseCodeRule);
    }

    /**
     * 批量删除编码规则
     * 
     * @param ids 需要删除的编码规则主键
     * @return 结果
     */
    @Override
    public int deleteBaseCodeRuleByIds(Integer[] ids)
    {
        return baseCodeRuleMapper.deleteBaseCodeRuleByIds(ids);
    }

    /**
     * 删除编码规则信息
     * 
     * @param id 编码规则主键
     * @return 结果
     */
    @Override
    public int deleteBaseCodeRuleById(Integer id)
    {
        return baseCodeRuleMapper.deleteBaseCodeRuleById(id);
    }

    /**
     * 获取当前最新编码
     *
     * @param ruleNo 编码规则编号
     * @param paramMap 参数
     * @return arrRuleCodeRtn 结果 arrRuleCodeRtn[0]：success 成功 fail 失败
     *                            arrRuleCodeRtn[1]：message 返回消息
     *                            arrRuleCodeRtn[2]：成功返回编码值，失败为空
     */
    @Override
    @Transactional
    public String[] getCurRuleCode(String ruleNo, Map<String, Object> paramMap)
    {
        // 返回数组
        String[] arrRuleCodeRtn = new String[]{CodeRuleConstants.SUCCESS,"",""};

        // 编码规则编号为空场合
        if (StringUtils.isEmpty(ruleNo)) {
            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
            arrRuleCodeRtn[1] = "编码规则编号不能为空！";
            return arrRuleCodeRtn;
        }

        // 编码规则编号检验
        BaseCodeRule tmpCoderule = new BaseCodeRule();
        tmpCoderule.setRuleNo(ruleNo);
        tmpCoderule.setStatus(CodeRuleConstants.STATUS_OK);
        List<BaseCodeRuleVo> codeRuleVoList = baseCodeRuleMapper.selectBaseCodeRuleList(tmpCoderule);
        if (codeRuleVoList == null || codeRuleVoList.size() == 0) {
            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
            arrRuleCodeRtn[1] = "编码编号不正确！";
            return arrRuleCodeRtn;
        }

        BaseCodeRuledtl tmpCodeRuledtl = new BaseCodeRuledtl();
        tmpCodeRuledtl.setRuleId(codeRuleVoList.get(0).getId());
        tmpCodeRuledtl.setStatus(CodeRuleConstants.STATUS_OK);
        List<BaseCodeRuledtlVo> ruledtlVoList = baseCodeRuledtlMapper.selectRuledtVolListByRuleNo(tmpCodeRuledtl);
        if (ruledtlVoList == null && ruledtlVoList.size() == 0) {
            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
            arrRuleCodeRtn[1] = "编码编号：" + ruleNo + "在编码明细表对应的编码规则不存在！";
            return arrRuleCodeRtn;
        }

        // 根据编码规则编号获取当前的编码规则
        StringBuilder sbRuleCode = new StringBuilder("");
        boolean bSucFlg = true;
        String strRuleType = "";
        // 编码规则当前值更新数据list
        List<BaseCodeRulevalue> upCodeRulevalList = new ArrayList<BaseCodeRulevalue>();
        for (BaseCodeRuledtlVo ruledtlData : ruledtlVoList) {
            strRuleType = ruledtlData.getRuleType();
            switch (strRuleType) {
                case CodeRuleConstants.CONST:
                    // 编码组合
                    sbRuleCode.append(ruledtlData.getRuleParam());
                    break;
                case CodeRuleConstants.NUMBERING:
                    // 获取新的当前流水号
                    // 前缀值取得
                    String strPrefix = sbRuleCode.toString();
                    String[] arrRuleCodeNumRtn = getCurRuleCodeByNumberPart(strPrefix, ruledtlData);
                    // 获取成功
                    if (CodeRuleConstants.SUCCESS.equals(arrRuleCodeNumRtn[0])) {
                        // 填补字符取得
                        String strPadChar = ruledtlData.getPaddingChar();
                        if (StringUtils.isEmpty(strPadChar)) {
                            strPadChar = CodeRuleConstants.DEFAULT_PADDING_CHAR;
                        }

                        int ilengthc = ruledtlData.getPaddingLength().intValue();

                        // 编码组合
                        sbRuleCode.append(StringUtils.leftPad(arrRuleCodeNumRtn[2], ilengthc, strPadChar));

                        // 编码规则当前值更新数据设定
                        BaseCodeRulevalue codeRvalue = new BaseCodeRulevalue();
                        codeRvalue.setRuleId(ruledtlData.getRuleId());
                        codeRvalue.setRuleNumber(ruledtlData.getRuleNumber());
                        codeRvalue.setPrefix(strPrefix);
                        codeRvalue.setCurValue(Long.valueOf(arrRuleCodeNumRtn[2]));
                        upCodeRulevalList.add(codeRvalue);

                    } else {
                        bSucFlg = false;
                        arrRuleCodeRtn[1] = arrRuleCodeNumRtn[1];
                    }

                    break;
                case CodeRuleConstants.TIMESTAMP:
                    // 如果是时间戳，编码组合
                    sbRuleCode.append(DateUtils.dateTimeNow(ruledtlData.getRuleParam()));
                    break;
                case CodeRuleConstants.PARAM:
                    // 检验参数是否正确,如果正确返回参数的值
                    String[] arrRuleCodeParamRtn = checkCurRuleCodeParamPart(paramMap, ruledtlData);
                    // 获取成功
                    if (CodeRuleConstants.SUCCESS.equals(arrRuleCodeParamRtn[0])) {
                        // 编码里添加参数值
                        sbRuleCode.append(arrRuleCodeParamRtn[2]);
                    } else {
                        bSucFlg = false;
                        arrRuleCodeRtn[1] = arrRuleCodeParamRtn[1];
                    }

                    break;
                default:
                    break;
            }

            // 获取失败
            if (!bSucFlg) {
                break;
            }
        }

        // 成功取得场合, 对应数据表更新
        if (bSucFlg) {
            // codeRuleValue表更新
            if (upCodeRulevalList != null && upCodeRulevalList.size() > 0) {
                for (BaseCodeRulevalue ruleValueVoData : upCodeRulevalList) {
                    // 查询条件设置
                    BaseCodeRulevalue selCodeRvalue = new BaseCodeRulevalue();
                    selCodeRvalue.setRuleId(ruleValueVoData.getRuleId());
                    selCodeRvalue.setRuleNumber(ruleValueVoData.getRuleNumber());
                    selCodeRvalue.setPrefix(ruleValueVoData.getPrefix());

                    List<BaseCodeRulevalueVo> rulevalueList =  baseCodeRulevalueMapper.selectBaseCodeRulevalueList(selCodeRvalue);
                    if (rulevalueList == null || rulevalueList.size() == 0) {
                        // 插入处理
                        ruleValueVoData.setCreateBy(Constants.SYS_UPDATER);
                        baseCodeRulevalueMapper.insertBaseCodeRulevalue(ruleValueVoData);
                    } else {
                        // 更新处理
                        selCodeRvalue = new BaseCodeRulevalue();
                        selCodeRvalue.setId(rulevalueList.get(0).getId());
                        selCodeRvalue.setCurValue(ruleValueVoData.getCurValue());
                        selCodeRvalue.setUpdateBy(Constants.SYS_UPDATER);
                        baseCodeRulevalueMapper.updateBaseCodeRulevalue(selCodeRvalue);
                    }
                }
            }

            // 更新编码主体表的最新代码
            BaseCodeRule tmpCodeRule = new BaseCodeRule();
            tmpCodeRule.setId(codeRuleVoList.get(0).getId());
            tmpCodeRule.setCurCode(sbRuleCode.toString());
            baseCodeRuleMapper.updateBaseCodeRule(tmpCodeRule);

            // 返回值
            arrRuleCodeRtn[0] = CodeRuleConstants.SUCCESS;
            arrRuleCodeRtn[1] = "编码获取成功！";
            arrRuleCodeRtn[2] = sbRuleCode.toString();
        } else {
            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
        }

        return arrRuleCodeRtn;
    }

    /**
     * 获取当前最新流水号值
     *
     * @param prefix 前缀值
     * @param ruledtlData 对应参数数据
     * @return arrRuleCodeRtn 结果 arrRuleCodeRtn[0]：success 成功 fail 失败
     *                            arrRuleCodeRtn[1]：message 返回消息
     *                            arrRuleCodeRtn[2]：成功返回编码值，失败为空
     */
    private String[] getCurRuleCodeByNumberPart(String prefix, BaseCodeRuledtlVo ruledtlData)
    {
        // 返回数组
        String[] arrRuleCodeRtn = new String[]{CodeRuleConstants.SUCCESS,"",""};

        // 获取当前的流水号值
        // 新的当前值
        int iNewCurVal = 0;

        BaseCodeRulevalue codeRvalue = new BaseCodeRulevalue();
        codeRvalue.setRuleId(ruledtlData.getRuleId());
        codeRvalue.setRuleNumber(ruledtlData.getRuleNumber());
        codeRvalue.setPrefix(prefix);

        List<BaseCodeRulevalueVo> listRuleVal =  baseCodeRulevalueMapper.selectBaseCodeRulevalueList(codeRvalue);
        if (listRuleVal == null || listRuleVal.size() == 0) {
            iNewCurVal = ruledtlData.getInitValue();
        } else {
            iNewCurVal = listRuleVal.get(0).getCurValue().intValue() + ruledtlData.getStep();
        }

        // 计数（固定长度）场合
        int ilength = ruledtlData.getPaddingLength().intValue();
        if (String.valueOf(iNewCurVal).length() > ilength) {
            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
            arrRuleCodeRtn[1] = "新的流水号值为：" + iNewCurVal + ",已经超过既定的数值！";
        } else {
            // 填补字符取得
            String strPadChar = ruledtlData.getPaddingChar();
            if (StringUtils.isEmpty(strPadChar)) {
                strPadChar = CodeRuleConstants.DEFAULT_PADDING_CHAR;
            }

            arrRuleCodeRtn[0] = CodeRuleConstants.SUCCESS;
            arrRuleCodeRtn[1] = "编码获取成功！";
            // 固定长度补位
            arrRuleCodeRtn[2] = String.valueOf(iNewCurVal);
        }

        return arrRuleCodeRtn;
    }

    /**
     * 检验参数是否正确,如果正确返回参数的值
     *
     * @param paramMap 参数Map对象
     * @param ruledtlData 对应参数数据
     * @return arrRuleCodeRtn 结果 arrRuleCodeRtn[0]：success 成功 fail 失败
     *                            arrRuleCodeRtn[1]：message 返回消息
     *                            arrRuleCodeRtn[2]：成功返回参数，失败为空
     */
    private String[] checkCurRuleCodeParamPart(Map<String, Object> paramMap, BaseCodeRuledtlVo ruledtlData)
    {
        // 返回数组
        String[] arrRuleCodeRtn = new String[]{CodeRuleConstants.SUCCESS,"",""};
        // 参数场合
        if (StringUtils.isEmpty(paramMap)) {
            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
            arrRuleCodeRtn[1] = "Map参数不能未空！";
            return arrRuleCodeRtn;
        }

        // 获取参数key值
        String strParamKey = ruledtlData.getRuleParam();
        if (StringUtils.isEmpty(strParamKey)) {
            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
            arrRuleCodeRtn[1] = "系统对应参数key值未设置！";
            return arrRuleCodeRtn;
        }

        // 获取参数值
        String strParamVal = MapUtils.getString(paramMap, strParamKey);
        if (StringUtils.isEmpty(strParamVal)) {
            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
            arrRuleCodeRtn[1] = "参数Map里key值:" + strParamKey + "的值不能为空！";
            return arrRuleCodeRtn;
        }

//        // 长度校验
//        int ilength = ruledtlData.getPaddingLength().intValue();
//        if (ilength != strParamVal.length()) {
//            arrRuleCodeRtn[0] = CodeRuleConstants.FAIL;
//            arrRuleCodeRtn[1] = "参数Map里key值:" + strParamKey + "的值的长度不正确, 需要" + ilength + "位";
//            return arrRuleCodeRtn;
//        }

        // 参数value值
        arrRuleCodeRtn[2] = strParamVal;

        return arrRuleCodeRtn;
    }
}
