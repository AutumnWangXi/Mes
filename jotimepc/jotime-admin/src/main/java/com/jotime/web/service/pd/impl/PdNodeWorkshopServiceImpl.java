package com.jotime.web.service.pd.impl;

import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.pd.PdNodeWorkshop;
import com.jotime.web.domainVo.pd.PdNodeWorkshopVo;
import com.jotime.web.mapper.pd.PdNodeWorkshopMapper;
import com.jotime.web.service.pd.IPdNodeWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 描述：生产节点所属车间Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-05-06
 */
@Service
public class PdNodeWorkshopServiceImpl implements IPdNodeWorkshopService
{
    @Autowired
    private PdNodeWorkshopMapper pdNodeWorkshopMapper;

    /**
     * 查询描述：生产节点所属车间
     *
     * @param id 描述：生产节点所属车间主键
     * @return 描述：生产节点所属车间
     */
    @Override
    public PdNodeWorkshop selectPdNodeWorkshopById(Long id)
    {
        return pdNodeWorkshopMapper.selectPdNodeWorkshopById(id);
    }

    /**
     * 查询描述：生产节点所属车间列表
     *
     * @param pdNodeWorkshop 描述：生产节点所属车间
     * @return 描述：生产节点所属车间
     */
    @Override
    public List<PdNodeWorkshop> selectPdNodeWorkshopList(PdNodeWorkshop pdNodeWorkshop)
    {
        return pdNodeWorkshopMapper.selectPdNodeWorkshopList(pdNodeWorkshop);
    }

    /**
     * 新增描述：生产节点所属车间
     *
     * @param pdNodeWorkshop 描述：生产节点所属车间
     * @return 结果
     */
    @Override
    public int insertPdNodeWorkshop(PdNodeWorkshop pdNodeWorkshop)
    {
        pdNodeWorkshop.setCreateBy(SecurityUtils.getUsername());
        return pdNodeWorkshopMapper.insertPdNodeWorkshop(pdNodeWorkshop);
    }

    /**
     * 修改描述：生产节点所属车间
     *
     * @param pdNodeWorkshop 描述：生产节点所属车间
     * @return 结果
     */
    @Override
    public int updatePdNodeWorkshop(PdNodeWorkshop pdNodeWorkshop)
    {
        pdNodeWorkshop.setUpdateBy(SecurityUtils.getUsername());
        return pdNodeWorkshopMapper.updatePdNodeWorkshop(pdNodeWorkshop);
    }

    /**
     * 批量删除描述：生产节点所属车间
     *
     * @param ids 需要删除的描述：生产节点所属车间主键
     * @return 结果
     */
    @Override
    public int deletePdNodeWorkshopByIds(Long[] ids)
    {
        return pdNodeWorkshopMapper.deletePdNodeWorkshopByIds(ids);
    }

    /**
     * 删除描述：生产节点所属车间信息
     *
     * @param id 描述：生产节点所属车间主键
     * @return 结果
     */
    @Override
    public int deletePdNodeWorkshopById(Long id)
    {
        return pdNodeWorkshopMapper.deletePdNodeWorkshopById(id);
    }

    /**
     * 查询描述：生产节点所属车间列表
     *
     * @param pdNodeWorkshopVo 描述：生产节点所属车间
     * @return 描述：生产节点所属车间集合
     */
    @Override
    public List<PdNodeWorkshopVo> selectPdNodeWorkshopVoList(PdNodeWorkshopVo pdNodeWorkshopVo) {
        return pdNodeWorkshopMapper.selectPdNodeWorkshopVoList(pdNodeWorkshopVo);
    }
}
