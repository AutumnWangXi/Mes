package com.jotime.web.mapper.pd;

import com.jotime.web.domain.pd.PdNodeWorkshop;
import com.jotime.web.domainVo.pd.PdNodeWorkshopVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：生产节点所属车间Mapper接口
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
public interface PdNodeWorkshopMapper 
{
    /**
     * 查询描述：生产节点所属车间
     * 
     * @param id 描述：生产节点所属车间主键
     * @return 描述：生产节点所属车间
     */
    public PdNodeWorkshop selectPdNodeWorkshopById(Long id);

    public PdNodeWorkshop selectPdNodeWorkshopInfo(@Param("moduleId") Long moduleId , @Param("nodeId")Long nodeId);

    /**
     * 查询描述：生产节点所属车间列表
     * 
     * @param pdNodeWorkshop 描述：生产节点所属车间
     * @return 描述：生产节点所属车间集合
     */
    public List<PdNodeWorkshop> selectPdNodeWorkshopList(PdNodeWorkshop pdNodeWorkshop);

    /**
     * 新增描述：生产节点所属车间
     *
     * @param pdNodeWorkshop 描述：生产节点所属车间
     * @return 结果
     */
    public int insertPdNodeWorkshop(PdNodeWorkshop pdNodeWorkshop);

    /**
     * 修改描述：生产节点所属车间
     *
     * @param pdNodeWorkshop 描述：生产节点所属车间
     * @return 结果
     */
    public int updatePdNodeWorkshop(PdNodeWorkshop pdNodeWorkshop);

    /**
     * 删除描述：生产节点所属车间
     *
     * @param id 描述：生产节点所属车间主键
     * @return 结果
     */
    public int deletePdNodeWorkshopById(Long id);

    /**
     * 批量删除描述：生产节点所属车间
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePdNodeWorkshopByIds(Long[] ids);
    /**
     * 查询描述：生产节点所属车间列表
     *
     * @param pdNodeWorkshopVo 描述：生产节点所属车间
     * @return 描述：生产节点所属车间集合
     */
    public List<PdNodeWorkshopVo> selectPdNodeWorkshopVoList(PdNodeWorkshopVo pdNodeWorkshopVo);
}
