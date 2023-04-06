import request from '@/utils/request'

// 查询订单出库明细列表
export function listItem(query) {
  return request({
    url: '/web/stockout/item/list',
    method: 'get',
    params: query
  })
}

// 查询订单出库明细列表
export function outboundRecordList(query) {
  return request({
    url: 'http://localhost/dev-api/web/stockout/item/outboundRecordList',
    method: 'get',
    params: query
  })
}

// 出库确认列表
export function confirmOutOfStockList(query) {
  return request({
    url: '/web/stockout/item/confirmOutOfStockList',
    method: 'get',
    params: query
  })
}

// 出库确认
export function confirmOutOfStock(id) {
  return request({
    url: '/web/stockout/item/confirmOutOfStock/' + id,
    method: 'put',
  })
}

// 根据类型查询订单出库明细列表
export function accordingStatusList(query) {
  return request({
    url: '/web/stockout/item/accordingStatusList',
    method: 'get',
    params: query
  })
}

// 查询订单出库明细详细
export function getItem(id) {
  return request({
    url: '/web/stockout/item/' + id,
    method: 'get'
  })
}

// 新增订单出库明细
export function addItem(data) {
  return request({
    url: '/web/stockout/item',
    method: 'post',
    data: data
  })
}

// 修改订单出库明细
export function updateItem(data) {
  return request({
    url: '/web/stockout/item',
    method: 'put',
    data: data
  })
}

// 删除订单出库明细
export function delItem(id) {
  return request({
    url: '/web/stockout/item/' + id,
    method: 'delete'
  })
}


// 查询订单出库明细列表
export function getStockoutList(query) {
  return request({
    url: '/web/stockout/item/getStockoutList',
    method: 'get',
    params: query
  })
}
