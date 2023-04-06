import request from '@/utils/request'

// 查询其他入出库单明细列表
export function listOrder(query) {
  return request({
    url: '/web/other/order/list',
    method: 'get',
    params: query
  })
}

// 查询其他入出库单明细列表
export function listOrderOut(query) {
  return request({
    url: '/web/other/order/listOut',
    method: 'get',
    params: query
  })
}

// 查询其他入出库单明细详细
export function getOrder(id) {
  return request({
    url: '/web/other/order/' + id,
    method: 'get'
  })
}

// 新增其他入出库单明细
export function addOrder(data) {
  return request({
    url: '/web/other/order',
    method: 'post',
    data: data
  })
}

// 新增其他入出库单明细
export function addOrderOut(data) {
  return request({
    url: '/web/other/order/out',
    method: 'post',
    data: data
  })
}

// 修改其他入库单明细
export function updateOrder(data) {
  return request({
    url: '/web/other/order',
    method: 'put',
    data: data
  })
}

// 修改其他出库单明细
export function updateOrderOut(data) {
  return request({
    url: '/web/other/order/out',
    method: 'put',
    data: data
  })
}

// 删除其他入出库单明细
export function delOrder(id) {
  return request({
    url: '/web/other/order/' + id,
    method: 'delete'
  })
}

//格式
export function GS() {
  return request({
    url: '/web/other/order/GS',
    method: 'post'
  })
}

export function allItem(str) {
  return request({
    url: '/web/other/order/allItem',
    method: 'post',
    data: str
  })
}

//其他出库指示列表
export function outboundInstructionsList(data) {
  return request({
    url: '/web/other/order/outboundList',
    method: 'get',
    params: data
  })
}

//其他出库指示列表
export function outboundInstructions(data) {
  return request({
    url: '/web/other/order/outboundInstructions',
    method: 'post',
    data: data
  })
}

//仓库出库指示列表
export function otherOutboundRecordList(data) {
  return request({
    url: '/web/stockout/item/otherOutboundRecordList',
    method: 'get',
    params: data
  })
}

//分拣任务指示列表
export function otherSortingList(data) {
  return request({
    url: '/web/merge/otherSortingList',
    method: 'get',
    params: data
  })
}
