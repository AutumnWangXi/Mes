import request from '@/utils/request'

// 查询实际生产工序列表
export function listactualProcess(query) {
  return request({
    url: '/web/actualProcess/list',
    method: 'get',
    params: query
  })
}

// 查询实际生产工序详细
export function getactualProcess(id) {
  return request({
    url: '/web/actualProcess/' + id,
    method: 'get'
  })
}

// 新增实际生产工序
export function addactualProcess(data) {
  return request({
    url: '/web/actualProcess',
    method: 'post',
    data: data
  })
}

// 修改实际生产工序
export function updateactualProcess(data) {
  return request({
    url: '/web/actualProcess',
    method: 'put',
    data: data
  })
}

// 删除实际生产工序
export function delactualProcess(id) {
  return request({
    url: '/web/actualProcess/' + id,
    method: 'delete'
  })
}
