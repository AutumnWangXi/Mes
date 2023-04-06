import request from '@/utils/request'

// 查询描述：生产订单详情列表
export function listOrderdtl(query) {
  return request({
    url: '/web/pd/orderdtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产订单详情详细
export function getOrderdtl(id) {
  return request({
    url: '/web/pd/orderdtl/' + id,
    method: 'get'
  })
}

// 新增描述：生产订单详情
export function addOrderdtl(data) {
  return request({
    url: '/web/pd/orderdtl',
    method: 'post',
    data: data
  })
}

// 修改描述：生产订单详情
export function updateOrderdtl(data) {
  return request({
    url: '/web/pd/orderdtl',
    method: 'put',
    data: data
  })
}

// 删除描述：生产订单详情
export function delOrderdtl(id) {
  return request({
    url: '/web/pd/orderdtl/' + id,
    method: 'delete'
  })
}
