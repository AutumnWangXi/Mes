package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseDevicePp;
import com.jotime.web.domain.base.BaseDevicePpdtl;
import com.jotime.web.domainVo.base.BaseDevicePpVo;
import com.jotime.web.mapper.base.BaseDevicePpMapper;
import com.jotime.web.service.base.IBaseDevicePpService;
import com.jotime.web.service.base.IBaseDevicePpdtlService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 设备工艺参数Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Service
public class BaseDevicePpServiceImpl implements IBaseDevicePpService
{
    @Autowired
    private BaseDevicePpMapper baseDevicePpMapper;
    @Autowired
    private IBaseDevicePpdtlService iBaseDevicePpdtlService;
    /**
     * 查询设备工艺参数
     *
     * @param id 设备工艺参数主键
     * @return 设备工艺参数
     */
    @Override
    public BaseDevicePp selectBaseDevicePpById(Long id)
    {
        return baseDevicePpMapper.selectBaseDevicePpById(id);
    }

    /**
     * 查询设备工艺参数列表
     *
     * @param baseDevicePp 设备工艺参数
     * @return 设备工艺参数
     */
    @Override
    public List<BaseDevicePp> selectBaseDevicePpList(BaseDevicePp baseDevicePp)
    {
        return baseDevicePpMapper.selectBaseDevicePpList(baseDevicePp);
    }
    /**
     * 查询设备工艺参数列表
     *
     * @param baseDevicePp 设备工艺参数
     * @return 设备工艺参数
     */
    @Override
    public List<BaseDevicePpVo> selectBaseDevicePpVoList(BaseDevicePp baseDevicePp)
    {
        return baseDevicePpMapper.selectBaseDevicePpVoList(baseDevicePp);
    }

    /**
     * 新增设备工艺参数
     *
     * @param baseDevicePp 设备工艺参数
     * @return 结果
     */
    @Override
    public int insertBaseDevicePp(BaseDevicePp baseDevicePp)
    {
        baseDevicePp.setCreateTime(DateUtils.getNowDate());
        return baseDevicePpMapper.insertBaseDevicePp(baseDevicePp);
    }

    /**
     * 修改设备工艺参数
     *
     * @param baseDevicePp 设备工艺参数
     * @return 结果
     */
    @Override
    public int updateBaseDevicePp(BaseDevicePp baseDevicePp)
    {
        baseDevicePp.setUpdateTime(DateUtils.getNowDate());
        return baseDevicePpMapper.updateBaseDevicePp(baseDevicePp);
    }

    /**
     * 批量删除设备工艺参数
     *
     * @param ids 需要删除的设备工艺参数主键
     * @return 结果
     */
    @Override
    public int deleteBaseDevicePpByIds(Long[] ids)
    {
        return baseDevicePpMapper.deleteBaseDevicePpByIds(ids);
    }

    /**
     * 删除设备工艺参数信息
     *
     * @param id 设备工艺参数主键
     * @return 结果
     */
    @Override
    public int deleteBaseDevicePpById(Long id)
    {
        return baseDevicePpMapper.deleteBaseDevicePpById(id);
    }

    /**
     * 新增设备工艺参数和详细信息
     *
     * @param baseDevicePpVo 设备工艺参数
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertBaseDevicePpdtl(BaseDevicePpVo baseDevicePpVo){
//        判断工艺组名是否为空
        if (StringUtils.isNotEmpty(baseDevicePpVo.getGroupName())){
            BaseDevicePp baseDevicePp = new BaseDevicePp();
            baseDevicePp.setDeviceId(baseDevicePpVo.getDeviceId());
            baseDevicePp.setGroupName(baseDevicePpVo.getGroupName());
//            查询是否已有该设备该工艺组名的数据
            List<BaseDevicePp> baseDevicePps = baseDevicePpMapper.selectBaseDevicePpList(baseDevicePp);
            if (baseDevicePps.size()>0){
                List<BaseDevicePpdtl> baseDevicePpdtls = baseDevicePpVo.getBaseDevicePpdtls();
//                插入dtl数据
                baseDevicePpdtls.forEach((baseDevicePpdtl)->{
                    baseDevicePpdtl.setCreateTime(DateUtils.getNowDate());
                    baseDevicePpdtl.setUpdateTime(DateUtils.getNowDate());
                    baseDevicePpdtl.setCreateBy(SecurityUtils.getUserId().toString());
                    baseDevicePpdtl.setDeviceId(baseDevicePpVo.getDeviceId());
                    baseDevicePpdtl.setGroupId(baseDevicePps.get(0).getId().toString());
                    iBaseDevicePpdtlService.insertBaseDevicePpdtl(baseDevicePpdtl);
                });
                return 1;
//             查询是否已有该设备该工艺组名的数据，没有，第一次添加操作
            }else {
                BaseDevicePp baseDevicePp1 = new BaseDevicePp();
//                对象属性拷贝
                BeanUtils.copyProperties(baseDevicePpVo,baseDevicePp1);
                baseDevicePp1.setCreateBy(SecurityUtils.getUserId().toString());
                baseDevicePp1.setCreateTime(DateUtils.getNowDate());
//                插入数据
                baseDevicePpMapper.insert(baseDevicePp1);
                List<BaseDevicePpdtl> baseDevicePpdtls = baseDevicePpVo.getBaseDevicePpdtls();
//                插入dtl数据
                baseDevicePpdtls.forEach((baseDevicePpdtl)->{
                    baseDevicePpdtl.setCreateTime(DateUtils.getNowDate());
                    baseDevicePpdtl.setUpdateTime(DateUtils.getNowDate());
                    baseDevicePpdtl.setCreateBy(SecurityUtils.getUserId().toString());
                    baseDevicePpdtl.setDeviceId(baseDevicePpVo.getDeviceId());
                    baseDevicePpdtl.setGroupId(baseDevicePp1.getId().toString());
                    iBaseDevicePpdtlService.insertBaseDevicePpdtl(baseDevicePpdtl);
                });
                return 1;
            }
        }
        return -1;
    }
}
