import request from '@/utils/request'

// 查询其他入出库单明细列表
export function listOrderdtl(query) {
  return request({
    url: '/web/orderdtl/list',
    method: 'get',
    params: query
  })
}

// 查询其他入出库单明细详细
export function getOrderdtl(id) {
  return request({
    url: '/web/orderdtl/' + id,
    method: 'get'
  })
}

// 新增其他入出库单明细
export function addOrderdtl(data) {
  return request({
    url: '/web/orderdtl',
    method: 'post',
    data: data
  })
}

// 修改其他入出库单明细
export function updateOrderdtl(data) {
  return request({
    url: '/web/orderdtl',
    method: 'put',
    data: data
  })
}

// 删除其他入出库单明细
export function delOrderdtl(id) {
  return request({
    url: '/web/orderdtl/' + id,
    method: 'delete'
  })
}
