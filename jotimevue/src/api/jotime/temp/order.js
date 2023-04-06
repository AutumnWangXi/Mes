import request from '@/utils/request'

// 查询订单出库明细临时列表
export function listOrder(query) {
  return request({
    url: '/web/temp/order/list',
    method: 'get',
    params: query
  })
}

// 查询订单出库明细临时详细
export function getOrder(id) {
  return request({
    url: '/web/temp/order/' + id,
    method: 'get'
  })
}

// 新增订单出库明细临时
export function addOrder(data) {
  return request({
    url: '/web/temp/order',
    method: 'post',
    data: data
  })
}

// 修改订单出库明细临时
export function updateOrder(data) {
  return request({
    url: '/web/temp/order',
    method: 'put',
    data: data
  })
}

// 删除订单出库明细临时
export function delOrder(id) {
  return request({
    url: '/web/temp/order/' + id,
    method: 'delete'
  })
}
