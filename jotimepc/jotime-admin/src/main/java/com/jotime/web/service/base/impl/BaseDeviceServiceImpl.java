package com.jotime.web.service.base.impl;

import com.jotime.common.constant.BaseDeviceConstants;
import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseDevice;
import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.domainVo.base.BaseDeviceVos;
import com.jotime.web.domainVo.excel.BaseDeviceExlVo;
import com.jotime.web.mapper.base.BaseDeviceMapper;
import com.jotime.web.mapper.base.BaseWorkshopMapper;
import com.jotime.web.service.base.IBaseCodeRuleService;
import com.jotime.web.service.base.IBaseDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 设备信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class BaseDeviceServiceImpl implements IBaseDeviceService {
    @Autowired
    private BaseDeviceMapper baseDeviceMapper;
    @Autowired
    private IBaseCodeRuleService iBaseCodeRuleService;
    @Autowired
    private BaseWorkshopMapper baseWorkshopMapper;

    /**
     * 查询设备信息
     *
     * @param id 设备信息主键
     * @return 设备信息
     */
    @Override
    public BaseDevice selectBaseDeviceById(Long id) {
        return baseDeviceMapper.selectBaseDeviceById(id);
    }

    /**
     * 查询设备信息列表
     *
     * @param baseDevice 设备信息
     * @return 设备信息
     */
    @Override
    public List<BaseDevice> selectBaseDeviceList(BaseDevice baseDevice) {
        List<BaseDevice> baseDevices = baseDeviceMapper.selectBaseDeviceList(baseDevice);
//        设置二维码
//        baseDevices.forEach((device -> device.setQrCode(QrCodeUtils.getBase64(device.getQrCode(), 500, 500))));
        return baseDevices;
    }
    /**
     * 查询设备信息列表
     *
     * @param baseDevice 设备信息
     * @return 设备信息集合
     */
    @Override
    public List<BaseDeviceVos> selectBaseDeviceVoList(BaseDevice baseDevice) {
        return baseDeviceMapper.selectBaseDeviceVoList(baseDevice);
    }

    /**
     * 查询设备信息列表
     *
     * @param id 设备组id
     * @return 设备信息集合
     */
    @Override
    public List<BaseDevice> selectGroupDevice(Long id) {
        return baseDeviceMapper.selectGroupDevice(id);
    }

    /**
     * 新增设备信息
     *
     * @param baseDevice 设备信息
     * @return 结果
     */
    @Override
    public int insertBaseDevice(BaseDevice baseDevice) {
//        获取设备编号
        String deviceCode = iBaseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_DEVICE_CD, null)[2];
        baseDevice.setCreateTime(DateUtils.getNowDate());
        baseDevice.setCreateBy(SecurityUtils.getUserId().toString());
        baseDevice.setQrCode(deviceCode);
        baseDevice.setDeviceCode(deviceCode);
        return baseDeviceMapper.insertBaseDevice(baseDevice);
    }

    /**
     * 修改设备信息
     *
     * @param baseDevice 设备信息
     * @return 结果
     */
    @Override
    public int updateBaseDevice(BaseDevice baseDevice) {
        baseDevice.setUpdateTime(DateUtils.getNowDate());
        BaseDevice baseDevice1 = new BaseDevice();
        baseDevice1.setDeviceCode(baseDevice.getDeviceCode());
        List<BaseDevice> baseDevices = baseDeviceMapper.selectBaseDeviceList(baseDevice1);
        if (baseDevices.size() > 0 && !baseDevice.getId().equals(baseDevices.get(0).getId())) {
            return 0;
        }
        baseDevice.setUpdateTime(DateUtils.getNowDate());
        return baseDeviceMapper.updateBaseDevice(baseDevice);
    }

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的设备信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseDeviceByIds(Long[] ids) {
        return baseDeviceMapper.deleteBaseDeviceByIds(ids);
    }

    /**
     * 删除设备信息信息
     *
     * @param id 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseDeviceById(Long id) {
        return baseDeviceMapper.deleteBaseDeviceById(id);
    }

    @Override
    public List<BaseDevice> selectAllByLineCode(String lineCode) {
        return baseDeviceMapper.selectAllByLineCode(lineCode);
    }

    /**
     * 设备信息导入
     *
     * @param baseDeviceExlVos 导入设备信息
     * @return 结果
     */
    @Override
    @Transactional
    public int importData(List<BaseDeviceExlVo> baseDeviceExlVos, boolean updateSupport) {
        int row = 0;
        if (updateSupport) {
            for (BaseDeviceExlVo baseDeviceExlVo : baseDeviceExlVos) {
                BaseDevice baseDevice = new BaseDevice();
                //设备不为空
                if (StringUtils.isNotNull(baseDeviceExlVo.getDeviceCode())) {
                    BaseDevice bd = baseDeviceMapper.selectBaseDeviceByDeviceCode(baseDeviceExlVo.getDeviceCode());
                    if (StringUtils.isNotNull(bd)) {
                        baseDevice.setId(bd.getId());
                        processingData(baseDeviceExlVo, baseDevice);
                        baseDevice.setUpdateBy(SecurityUtils.getUsername());
                        baseDevice.setUpdateTime(DateUtils.getNowDate());
                        baseDeviceMapper.updateBaseDevice(baseDevice);
                    } else {
                        processingData(baseDeviceExlVo, baseDevice);
                        row += insertBaseCosmeticMaterialExlVo(baseDeviceExlVo, baseDevice, row);
                    }
                }
            }
        } else {
            for (BaseDeviceExlVo baseDeviceExlVo : baseDeviceExlVos) {
                BaseDevice baseDevice = new BaseDevice();
                //设备不为空
                if (StringUtils.isNotNull(baseDeviceExlVo.getDeviceCode())) {
                    BaseDevice bd = baseDeviceMapper.selectBaseDeviceByDeviceCode(baseDeviceExlVo.getDeviceCode());
                    if (StringUtils.isNotNull(bd)) {
                        continue;
                    } else {
                        processingData(baseDeviceExlVo, baseDevice);
                        row += insertBaseCosmeticMaterialExlVo(baseDeviceExlVo, baseDevice, row);
                    }
                }
            }
        }
        return row;
    }

    /**
     * vo对象转为dao对象
     *
     * @param baseDeviceExlVo
     * @param baseDevice
     */
    private void processingData(BaseDeviceExlVo baseDeviceExlVo, BaseDevice baseDevice) {
        baseDevice.setDeviceCode(baseDeviceExlVo.getDeviceCode());
        baseDevice.setDeviceName(baseDeviceExlVo.getDeviceName());
        baseDevice.setDeviceModel(baseDeviceExlVo.getDeviceModel());
        baseDevice.setPurchaseDate(baseDeviceExlVo.getPurchaseDate());
        baseDevice.setContent(baseDeviceExlVo.getContent());
        baseDevice.setMaintenanceDate(baseDeviceExlVo.getMaintenanceDate());
        baseDevice.setMaintenanceCycle(baseDeviceExlVo.getMaintenanceCycle());
        baseDevice.setNextMaintenanceDate(baseDeviceExlVo.getNextMaintenanceDate());
        baseDevice.setDeviceLeaderId(baseDeviceExlVo.getDeviceLeaderId());
        baseDevice.setTwoNdMaintenanceCycle(baseDeviceExlVo.getTwoNdMaintenanceCycle());
        baseDevice.setNextTwoNdMaintenanceDate(baseDeviceExlVo.getNextTwoNdMaintenanceDate());
        baseDevice.setTwoDeviceLeaderId(baseDeviceExlVo.getTwoDeviceLeaderId());
        baseDevice.setDeviceClass(baseDeviceExlVo.getDeviceClass());
        baseDevice.setDeviceMfrs(baseDeviceExlVo.getDeviceMfrs());
        baseDevice.setPdDate(baseDeviceExlVo.getPdDate());
        baseDevice.setContactTelephone(baseDeviceExlVo.getContactTelephone());
        BaseWorkshop baseWorkshop = baseWorkshopMapper.checkWorkShopNameUnique(baseDeviceExlVo.getWorkShopName());
        if (StringUtils.isNotNull(baseWorkshop) && StringUtils.isNotEmpty(baseWorkshop.getWorkshopCode())) {
            baseDevice.setWorkshopId(baseWorkshop.getId());
        }

        if ("工作中".equals(baseDeviceExlVo.getStatus())) {
            baseDevice.setStatus(BaseDeviceConstants.BASEDEVICE_WORKING);
        } else if ("空闲中".equals(baseDeviceExlVo.getStatus())) {
            baseDevice.setStatus(BaseDeviceConstants.BASEDEVICE_INTHEFREE);
        } else if ("保养中".equals(baseDeviceExlVo.getStatus())) {
            baseDevice.setStatus(BaseDeviceConstants.BASEDEVICE_INTHEMAINTENANCE);
        } else if ("维修中".equals(baseDeviceExlVo.getStatus())) {
            baseDevice.setStatus(BaseDeviceConstants.BASEDEVICE_INMAINTENANCE);
        } else if ("停用".equals(baseDeviceExlVo.getStatus())) {
            baseDevice.setStatus(BaseDeviceConstants.BASEDEVICE_BLOCKUP);
            //}else if("封存".equals(baseDeviceExlVo.getStatus())){
            //    baseDevice.setStatus(BaseDeviceConstants.BASEDEVICE_MOTHBALL);
            //}else if("待验收".equals(baseDeviceExlVo.getStatus())){
            //    baseDevice.setStatus(BaseDeviceConstants.BASEDEVICE_CHECK);
        }
        baseDevice.setNote(baseDeviceExlVo.getNote());
        //自己拼凑唯一标识 序列号+入库单号+物料id
        String qrCode = baseDeviceExlVo.getDeviceCode();
        baseDevice.setQrCode(qrCode);
    }

    private int insertBaseCosmeticMaterialExlVo(BaseDeviceExlVo baseDeviceExlVo, BaseDevice baseDevice, int row) {
        baseDevice.setCreateBy(SecurityUtils.getUsername());
        baseDevice.setCreateTime(DateUtils.getNowDate());
        return row + baseDeviceMapper.insertBaseDevice(baseDevice);
    }
}
