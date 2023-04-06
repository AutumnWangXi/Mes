package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseCosmeticMaterial;
import com.jotime.web.domainVo.excel.BaseCosmeticMaterialExlVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 已使用化妆品原料Mapper接口
 *
 * @author yunmoqian
 * @date 2022-04-20
 */
public interface BaseCosmeticMaterialMapper
{
    /**
     * 查询已使用化妆品原料
     *
     * @param id 已使用化妆品原料主键
     * @return 已使用化妆品原料
     */
    public BaseCosmeticMaterial selectBaseCosmeticMaterialById(Long id);
    /**
     * 查询已使用化妆品原料
     *
     * @param serialNumber 已使用化妆品原料序号
     * @return 已使用化妆品原料
     */
    public BaseCosmeticMaterial selectBaseCosmeticMaterialBySerialNumber(String serialNumber);
    /**
     * 查询已使用化妆品原料
     *
     * @param cn 中文名
     * @param en 英文名
     * @return 已使用化妆品原料
     */
    public BaseCosmeticMaterial selectBaseCosmeticMaterialByCnAndEn(@Param("cn") String cn,@Param("en") String en);

    /**
     * 查询已使用化妆品原料列表
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 已使用化妆品原料集合
     */
    public List<BaseCosmeticMaterial> selectBaseCosmeticMaterialList(BaseCosmeticMaterial baseCosmeticMaterial);
    /**
     * 查询已使用化妆品原料列表
     *
     * @param baseCosmeticMaterialExlVo 已使用化妆品原料
     * @return 已使用化妆品原料集合
     */
    public List<BaseCosmeticMaterialExlVo> selectBaseCosmeticMaterialExlVoList(BaseCosmeticMaterialExlVo baseCosmeticMaterialExlVo);

    /**
     * 新增已使用化妆品原料
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 结果
     */
    public int insertBaseCosmeticMaterial(BaseCosmeticMaterial baseCosmeticMaterial);

    /**
     * 修改已使用化妆品原料
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 结果
     */
    public int updateBaseCosmeticMaterial(BaseCosmeticMaterial baseCosmeticMaterial);

    /**
     * 删除已使用化妆品原料
     *
     * @param id 已使用化妆品原料主键
     * @return 结果
     */
    public int deleteBaseCosmeticMaterialById(Long id);

    /**
     * 批量删除已使用化妆品原料
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCosmeticMaterialByIds(Long[] ids);

    List<BaseCosmeticMaterial> selectBaseCosmeticMaterialByEn(String inciNameCn);
}
