import request from '@/utils/request'

// 查询描述：入库库位列表
export function listLocation(query) {
  return request({
    url: '/web/stockin/location/list',
    method: 'get',
    params: query
  })
}

// 查询描述：入库库位详细
export function getLocation(id) {
  return request({
    url: '/web/stockin/location/' + id,
    method: 'get'
  })
}

//退货退料绑定入库页面
export function retreat(data) {
  return request({
    url: '/web/stockin/location/retreat',
    method: 'get',
    params: data
  })
}

//退货退料物料上架
export function retreats(data) {
  return request({
    url: '/web/stockin/location/retreats',
    method: 'get',
    params: data
  })
}

// 新增描述：入库库位
export function addLocation(data) {
  return request({
    url: '/web/stockin/location',
    method: 'post',
    data: data
  })
}

// 修改描述：入库库位
export function updateLocation(data) {
  return request({
    url: '/web/stockin/location',
    method: 'put',
    data: data
  })
}

// 删除描述：入库库位
export function delLocation(id) {
  return request({
    url: '/web/stockin/location/' + id,
    method: 'delete'
  })
}

// 入库
export function warehousing(data) {
  return request({
    url: '/web/stockin/location/warehousing',
    method: 'put',
    data: data
  })
}

export function listAll(data) {
  return request({
    url: '/web/stockin/location/list',
    method: 'get',
    params: data
  })
}

export function purchaseWarehousing(data) {
  return request({
    url: '/web/stockin/location/purchaseWarehousing',
    method: 'put',
    data: data
  })
}

export function purchaseWarehousings(data) {
  return request({
    url: '/web/stockin/location/purchaseWarehousings',
    method: 'put',
    data: data
  })
}

export function lists() {
  return request({
    url: '/web/stockin/manage/lists ',
    method: 'get'
  })
}

export function selectStockinRecordList(data) {
  return request({
    url: '/web/stockin/location/selectStockinRecordList',
    method: 'get',
    params: data
  })
}

export function getMaterialsOnTheShelf(data) {
  return request({
    url: '/web/stockin/location/lists',
    method: 'get',
    params: data
  })
}

export function listBox(data) {
  return request({
    url: '/web/base/turnoverbox/listBox',
    method: 'get',
    params: data
  })
}

export function shelfMaterial(data) {
  return request({
    url: '/web/stockin/location/checkWarehousing',
    method: 'put',
    data: data
  })
}




