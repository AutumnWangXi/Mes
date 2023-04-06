package com.jotime.web.service.base.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.MfrsConstants;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jotime.web.mapper.base.BaseMfrsMapper;
import com.jotime.web.domain.base.BaseMfrs;
import com.jotime.web.service.base.IBaseMfrsService;

/**
 * 制造商Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class BaseMfrsServiceImpl extends ServiceImpl<BaseMfrsMapper, BaseMfrs> implements IBaseMfrsService {
    @Autowired
    private BaseMfrsMapper baseMfrsMapper;

    /**
     * 查询制造商
     *
     * @param id 制造商主键
     * @return 制造商
     */
    @Override
    public BaseMfrs selectBaseMfrsById(Long id) {
        return baseMfrsMapper.selectBaseMfrsById(id);
    }

    /**
     * 查询制造商列表
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */
    @Override
    public List<BaseMfrs> selectBaseMfrsList(BaseMfrs baseMfrs) {
        return baseMfrsMapper.selectBaseMfrsList(baseMfrs);
    }

    /**
     * 新增制造商
     *
     * @param baseMfrs 制造商
     * @return 结果
     */
    @Override
    public int insertBaseMfrs(BaseMfrs baseMfrs) {

        baseMfrs.setStatus(Constants.STATUS_OK);
        baseMfrs.setCreateBy(SecurityUtils.getUsername());
        return baseMfrsMapper.insertBaseMfrs(baseMfrs);
    }

    /**
     * 修改制造商
     *
     * @param baseMfrs 制造商
     * @return 结果
     */
    @Override
    public int updateBaseMfrs(BaseMfrs baseMfrs) {
        baseMfrs.setUpdateBy(SecurityUtils.getUsername());
        return baseMfrsMapper.updateBaseMfrs(baseMfrs);
    }

    /**
     * 批量删除制造商
     *
     * @param ids 需要删除的制造商主键
     * @return 结果
     */
    @Override
    public int deleteBaseMfrsByIds(Long[] ids) {
        return baseMfrsMapper.deleteBaseMfrsByIds(ids);
    }

    /**
     * 删除制造商信息
     *
     * @param id 制造商主键
     * @return 结果
     */
    @Override
    public int deleteBaseMfrsById(Long id) {
        return baseMfrsMapper.deleteBaseMfrsById(id);
    }

    /**
     * 校验生产Code是否唯一性(登录)
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */
    @Override
    public String checkMfrsCodeUnique(BaseMfrs baseMfrs) {
        // 校验数据是否已经存在
        List<BaseMfrs> lstChkMfrsInfo = baseMfrsMapper.selectBaseMfrsInfoByCode(baseMfrs.getMfrsCode());
        if (lstChkMfrsInfo != null && lstChkMfrsInfo.size() > 0) {
            return MfrsConstants.NOT_UNIQUE;
        }

        return MfrsConstants.UNIQUE;
    }

    /**
     * 校验生产name是否唯一性(登录)
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */
    @Override
    public String checkMfrsNameUnique(BaseMfrs baseMfrs) {
        // 校验数据是否已经存在
        List<BaseMfrs> lstChkMfrsInfo = baseMfrsMapper.selectBaseMfrsInfoByName(StringUtils.trim(baseMfrs.getMfrsName()));
        if (lstChkMfrsInfo != null && lstChkMfrsInfo.size() > 0) {
            return MfrsConstants.NOT_UNIQUE;
        }

        return MfrsConstants.UNIQUE;
    }

    /**
     * 校验生产Code是否唯一性(更新)
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */
    @Override
    public String checkUpMfrsIdUnique(BaseMfrs baseMfrs) {
        Long mfrsId = StringUtils.isNull(baseMfrs.getId()) ? -1L : baseMfrs.getId();
        // 校验数据是否已经存在
        BaseMfrs chkMfrsInfo = baseMfrsMapper.selectBaseMfrsById(baseMfrs.getId());
        if (StringUtils.isNotNull(chkMfrsInfo) && chkMfrsInfo.getId().longValue() == mfrsId.longValue()) {

            return MfrsConstants.NOT_UNIQUE;
        }

        return MfrsConstants.UNIQUE;
    }

    /**
     * 校验生产Code是否唯一性(更新)
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */
    @Override
    public String checkUpMfrsCodeUnique(BaseMfrs baseMfrs) {
        // 校验数据是否已经存在
        List<BaseMfrs> lstChkMfrsInfo = baseMfrsMapper.selectBaseMfrsInfoByCode(baseMfrs.getMfrsCode());
        if (StringUtils.isNotNull(lstChkMfrsInfo)) {
            int iListSize = lstChkMfrsInfo.size();
            if (iListSize > 1) {
                return MfrsConstants.NOT_UNIQUE;
            } else if (iListSize == 1) {
                Long supplierId = StringUtils.isNull(baseMfrs.getId()) ? -1L : baseMfrs.getId();
                BaseMfrs info = lstChkMfrsInfo.get(0);
                // 本身更新数据
                if (StringUtils.isNotNull(info) && info.getId().longValue() == supplierId.longValue()) {
                    return MfrsConstants.UNIQUE;
                } else {
                    return MfrsConstants.NOT_UNIQUE;
                }
            }
        }

        return MfrsConstants.UNIQUE;
    }

    /**
     * 校验生产name是否唯一性(更新)
     *
     * @param baseMfrs 制造商
     * @return 制造商
     */
    @Override
    public String checkUpMfrsNameUnique(BaseMfrs baseMfrs) {
        // 校验数据是否已经存在
        List<BaseMfrs> lstChkMfrsInfo = baseMfrsMapper.selectBaseMfrsInfoByName(StringUtils.trim(baseMfrs.getMfrsName()));

        if (StringUtils.isNotNull(lstChkMfrsInfo)) {
            int iListSize = lstChkMfrsInfo.size();
            if (iListSize > 1) {
                return MfrsConstants.NOT_UNIQUE;
            } else if (iListSize == 1) {
                Long supplierId = StringUtils.isNull(baseMfrs.getId()) ? -1L : baseMfrs.getId();
                BaseMfrs info = lstChkMfrsInfo.get(0);
                // 本身更新数据
                if (StringUtils.isNotNull(info) && info.getId().longValue() == supplierId.longValue()) {
                    return MfrsConstants.UNIQUE;
                } else {
                    return MfrsConstants.NOT_UNIQUE;
                }
            }
        }

        return MfrsConstants.UNIQUE;
    }

    /**
     * 查询制造商列表
     *
     * @param baseMfrs 制造商
     * @return 制造商集合
     */
    @Override
    public List<BaseMfrs> getMfrsOptionsList(BaseMfrs baseMfrs) {
        return baseMfrsMapper.selectMfrsInfoBySts(baseMfrs.getStatus().longValue());
    }

    /**
     * 查询制造商名称
     *
     * @return 名称合集
     */
    @Override
    public List<BaseMfrs> selectMfrsName() {
        BaseMfrs baseMfrs = new BaseMfrs();
        baseMfrs.setStatus(2);
        return baseMfrsMapper.selectBaseMfrsList(baseMfrs);
    }
}
