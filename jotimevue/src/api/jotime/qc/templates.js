import request from '@/utils/request'

// 查询质检模板管理列表
export function listTemplates(query) {
  return request({
    url: '/web/templates/list',
    method: 'get',
    params: query
  })
}
// 查询质检模板管理详情
export function getInfo(query) {
  return request({
    url: '/web/templates/getInfo',
    method: 'get',
    params: query
  })
}
// 查询质检模板管理详细
export function getTemplates(id) {
  return request({
    url: '/web/templates/' + id,
    method: 'get'
  })
}

// 新增质检模板管理
export function addTemplates(data) {
  return request({
    url: '/web/templates',
    method: 'post',
    data: data
  })
}

// 修改质检模板管理
export function updateTemplates(data) {
  return request({
    url: '/web/templates',
    method: 'put',
    data: data
  })
}

// 删除质检模板管理
export function delTemplates(id) {
  return request({
    url: '/web/templates/' + id,
    method: 'delete'
  })
}

// 获取物料质检模板版本号列表
export function getVersion(itemId) {
  return request({
    url: '/web/templates/getVersion/' + itemId,
    method: 'get'
  })
}

