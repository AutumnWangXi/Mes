package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseOpenline;
import com.jotime.web.domainVo.base.BaseOpenlineVo;

import java.util.List;


/**
 * 开线检查Mapper接口
 *
 * @author YunFei
 * @date 2022-03-04
 */
public interface BaseOpenlineMapper extends BaseMapper<BaseOpenline>
{
    /**
     * 查询开线检查
     *
     * @param id 开线检查主键
     * @return 开线检查
     */
    public BaseOpenline selectBaseOpenlineById(Long id);

    /**
     * 查询开线检查列表
     *
     * @param baseOpenline 开线检查
     * @return 开线检查集合
     */
    public List<BaseOpenline> selectBaseOpenlineList(BaseOpenline baseOpenline);
    /**
     * 查询开线检查列表
     *
     * @param baseOpenline 开线检查
     * @return 开线检查集合
     */
    public List<BaseOpenlineVo> selectBaseOpenlineVoList(BaseOpenline baseOpenline);

    /**
     * 新增开线检查
     *
     * @param baseOpenline 开线检查
     * @return 结果
     */
    public int insertBaseOpenline(BaseOpenline baseOpenline);

    /**
     * 修改开线检查
     *
     * @param baseOpenline 开线检查
     * @return 结果
     */
    public int updateBaseOpenline(BaseOpenline baseOpenline);

    /**
     * 删除开线检查
     *
     * @param id 开线检查主键
     * @return 结果
     */
    public int deleteBaseOpenlineById(Long id);

    /**
     * 批量删除开线检查
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseOpenlineByIds(Long[] ids);

    /**
     * @Description 查询开线检查表
     * @param
     * @return
     * @auther by 14812
     */
    List<BaseOpenlineVo> selectBaseOpenlineLists(BaseOpenlineVo baseOpenlineVo);
}
