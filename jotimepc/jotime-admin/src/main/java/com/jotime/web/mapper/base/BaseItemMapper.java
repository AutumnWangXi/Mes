package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseItem;
import com.jotime.web.domainVo.base.BaseItemSelectAllVo;
import com.jotime.web.domainVo.base.BaseItemVo;
import com.jotime.web.domainVo.base.ItemStockAndPriceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 物料Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-28
 */
public interface BaseItemMapper extends BaseMapper<BaseItem> {
    /**
     * 查询物料
     *
     * @param id 物料主键
     * @return 物料
     */
    public BaseItem selectBaseItemById(Long id);

    /**
     * 查询物料列表
     *
     * @param baseItem 物料
     * @return 物料集合
     */
    public List<BaseItemVo> selectBaseItemList(BaseItem baseItem);

    /**
     * 查询全部物料
     *
     * @return
     */
    public List<BaseItem> selectItemEffectiveAll();


    /**
     * 新增物料
     *
     * @param baseItemVo 物料
     * @return 结果
     */
    public int insertBaseItem(BaseItemVo baseItemVo);

    /**
     * 新增物料
     *
     * @param baseItem 物料
     * @return 结果
     * 因原插入sql被改为vo，重写为interPosiTionBaseItem
     */
    public int interPositionBaseItem(BaseItem baseItem);

    /**
     * 新增物料
     *
     * @param baseItem 物料
     * @return 结果
     * 因原插入sql被改为vo，重写为interPosiTionBaseItem
     */
    public int inserts(BaseItem baseItem);

    /**
     * 修改物料
     *
     * @param baseItem 物料
     * @return 结果
     */
    public int updateBaseItem(BaseItem baseItem);

    /**
     * 删除物料
     *
     * @param id 物料主键
     * @return 结果
     */
    public int deleteBaseItemById(Long id);

    /**
     * 批量删除物料
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseItemByIds(Long[] ids);

    /**
     * 根据物料编号查询
     *
     * @param itemNo 编号值
     * @param type   类型
     * @return 结果
     */
    BaseItem selectByItemNo(@Param("itemNo") String itemNo, @Param("type") String type);

    /**
     * 根据物料编号查询
     *
     * @param itemCode 编号值
     * @param type     类型
     * @return 结果
     */
    BaseItem selectByItemCode(@Param("itemCode") String itemCode, @Param("type") String type);

    /**
     * 根据物料id查询数据
     *
     * @param itemId 编号值
     * @return 结果
     */
    BaseItem selectByItemId(@Param("itemId") String itemId);


    /**
     * 根据单号查询数据
     *
     * @param itemCode 物料编号
     * @return 结果
     */
    BaseItem selectItemByItemCode(String itemCode);

    /**
     * 根据物料id查询物料数据
     *
     * @param itemId 物料
     * @return 结果
     */
    public BaseItem selectBaseItemByItemId(Long itemId);

    /**
     * 根据物料类型查询物料信息
     *
     * @param itemType 物料类型
     * @return 物料信息
     */
    public List<BaseItem> selectItemData(Integer itemType);

    /**
     * 根据物料类型查询物料信息  --只查詢少量展示信息
     *
     * @param itemTypeList 物料类型
     * @return 物料信息
     */
    public List<BaseItem> selectItemDataByItemType(@Param("itemTypeList") List<Integer> itemTypeList,@Param("limit") Integer limit);

    /**
     * 查询半成品和其他物料信息
     * @param itemType 物料类型
     * @return 查询结果
     */
    public List<BaseItem> selectVItemData(@Param("itemType") List<Integer> itemType);

    /**
     * 根据物料类型查询物料信息
     *
     * @return 物料信息
     */
    public List<BaseItem> selectItemNameList();

    /**
     * 查询物料
     *
     * @param itemCode 物料主键
     * @return 物料列表
     */
    public List<BaseItemVo> selectItemInfoByItemCode(String itemCode);

    /**
     * 通过code查询物料
     *
     * @param itemCode
     * @param itemName
     * @param manufacturerCode
     * @return 物料
     */
    public BaseItemVo selectBaseItemByItemCode(@Param("itemCode") String itemCode, @Param("itemName") String itemName, @Param("manufacturerCode") String manufacturerCode);


    /**
     * 查询物料
     *
     * @param itemId 物料id
     * @return 物料列表
     */
    List<BaseItemVo> selectItemInfoByItemId(@Param("itemId") List<Integer> itemId);


    /**
     * 通过itemType 查询baseitem
     *
     * @param itemType
     * @return
     */
    List<BaseItemVo> selectItemByItemType(Integer itemType);

    /**
     * 通过色号（实验室编号）
     *
     * @param
     * @return
     */
    BaseItem selectItemByColourNumber(String colourNumber);

    /**
     * 查询所有物料
     */
    List<BaseItemSelectAllVo> selectItem();

    /**
     * 根据物料ID查询信息
     * @param itemId 物料ID
     * @return 物料集合
     */
    BaseItem selectVItemDataByItemId(Long itemId);

    /**
     * @Description 根据传过来的名称查到所有的code
     * @param
     * @return
     * @auther by 14812
     */
    List<Long> selectBaseItemCodeByItemName(String itemName);

    /**
     * 根据物料的可用库存和采购价格关联信息
     * @param itemStockAndPriceVo 物料ID
     * @return 物料集合
     */
   public List<ItemStockAndPriceVo> selectItemPriceByItemIds(ItemStockAndPriceVo itemStockAndPriceVo);

}
