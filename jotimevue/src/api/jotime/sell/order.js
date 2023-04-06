import request from '@/utils/request'

// 查询销售订单列表
export function listOrder(query) {
  return request({
    url: '/web/order/dataList',
    method: 'get',
    params: query
  })
}
// 查询生产订单列表（生产管理主页）
export function listIndexOrder(query) {
  return request({
    url: '/web/order/index/list',
    method: 'get',
    params: query
  })
}
// 查询订单列表
export function getOrderList(query) {
  return request({
    url: '/web/order/list',
    method: 'get',
    params: query
  })
}
// 查询生产订单统计（生产管理主页）
export function statisticsIndexOrder() {
  return request({
    url: '/web/order/index/statistics',
    method: 'get',
  })
}


// 查询销售订单详细
export function getOrder(id) {
  return request({
    url: '/web/order/' + id,
    method: 'get'
  })
}

// 新增销售订单
export function addOrder(data) {
  return request({
    url: '/web/order',
    method: 'post',
    data: data
  })
}

// 修改销售订单
export function updateOrder(data) {
  return request({
    url: '/web/order',
    method: 'put',
    data: data
  })
}

// 删除销售订单
export function delOrder(id) {
  return request({
    url: '/web/order/' + id,
    method: 'delete'
  })
}

