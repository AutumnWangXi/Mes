package com.jotime.web.service.base.impl;

import java.util.List;

import com.jotime.common.constant.BrandConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.MfrsConstants;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseMfrs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jotime.web.mapper.base.BaseBrandMapper;
import com.jotime.web.domain.base.BaseBrand;
import com.jotime.web.service.base.IBaseBrandService;

/**
 * 生产商品牌Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
@Service
public class BaseBrandServiceImpl implements IBaseBrandService 
{
    @Autowired
    private BaseBrandMapper baseBrandMapper;

    /**
     * 查询生产商品牌信息
     * 
     * @param id 生产商品牌主键
     * @return 生产商品牌信息
     */
    @Override
    public BaseBrand selectBaseBrandById(Long id)
    {
        return baseBrandMapper.selectBaseBrandById(id);
    }

    /**
     * 查询生产商品牌列表
     * 
     * @param baseBrand 生产商品牌信息
     * @return 生产商品牌列表
     */
    @Override
    public List<BaseBrand> selectBaseBrandList(BaseBrand baseBrand)
    {
        return baseBrandMapper.selectBaseBrandList(baseBrand);
    }

    /**
     * 新增生产商品牌
     * 
     * @param baseBrand 生产商品牌信息
     * @return 结果
     */
    @Override
    public int insertBaseBrand(BaseBrand baseBrand)
    {
        baseBrand.setCreateBy(SecurityUtils.getUsername());
        return baseBrandMapper.insertBaseBrand(baseBrand);
    }

    /**
     * 修改生产商品牌信息
     * 
     * @param baseBrand 生产商品牌信息
     * @return 结果
     */
    @Override
    public int updateBaseBrand(BaseBrand baseBrand)
    {
        if (StringUtils.isNull(baseBrand)) {
            baseBrand.setStatus(Constants.STATUS_OK);
        }
        baseBrand.setUpdateTime(DateUtils.getNowDate());
        return baseBrandMapper.updateBaseBrand(baseBrand);
    }

    /**
     * 批量删除生产商品牌信息
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBaseBrandByIds(Long[] ids)
    {
        return baseBrandMapper.deleteBaseBrandByIds(ids);
    }

    /**
     * 删除生产商品牌信息
     * 
     * @param id 生产商品牌主键
     * @return 结果
     */
    @Override
    public int deleteBaseBrandById(Long id)
    {
        return baseBrandMapper.deleteBaseBrandById(id);
    }

    /**
     * 查询生产商品牌列表
     *
     * @param baseBrand 生产商品牌信息
     * @return 生产商品牌列表
     */
    @Override
    public List<BaseBrand> selectBaseBrandVoList(BaseBrand baseBrand)
    {
        return baseBrandMapper.selectBaseBrandVoList(baseBrand);
    }

    /**
     * 校验生产name是否唯一性(登录)
     *
     * @param baseBrand 制造商
     * @return 返回结果
     */
    @Override
    public String checkBrandNameUnique(BaseBrand baseBrand)
    {
        // 校验数据是否已经存在
        List<BaseBrand> lstChkBrandInfo = baseBrandMapper.selectBaseBrandInfoByName(StringUtils.trim(baseBrand.getBrandName()));
        if (lstChkBrandInfo != null && lstChkBrandInfo.size() > 0) {
            return BrandConstants.NOT_UNIQUE;
        }

        return BrandConstants.UNIQUE;
    }

    /**
     * 校验生产name是否唯一性(更新)
     *
     * @param baseBrand 品牌
     * @return 返回结果
     */
    @Override
    public String checkUpBrandNameUnique(BaseBrand baseBrand)
    {
        // 校验数据是否已经存在
        List<BaseBrand> lstChkBradInfo = baseBrandMapper.selectBaseBrandInfoByName(StringUtils.trim(baseBrand.getBrandName()));

        if (StringUtils.isNotNull(lstChkBradInfo)) {
            int iListSize = lstChkBradInfo.size();
            if (iListSize > 1) {
                return BrandConstants.NOT_UNIQUE;
            } else if (iListSize == 1) {

                BaseBrand info = lstChkBradInfo.get(0);
                Long brandId = StringUtils.isNull(info.getId()) ? -1L : info.getId();
                // 本身更新数据
                if (StringUtils.isNotNull(info) && info.getId().longValue() == brandId.longValue()) {
                    return BrandConstants.UNIQUE;
                } else {
                    return BrandConstants.NOT_UNIQUE;
                }
            }
        }

        return BrandConstants.UNIQUE;
    }

    /**
     * 校验生产Id是否唯一性(更新)
     *
     * @param baseBrand 品牌
     * @return 返回结果
     */
    @Override
    public String checkUpBrandIdUnique(BaseBrand baseBrand)
    {
        Long brandId = StringUtils.isNull(baseBrand.getId()) ? -1L : baseBrand.getId();
        // 校验数据是否已经存在
        BaseBrand chkBrandInfo = baseBrandMapper.selectBaseBrandById(baseBrand.getId());
        if (StringUtils.isNotNull(chkBrandInfo) && chkBrandInfo.getId().longValue() == brandId.longValue()) {

            return MfrsConstants.NOT_UNIQUE;
        }

        return MfrsConstants.UNIQUE;
    }
}
