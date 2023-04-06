import request from '@/utils/request'

//一次分拣列表
export function sellSortingList(query) {
  return request({
    url: '/web/merge/sellSortingList',
    method: 'get',
    params: query
  })
}

//执行一次分拣
export function firstSorting(data) {
  return request({
    url: '/web/merge/firstSorting',
    method: 'put',
    data: data
  })
}

//二次分拣查询数据
export function secondSortingList(orderNo) {
  return request({
    url: '/web/stockout/item/secondSortingList/' + orderNo,
    method: 'get'
  })
}

//根据条形码或物料箱查询数据
export function barcodeData(data) {
  return request({
    url: '/web/stockout/item/barcodeData',
    method: 'get',
    params: data
  })
}

//二次分拣确认
export function secondSorting(data) {
  return request({
    url: '/web/stockout/item/secondSorting',
    method: 'put',
    data: data
  })
}

//出库列表
export function toBeDeliveredList(data) {
  return request({
    url: '/web/stockout/item/toBeDeliveredList',
    method: 'get',
    params: data
  })
}

//生产出库指示列表
export function outboundInstructionsList(data) {
  return request({
    url: '/web/pd/ordertask/outboundInstructionsList',
    method: 'get',
    params: data
  })
}

//生产-出库列表
export function productionOutboundRecordList(data) {
  return request({
    url: 'web/stockout/item/productionOutboundRecordList',
    method: 'get',
    params: data
  })
}

//出库
export function outWarehouse(data) {
  return request({
    url: '/web/stockout/item/outWarehouse',
    method: 'put',
    data: data
  })
}

//生产出库一次分拣列表
export function productionSortingList(data) {
  return request({
    url: '/web/merge/productionSortingList',
    method: 'get',
    params: data
  })
}

//缺料补料 出库指示列表
export function outboundList(data) {
  return request({
    url: '/web/supplementaries/outboundList',
    method: 'get',
    params: data
  })
}

//缺料补料一次分拣
export function supplementariesSortingList(data) {
  return request({
    url: '/web/merge/supplementariesSortingList',
    method: 'get',
    params: data
  })
}

//缺料补料出库指示确认
export function outboundInstructions(data) {
  return request({
    url: '/web/merge/outboundInstructions',
    method: 'put',
    data: data
  })
}

//缺料补料出库指示确认
export function supplementariesOutboundRecordList(data) {
  return request({
    url: '/web/stockout/item/supplementariesOutboundRecordList',
    method: 'get',
    params: data
  })
}
//缺料补料一次分拣
export function ontTimeSortinProductionSortingList(data) {
  return request({
    url: '/web/merge/ontTimeSortinProductionSortingList',
    method: 'get',
    params: data
  })
}

//缺料补料一次分拣
export function twoTimeSortinProductionSortingList(data) {
  return request({
    url: '/web/merge/twoTimeSortinProductionSortingList',
    method: 'get',
    params: data
  })
}
//移库 移动待出库
export function ontTimeSortinLibrary(data) {
  return request({
    url: '/web/merge/ontTimeSortinLibrary',
    method: 'put',
    data: data
  })
}


