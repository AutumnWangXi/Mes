import request from '@/utils/request'

// 查询设备工艺参数列表
export function listProcessparam(query) {
  return request({
    url: '/web/processparam/list',
    method: 'get',
    params: query
  })
}

// 查询设备工艺参数详细
export function getProcessparam(id) {
  return request({
    url: '/web/processparam/' + id,
    method: 'get'
  })
}

// 新增设备工艺参数
export function addProcessparam(data) {
  return request({
    url: '/web/processparam',
    method: 'post',
    data: data
  })
}

// 修改设备工艺参数
export function updateProcessparam(data) {
  return request({
    url: '/web/processparam',
    method: 'put',
    data: data
  })
}

// 删除设备工艺参数
export function delProcessparam(id) {
  return request({
    url: '/web/processparam/' + id,
    method: 'delete'
  })
}
