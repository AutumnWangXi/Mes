import request from '@/utils/request'

// 查询审批流程记录列表
export function listProcess(query) {
  return request({
    url: '/web/apvl/process/list',
    method: 'get',
    params: query
  })
}

// 查询审批流程记录详细
export function getProcess(id) {
  return request({
    url: '/web/apvl/process/' + id,
    method: 'get'
  })
}

// 新增审批流程记录
export function addProcess(data) {
  return request({
    url: '/web/apvl/process',
    method: 'post',
    data: data
  })
}

// 修改审批流程记录
export function updateProcess(data) {
  return request({
    url: '/web/apvl/process',
    method: 'put',
    data: data
  })
}

// 删除审批流程记录
export function delProcess(id) {
  return request({
    url: '/web/apvl/process/' + id,
    method: 'delete'
  })
}
