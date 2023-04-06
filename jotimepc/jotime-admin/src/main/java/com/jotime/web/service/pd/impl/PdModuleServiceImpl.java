package com.jotime.web.service.pd.impl;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.bean.BeanUtils;
import com.jotime.web.domain.pd.PdModule;
import com.jotime.web.domainVo.pd.PdModuleVo;
import com.jotime.web.domainVo.pd.PdProcessNodeVo;
import com.jotime.web.mapper.pd.PdModuleMapper;
import com.jotime.web.mapper.pd.PdProcessNodeMapper;
import com.jotime.web.service.pd.IPdModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 描述：生产流程名称Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-05-06
 */
@Service
public class PdModuleServiceImpl implements IPdModuleService {
    @Autowired
    private PdModuleMapper pdModuleMapper;
    @Autowired
    private PdProcessNodeMapper pdProcessNodeMapper;

    /**
     * 查询描述：生产流程名称
     *
     * @param id 描述：生产流程名称主键
     * @return 描述：生产流程名称
     */
    @Override
    public PdModule selectPdModuleById(Long id) {
        return pdModuleMapper.selectPdModuleById(id);
    }

    /**
     * 查询描述：生产流程名称列表
     *
     * @param pdModule 描述：生产流程名称
     * @return 描述：生产流程名称
     */
    @Override
    public List<PdModule> selectPdModuleList(PdModule pdModule) {
        return pdModuleMapper.selectPdModuleList(pdModule);
    }

    /**
     * 新增描述：生产流程名称
     *
     * @param pdModule 描述：生产流程名称
     * @return 结果
     */
    @Override
    public int insertPdModule(PdModule pdModule) {
        pdModule.setCreateBy(SecurityUtils.getUsername());
        pdModule.setCreateTime(DateUtils.getNowDate());
        return pdModuleMapper.insertPdModule(pdModule);
    }

    /**
     * 修改描述：生产流程名称
     *
     * @param pdModule 描述：生产流程名称
     * @return 结果
     */
    @Override
    public int updatePdModule(PdModule pdModule) {
        pdModule.setUpdateTime(DateUtils.getNowDate());
        return pdModuleMapper.updatePdModule(pdModule);
    }

    /**
     * 批量删除描述：生产流程名称
     *
     * @param ids 需要删除的描述：生产流程名称主键
     * @return 结果
     */
    @Override
    public int deletePdModuleByIds(Long[] ids) {
        return pdModuleMapper.deletePdModuleByIds(ids);
    }

    /**
     * 删除描述：生产流程名称信息
     *
     * @param id 描述：生产流程名称主键
     * @return 结果
     */
    @Override
    public int deletePdModuleById(Long id) {
        return pdModuleMapper.deletePdModuleById(id);
    }

    /**
     * 生产流程详情
     */
    @Override
    public AjaxResult moduleInfo(PdModule pdModule) {
        //当前节点
        Long nodeId = pdModule.getNodeId();

        pdModule = pdModuleMapper.selectPdModuleById(pdModule.getId());
        PdModuleVo pdModuleVo = new PdModuleVo();
        BeanUtils.copyProperties(pdModule,pdModuleVo);

        //节点信息
        List<PdProcessNodeVo> pdProcessNodeVos = pdProcessNodeMapper.moduleInfo(pdModuleVo.getId());
        if (StringUtils.isNotEmpty(pdProcessNodeVos)){
            //节点列表
            List<PdProcessNodeVo> nodeList = new ArrayList<>();

            //筛选初始节点
            List<PdProcessNodeVo> collect = pdProcessNodeVos.stream().filter(item -> {
                return item.getIsStart() == 2;
            }).collect(Collectors.toList());

            PdProcessNodeVo pdProcessNodeVo = collect.get(0);
            //初始节点id
            AtomicReference<Long> id = new AtomicReference<>(pdProcessNodeVo.getId());

            if(nodeId != null){
                id.set(nodeId);
            }
            //根据节点id 分组
            Map<Long, List<PdProcessNodeVo>> collect1 = pdProcessNodeVos.stream().collect(Collectors.groupingBy(PdProcessNodeVo::getId));

            //根据节点配置按顺序添加节点
            collect1.forEach((key,vale) ->{
                if(collect1.containsKey(id.get())){
                    PdProcessNodeVo e = collect1.get(id.get()).get(0);
                    nodeList.add(e);
                    id.set(Long.parseLong(e.getNextNodeId()+""));
                }

            });

            pdModuleVo.setPdProcessNodeVos(nodeList);
        }else {
            pdModuleVo.setPdProcessNodeVos(new ArrayList<PdProcessNodeVo>());
        }

        return AjaxResult.success(pdModuleVo);
    }
}
