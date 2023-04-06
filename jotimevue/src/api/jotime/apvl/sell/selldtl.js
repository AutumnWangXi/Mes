import request from '@/utils/request'

// 查询描述：销售订单申请明细列表
export function listSelldtl(query) {
  return request({
    url: '/system/selldtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：销售订单申请明细详细
export function getSelldtl(id) {
  return request({
    url: '/system/selldtl/' + id,
    method: 'get'
  })
}

// 新增描述：销售订单申请明细
export function addSelldtl(data) {
  return request({
    url: '/system/selldtl',
    method: 'post',
    data: data
  })
}

// 修改描述：销售订单申请明细
export function updateSelldtl(data) {
  return request({
    url: '/system/selldtl',
    method: 'put',
    data: data
  })
}

// 删除描述：销售订单申请明细
export function delSelldtl(id) {
  return request({
    url: '/system/selldtl/' + id,
    method: 'delete'
  })
}
