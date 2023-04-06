import request from '@/utils/request'

// 查询巡检模板列表
export function listTemplates(query) {
  return request({
    url: '/ipqc/templates/list',
    method: 'get',
    params: query
  })
}
// 查询巡检模板列表（分组）
export function getTempGroup(query) {
  return request({
    url: '/ipqc/templates/getTempGroup',
    method: 'get',
    params: query
  })
}


// 查询巡检模板列表
export function optionListTemplates(query) {
  return request({
    url: '/ipqc/templates/optionList',
    method: 'get',
    params: query
  })
}

// 查询巡检模板详细
export function getTemplates(id) {
  return request({
    url: '/ipqc/templates/' + id,
    method: 'get'
  })
}

// 查询巡检模板明细
export function getTemplatesdtl(id) {
  return request({
    url: '/ipqc/templates/templatesdtl/' + id,
    method: 'get'
  })
}



// 新增巡检模板
export function addTemplates(data) {
  return request({
    url: '/ipqc/templates',
    method: 'post',
    data: data
  })
}

// 修改巡检模板
export function updateTemplates(data) {
  return request({
    url: '/ipqc/templates',
    method: 'put',
    data: data
  })
}
// 修改巡检模板
export function updateTemplatesDtl(data) {
  return request({
    url: '/ipqc/templates/edit',
    method: 'put',
    data: data
  })
}



// 删除巡检模板
export function delTemplates(id) {
  return request({
    url: '/ipqc/templates/' + id,
    method: 'delete'
  })
}
