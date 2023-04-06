package com.jotime.web.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseFileManage;
import com.jotime.web.mapper.base.BaseFileManageMapper;
import com.jotime.web.service.base.IBaseFileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 描述  base文件管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-02-16
 */
@Service
public class BaseFileManageServiceImpl extends ServiceImpl<BaseFileManageMapper, BaseFileManage> implements IBaseFileManageService
{
    @Autowired
    private BaseFileManageMapper baseFileManageMapper;

    /**
     * 查询描述  base文件管理
     *
     * @param id 描述  base文件管理主键
     * @return 描述  base文件管理
     */
    @Override
    public BaseFileManage selectBaseFileManageById(Long id)
    {
        return baseFileManageMapper.selectBaseFileManageById(id);
    }

    /**
     * 查询描述  base文件管理列表
     *
     * @param baseFileManage 描述  base文件管理
     * @return 描述  base文件管理
     */
    @Override
    public List<BaseFileManage> selectBaseFileManageList(BaseFileManage baseFileManage)
    {
        return baseFileManageMapper.selectBaseFileManageList(baseFileManage);
    }

    /**
     * 新增描述  base文件管理
     *
     * @param baseFileManage 描述  base文件管理
     * @return 结果
     */
    @Override
    public int insertBaseFileManage(BaseFileManage baseFileManage)
    {
        baseFileManage.setCreateTime(DateUtils.getNowDate());
        return baseFileManageMapper.insertBaseFileManage(baseFileManage);
    }

    /**
     * 修改描述  base文件管理
     *
     * @param baseFileManage 描述  base文件管理
     * @return 结果
     */
    @Override
    public int updateBaseFileManage(BaseFileManage baseFileManage)
    {
        baseFileManage.setUpdateTime(DateUtils.getNowDate());
        return baseFileManageMapper.updateBaseFileManage(baseFileManage);
    }

    /**
     * 批量删除描述  base文件管理
     *
     * @param ids 需要删除的描述  base文件管理主键
     * @return 结果
     */
    @Override
    public int deleteBaseFileManageByIds(Long[] ids)
    {
        return baseFileManageMapper.deleteBaseFileManageByIds(ids);
    }

    /**
     * 删除描述  base文件管理信息
     *
     * @param id 描述  base文件管理主键
     * @return 结果
     */
    @Override
    public int deleteBaseFileManageById(Long id)
    {
        return baseFileManageMapper.deleteBaseFileManageById(id);
    }
    /**
     * 根据url去修改数据
     *
     * @param baseFileManages 修改修改的文件
     */
    @Override
    public void updateFileManage(List<BaseFileManage> baseFileManages){
        this.updateBatchById(baseFileManages);
    }

    @Override
    public void deleteFileByUrl(List<String> urlList) {
        QueryWrapper<BaseFileManage> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(urlList)) {
            queryWrapper.in("file_url", urlList);
        }
        this.remove(queryWrapper);
    }
}
