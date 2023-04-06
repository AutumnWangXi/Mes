import request from '@/utils/request'

// 查询审批流程名称列表
export function listModule(query) {
  return request({
    url: '/admin/module/list',
    method: 'get',
    params: query
  })
}
// 查询流程列表
export function getModuleList() {
  return request({
    url: '/admin/module/getModuleList',
    method: 'get'
  })
}
// 查询审批流程名称详细
export function getModule(id) {
  return request({
    url: '/admin/module/' + id,
    method: 'get'
  })
}

// 新增审批流程名称
export function addModule(data) {
  return request({
    url: '/admin/module',
    method: 'post',
    data: data
  })
}

// 修改审批流程名称
export function updateModule(data) {
  return request({
    url: '/admin/module',
    method: 'put',
    data: data
  })
}

// 删除审批流程名称
export function delModule(id) {
  return request({
    url: '/admin/module/' + id,
    method: 'delete'
  })
}
