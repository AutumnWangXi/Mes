package com.jotime.web.service.base.impl;

import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseDevice;
import com.jotime.web.domain.base.BaseDeviceType;
import com.jotime.web.domain.base.BaseDeviceTypedtl;
import com.jotime.web.domainVo.excel.BaseDeviceTypeExlVo;
import com.jotime.web.mapper.base.BaseDeviceMapper;
import com.jotime.web.mapper.base.BaseDeviceTypeMapper;
import com.jotime.web.mapper.base.BaseDeviceTypedtlMapper;
import com.jotime.web.service.base.IBaseDeviceTypeService;
import com.jotime.web.service.base.IBaseDeviceTypedtlService;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 设备类型Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-02
 */
@Service
public class BaseDeviceTypeServiceImpl implements IBaseDeviceTypeService
{
    @Autowired
    private BaseDeviceTypeMapper baseDeviceTypeMapper;
    @Autowired
    private IBaseDeviceTypedtlService iBaseDeviceTypedtlService;
    @Autowired
    private BaseDeviceMapper baseDeviceMapper;
    @Autowired
    private BaseDeviceTypedtlMapper baseDeviceTypedtlMapper;
    /**
     * 查询设备类型
     *
     * @param id 设备类型主键
     * @return 设备类型
     */
    @Override
    public BaseDeviceType selectBaseDeviceTypeById(Long id)
    {
        return baseDeviceTypeMapper.selectBaseDeviceTypeById(id);
    }

    /**
     * 查询设备类型列表
     *
     * @param baseDeviceType 设备类型
     * @return 设备类型
     */
    @Override
    public List<BaseDeviceType> selectBaseDeviceTypeList(BaseDeviceType baseDeviceType)
    {
        return baseDeviceTypeMapper.selectBaseDeviceTypeList(baseDeviceType);
    }

    /**
     * 新增设备类型
     *
     * @param baseDeviceType 设备类型
     * @return 结果
     */
    @Override
    public int insertBaseDeviceType(BaseDeviceType baseDeviceType)
    {
        BaseDeviceType baseDeviceType1 = new BaseDeviceType();
        baseDeviceType1.setDeviceType(baseDeviceType.getDeviceType());
        List<BaseDeviceType> baseDeviceTypes = baseDeviceTypeMapper.selectBaseDeviceTypeList(baseDeviceType1);
        if (baseDeviceTypes.size()>0){
            return -1;
        }
        baseDeviceType.setCreateTime(DateUtils.getNowDate());
        baseDeviceType.setCreateBy(SecurityUtils.getUserId().toString());
        return baseDeviceTypeMapper.insertBaseDeviceType(baseDeviceType);
    }

    /**
     * 修改设备类型
     *
     * @param baseDeviceType 设备类型
     * @return 结果
     */

    @Override
    public int updateBaseDeviceType(BaseDeviceType baseDeviceType)
    {
        BaseDeviceType tempBean = baseDeviceTypeMapper.selectBaseDeviceTypeById(baseDeviceType.getId());
        BaseDeviceType baseDeviceType1 = new BaseDeviceType();
        baseDeviceType1.setDeviceType(baseDeviceType.getDeviceType());
        List<BaseDeviceType> baseDeviceTypes = baseDeviceTypeMapper.selectBaseDeviceTypeList(baseDeviceType1);
//        判断数据库是否已有
        if (baseDeviceTypes.size()>0&&!baseDeviceType.getId().equals(baseDeviceTypes.get(0).getId())){
            return -1;
        }
//        如果设备类型有改动
        if (!tempBean.getDeviceType().equals(baseDeviceType.getDeviceType())){
            BaseDeviceTypedtl baseDeviceTypedtl = new BaseDeviceTypedtl();
            baseDeviceTypedtl.setDeviceType(tempBean.getDeviceType());
//        需要修改的设备小类别并修改类型
            List<BaseDeviceTypedtl> baseDeviceTypedtls = iBaseDeviceTypedtlService.selectBaseDeviceTypedtlList(baseDeviceTypedtl);
            for (BaseDeviceTypedtl deviceTypedtl : baseDeviceTypedtls) {
                deviceTypedtl.setDeviceType(baseDeviceType.getDeviceType());
                iBaseDeviceTypedtlService.updateBaseDeviceTypedtl(deviceTypedtl);
            }
        }

        baseDeviceType.setUpdateTime(DateUtils.getNowDate());
        baseDeviceType.setUpdateBy(SecurityUtils.getUserId().toString());
        return baseDeviceTypeMapper.updateBaseDeviceType(baseDeviceType);
    }

    /**
     * 批量删除设备类型
     *
     * @param ids 需要删除的设备类型主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBaseDeviceTypeByIds(Long[] ids)
    {
//      循环删除设备类型对应的小分类
        for (int i = 0; i < ids.length; i++) {
            BaseDeviceType baseDeviceType = baseDeviceTypeMapper.selectBaseDeviceTypeById(ids[i]);
            BaseDeviceTypedtl baseDeviceTypedtl = new BaseDeviceTypedtl();
            baseDeviceTypedtl.setDeviceType(baseDeviceType.getDeviceType());
            List<BaseDeviceTypedtl> baseDeviceTypedtls = iBaseDeviceTypedtlService.selectBaseDeviceTypedtlList(baseDeviceTypedtl);
            Integer[] baseDeviceTypedtlIds = new Integer[baseDeviceTypedtls.size()];
            for (int j= 0; j < baseDeviceTypedtls.size(); j++) {
                baseDeviceTypedtlIds[j] = baseDeviceTypedtls.get(j).getId();
            }
            //如果对应的小分类有数据，则删除
            if (baseDeviceTypedtlIds.length>0){
                iBaseDeviceTypedtlService.deleteBaseDeviceTypedtlByIds(baseDeviceTypedtlIds);
            }
        }
        return baseDeviceTypeMapper.deleteBaseDeviceTypeByIds(ids);
    }
    /**
     * 禁用设备类型
     *
     * @param ids 需要禁用的设备类型主键集合
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int disableBaseDeviceTypeByIds(Long[] ids){
//        修改返回的结果
        int results = 0;
//        根据数组长度循环修改
        for (int i = 0; i < ids.length; i++) {
            BaseDeviceType baseDeviceType = baseDeviceTypeMapper.selectBaseDeviceTypeById(ids[i]);
            baseDeviceType.setStatus(CodeRuleConstants.STATUS_DISABLED);
            baseDeviceType.setUpdateBy(SecurityUtils.getUserId().toString());
            baseDeviceType.setUpdateTime(DateUtils.getNowDate());
//            更新baseDeviceType
            results+=baseDeviceTypeMapper.updateBaseDeviceType(baseDeviceType);
            BaseDeviceTypedtl baseDeviceTypedtl = new BaseDeviceTypedtl();
            baseDeviceTypedtl.setDeviceType(baseDeviceType.getDeviceType());
            List<BaseDeviceTypedtl> baseDeviceTypedtls = iBaseDeviceTypedtlService.selectBaseDeviceTypedtlList(baseDeviceTypedtl);
//            更新baseDeviceType对应的baseDeviceTypedtl表数据
            for (int j = 0; j < baseDeviceTypedtls.size(); j++) {
                BaseDeviceTypedtl baseDeviceTypedtl1 = baseDeviceTypedtls.get(j);
                baseDeviceTypedtl1.setStatus(CodeRuleConstants.STATUS_DISABLED);
                baseDeviceTypedtl1.setUpdateBy(SecurityUtils.getUserId().toString());
                baseDeviceTypedtl1.setUpdateTime(DateUtils.getNowDate());
                iBaseDeviceTypedtlService.updateBaseDeviceTypedtl(baseDeviceTypedtl1);
            }
        }
        return results;
    }
    /**
     * 删除设备类型信息
     *
     * @param id 设备类型主键
     * @return 结果
     */
    @Override
    public int deleteBaseDeviceTypeById(Long id)
    {
//      删除设备类型对应的小分类
        BaseDeviceType baseDeviceType = baseDeviceTypeMapper.selectBaseDeviceTypeById(id);
        BaseDeviceTypedtl baseDeviceTypedtl = new BaseDeviceTypedtl();
        baseDeviceTypedtl.setDeviceType(baseDeviceType.getDeviceType());
        List<BaseDeviceTypedtl> baseDeviceTypedtls = iBaseDeviceTypedtlService.selectBaseDeviceTypedtlList(baseDeviceTypedtl);
        Integer[] baseDeviceTypedtlIds = new Integer[baseDeviceTypedtls.size()];
        for (int i = 0; i < baseDeviceTypedtls.size(); i++) {
            baseDeviceTypedtlIds[i] = baseDeviceTypedtls.get(i).getId();
        }
        //如果对应的小分类有数据，则删除
        if (baseDeviceTypedtlIds.length>0){
            iBaseDeviceTypedtlService.deleteBaseDeviceTypedtlByIds(baseDeviceTypedtlIds);
        }
        return baseDeviceTypeMapper.deleteBaseDeviceTypeById(id);
    }

    /**
     * 查询可用设备类型列表
     * @return 可用设备类型列表
     */
    @Override
    public List<BaseDeviceType> selectBaseDeviceTypeAvailableList(){
        BaseDeviceType baseDeviceType = new BaseDeviceType();
        baseDeviceType.setStatus(CodeRuleConstants.STATUS_OK);
        return baseDeviceTypeMapper.selectBaseDeviceTypeList(baseDeviceType);
    }

    /**
     * @Description: 设备类型导入
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult importData(List<BaseDeviceTypeExlVo> baseDeviceTypeExlVos, boolean updateSupport) {
        //业务判断
        String s = importDataJudge(baseDeviceTypeExlVos);
        if(!"".equals(s)){
            return AjaxResult.error(s);
        }
        try {
            List<BaseDeviceTypeExlVo> objects = new ArrayList<>();
            //过滤(插入的类型)
            List<BaseDeviceTypeExlVo> baseDeviceTypeExlVoList = baseDeviceTypeExlVos.stream()
                    .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(u -> u.getDeviceType()))), ArrayList::new));
            for (BaseDeviceTypeExlVo item:baseDeviceTypeExlVos){
                if(StringUtils.isNotNull(item.getTypeLabel())&&!"".equals(item.getTypeLabel())){
                    objects.add(item);
                }
            }
            //过滤(插入的类型明细)
            List<BaseDeviceTypeExlVo> baseDeviceTypeExlVoArrayList = objects.stream()
                    .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(u -> u.getDeviceType() + ";" + u.getTypeLabel()))), ArrayList::new));
            //整理数据(类型)
            for (BaseDeviceTypeExlVo item : baseDeviceTypeExlVoList) {
                BaseDeviceType baseDeviceType = baseDeviceTypeMapper.selectBaseDeviceTypeByDeviceType(getPinYinHeadChar(item.getDeviceType()));
                //查询数据库是否有该类型
                if (StringUtils.isNotNull(baseDeviceType)) {
                    continue;
                }
                BaseDeviceType deviceType = new BaseDeviceType();
                deviceType.setDeviceType(getPinYinHeadChar(item.getDeviceType()));
                //设置汉字首字母为别名
                deviceType.setDeviceTypeName(item.getDeviceType());
                //正常
                deviceType.setStatus(Constants.STATUS_OK);
                deviceType.setCreateBy(SecurityUtils.getUsername());
                deviceType.setCreateTime(DateUtils.getNowDate());
                //插入类型数据
                baseDeviceTypeMapper.insertBaseDeviceType(deviceType);
            }
            //整理数据(类型明细)
            for (BaseDeviceTypeExlVo item : baseDeviceTypeExlVoArrayList) {
                //是否已经存在了
                int i = baseDeviceTypedtlMapper.selectTypeValues(getPinYinHeadChar(item.getDeviceType()), item.getTypeLabel());
                //查询数据库是否有该类型明细
                if (Constants.ONE.equals(i)) {
                    continue;
                } else if (!Constants.ZERO.equals(i)) {
                    AjaxResult.error("数据错误");
                }
                BaseDeviceTypedtl baseDeviceTypedtl = new BaseDeviceTypedtl();
                baseDeviceTypedtl.setDeviceType(getPinYinHeadChar(item.getDeviceType()));
                //查看有几条数据
                int j = baseDeviceTypedtlMapper.selectTypeValueByDeviceType(getPinYinHeadChar(item.getDeviceType()));
                baseDeviceTypedtl.setTypeSort(j + 1);
                baseDeviceTypedtl.setTypeLabel(item.getTypeLabel());
                baseDeviceTypedtl.setTypeValue(String.valueOf((j + 1)));
                //正常
                baseDeviceTypedtl.setStatus(Constants.STATUS_OK);
                baseDeviceTypedtl.setCreateBy(SecurityUtils.getUsername());
                baseDeviceTypedtl.setCreateTime(DateUtils.getNowDate());
                //插入类型数据
                baseDeviceTypedtlMapper.insertBaseDeviceTypedtl(baseDeviceTypedtl);
            }
            int row=1;
            //导入的数据
            for (BaseDeviceTypeExlVo item : baseDeviceTypeExlVos){
                row++;
                //设备数据
                BaseDevice baseDevice = baseDeviceMapper.selectBaseDeviceByDeviceCode(item.getDeviceCode());
                if(StringUtils.isNull(baseDevice)){
                    AjaxResult.error( "第"+row+"行设备数据的编码数据不存在，请重新确认！");
                }
                BaseDeviceType baseDeviceType = baseDeviceTypeMapper.selectBaseDeviceTypeByDeviceType(getPinYinHeadChar(item.getDeviceType()));
                if(StringUtils.isNull(baseDeviceType)){
                    AjaxResult.error( "第"+row+"行设备数据的类型数据不存在，请重新确认！");
                }
                baseDeviceTypedtlMapper.selectTypeValues(getPinYinHeadChar(item.getDeviceType()),item.getTypeLabel());
                if(StringUtils.isNull(baseDeviceType)){
                    AjaxResult.error( "第"+row+"行设备数据的类型明细数据不存在，请重新确认！");
                }
                baseDevice.setDeviceType(getPinYinHeadChar(item.getDeviceType()));
                baseDevice.setDeviceGroup(item.getTypeLabel());
                baseDeviceMapper.updateBaseDevice(baseDevice);
            }

        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据异常，数据回滚");
        }
        return AjaxResult.success("数据导入成功");
    }

    /**
     * 返回中文的首字母
     *
     * @param str
     * @return
     */
    public static String getPinYinHeadChar(String str) {

        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert.toUpperCase();
    }

    /**
     * @Description: 导入设备类型数据判断
     */
    public String importDataJudge(List<BaseDeviceTypeExlVo> baseDeviceTypeExlVos) {
        String strErrMsg = "";
        if (StringUtils.isEmpty(baseDeviceTypeExlVos)) {
            return "导入原料信息不能为空！";
        }

        int iRowNo = 1;
        boolean bChkFlg = false;
        for (BaseDeviceTypeExlVo baseDeviceTypeExlVo : baseDeviceTypeExlVos) {
            iRowNo++;

            baseDeviceTypeExlVo.setDeviceCode(StringUtils.trim(baseDeviceTypeExlVo.getDeviceCode()));
            if (StringUtils.isEmpty(baseDeviceTypeExlVo.getDeviceCode())) {
                if (!bChkFlg || !baseDeviceTypeExlVo.getMergeFlag()) {
                    if (StringUtils.isEmpty(baseDeviceTypeExlVo.getDeviceCode())) {
                        strErrMsg = "第" + iRowNo + "行的设备编码不能为空，请确认！";
                        break;
                    }
                }
            }

            bChkFlg = baseDeviceTypeExlVo.getMergeFlag();

            if (StringUtils.isEmpty(baseDeviceTypeExlVo.getDeviceType())) {
                strErrMsg = "第" + iRowNo + "行的设备类型不能为空，请确认！";
                break;
            }
        }

        if (StringUtils.isNotEmpty(strErrMsg)) {
            return strErrMsg;
        }

        // 业务校验
        iRowNo =1;
        //数据判断
        for (BaseDeviceTypeExlVo baseDeviceTypeExlVo : baseDeviceTypeExlVos) {
            iRowNo++;
            BaseDevice baseDevice = baseDeviceMapper.selectBaseDeviceByDeviceCode(baseDeviceTypeExlVo.getDeviceCode());
            if (StringUtils.isNull(baseDevice)) {
                strErrMsg = "第" + iRowNo + "行,设备编号：" + baseDeviceTypeExlVo.getDeviceCode() + " 的设备信息不存在，请确认后再导入！";
                break;
            }
        }
        return strErrMsg;
    }

    /**
     * @Description: 添加类型
     */
    public void addBaseDeviceType(List<BaseDeviceTypeExlVo> baseDeviceTypeExlVos) {
    }
    /**
     * @Description: 添加类型明细
     */
    public void addBaseDeviceTypeDtl(List<BaseDeviceTypeExlVo> baseDeviceTypeExlVos) {
    }

}
