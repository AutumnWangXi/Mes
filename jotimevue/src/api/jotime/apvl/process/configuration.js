import request from '@/utils/request'


// 查询审批流程配置列表
export function listConfiguration(query) {
  return request({
    url: '/admin/configuration/list',
    method: 'get',
    params: query
  })
}

// 查询审批流程配置详细
export function getConfiguration(id) {
  return request({
    url: '/admin/configuration/' + id,
    method: 'get'
  })
}

// 新增审批流程配置
export function addConfiguration(data) {
  return request({
    url: '/admin/configuration',
    method: 'post',
    data: data
  })
}

// 修改审批流程配置
export function updateConfiguration(data) {
  return request({
    url: '/admin/configuration',
    method: 'put',
    data: data
  })
}

// 删除审批流程配置
export function delConfiguration(id) {
  return request({
    url: '/admin/configuration/' + id,
    method: 'delete'
  })
}
