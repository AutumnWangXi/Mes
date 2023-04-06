package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseItem;
import com.jotime.web.domain.base.VItem;
import com.jotime.web.domainVo.base.VItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 物料Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-28
 */
public interface VItemMapper extends BaseMapper<VItem> {

    public VItemVo selecItemByItemId(Long id);

    List<VItemVo> getItemTypeList(@Param("itemIdList") List<Long> itemIdList);

    public List<VItemVo> selectItemNameList(VItem vItem);


}
