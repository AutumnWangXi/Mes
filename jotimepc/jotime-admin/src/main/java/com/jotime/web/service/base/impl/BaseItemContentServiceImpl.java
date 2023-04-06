package com.jotime.web.service.base.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseCosmeticMaterial;
import com.jotime.web.domain.base.BaseItemContent;
import com.jotime.web.mapper.base.BaseCosmeticMaterialMapper;
import com.jotime.web.mapper.base.BaseItemContentMapper;
import com.jotime.web.service.base.IBaseItemContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * 描述：物料含量Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-03-28
 */
@Service
public class BaseItemContentServiceImpl implements IBaseItemContentService {
    @Autowired
    private BaseItemContentMapper baseItemContentMapper;
    @Resource
    private BaseCosmeticMaterialMapper baseCosmeticMaterialMapper;
    /**
     * 查询描述：物料含量
     *
     * @param id 描述：物料含量主键
     * @return 描述：物料含量
     */
    @Override
    public BaseItemContent selectBaseItemContentById(Long id) {
        return baseItemContentMapper.selectBaseItemContentById(id);
    }

    /**
     * 查询描述：物料含量列表
     *
     * @param baseItemContent 描述：物料含量
     * @return 描述：物料含量
     */
    @Override
    public List<BaseItemContent> selectBaseItemContentList(BaseItemContent baseItemContent) {
        return baseItemContentMapper.selectBaseItemContentList(baseItemContent);
    }

    /**
     * 新增描述：物料含量
     *
     * @param baseItemContent 描述：物料含量
     * @return 结果
     */
    @Override
    public int insertBaseItemContent(BaseItemContent baseItemContent) {
        baseItemContent.setCreateTime(DateUtils.getNowDate());
        return baseItemContentMapper.insertBaseItemContent(baseItemContent);
    }

    /**
     * 修改描述：物料含量
     *
     * @param baseItemContent 描述：物料含量
     * @return 结果
     */
    @Override
    public int updateBaseItemContent(BaseItemContent baseItemContent) {
        baseItemContent.setUpdateTime(DateUtils.getNowDate());
        return baseItemContentMapper.updateBaseItemContent(baseItemContent);
    }

    /**
     * 批量删除描述：物料含量
     *
     * @param ids 需要删除的描述：物料含量主键
     * @return 结果
     */
    @Override
    public int deleteBaseItemContentByIds(Long[] ids) {
        return baseItemContentMapper.deleteBaseItemContentByIds(ids);
    }

    /**
     * 删除描述：物料含量信息
     *
     * @param id 描述：物料含量主键
     * @return 结果
     */
    @Override
    public int deleteBaseItemContentById(Long id) {
        return baseItemContentMapper.deleteBaseItemContentById(id);
    }

    /**
     * @param baseItemContentNew 物料含量信息
     * @param itemId             物料id
     * @Description: 更新物料对应含量信息
     * @Author: YunFei
     * @Date: 2022/3/29 10:53
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBaseItemContentList(List<BaseItemContent> baseItemContentNew, Long itemId) {
        BaseItemContent baseItemContent = new BaseItemContent();
        baseItemContent.setItemId(itemId.toString());
//        查找要更新对应物料的含量信息
        List<BaseItemContent> baseItemContentsOld = baseItemContentMapper.selectBaseItemContentList(baseItemContent);
//        物料含量老数据id
        List<Long> oldIds = new ArrayList<>();
//        本次提交的所有物料含量更新数据id
        List<Long> newIds = new ArrayList<>();
//        老数据id添加到老数据id的list里
        baseItemContentsOld.forEach(oldItem -> oldIds.add(oldItem.getId()));
//        更新数据id添加到更新数据id的list里
        baseItemContentNew.forEach(newItem -> {if (newItem.getId() != null) newIds.add(newItem.getId());});
//         比较集合，如果老数据里的id在本次更新数据里没有，则视为被删除了
        oldIds.forEach(oldId -> {
            if (!newIds.contains(oldId)) baseItemContentMapper.deleteBaseItemContentById(oldId);
        });
//      这时数据库中对应的物料只剩下本次提交的要更新物料含量数据（表中存在的）和新添加的物料含量数据（表中不存在的）
        baseItemContentNew.forEach(itemContent -> {
            if (StringUtils.isEmpty(itemContent.getSerialNumber())){
                throw new RuntimeException("化妆品适用原料序号不能为空！");
            }
            BaseCosmeticMaterial baseCosmeticMaterial = baseCosmeticMaterialMapper.selectBaseCosmeticMaterialBySerialNumber(StringUtils.leftPad(itemContent.getSerialNumber(),5,"0"));
            if (ObjectUtils.isEmpty(baseCosmeticMaterial)){
                throw new RuntimeException("化妆品适用原料序号填写错误！");
            }
            itemContent.setInciNameEn(baseCosmeticMaterial.getInciNameEn());
            itemContent.setInciNameCn(baseCosmeticMaterial.getInciNameCn());
//            存在的数据进行更新
            if (itemContent.getId() != null) {
                itemContent.setUpdateBy(SecurityUtils.getUserId().toString());
                itemContent.setUpdateTime(DateUtils.getNowDate());
                baseItemContentMapper.updateBaseItemContent(itemContent);
//                不存在的数据进行新插入
            } else {
                itemContent.setItemId(itemId.toString());
                itemContent.setCreateBy(SecurityUtils.getUserId().toString());
                itemContent.setCreateTime(DateUtils.getNowDate());
                baseItemContentMapper.insertBaseItemContent(itemContent);
            }
        });
    }

}
