import request from '@/utils/request'

// 查询盘点记录列表
export function listInventory(query) {
  return request({
    url: '/web/stockin/inventory/list',
    method: 'get',
    params: query
  })
}

// 查询盘点记录详细
export function getInventory(id) {
  return request({
    url: '/web/stockin/inventory/' + id,
    method: 'get'
  })
}

// 新增盘点记录
export function addInventory(data) {
  return request({
    url: '/web/stockin/inventory',
    method: 'post',
    data: data
  })
}

// 修改盘点记录
export function updateInventory(data) {
  return request({
    url: '/web/stockin/inventory/editStatus',
    method: 'put',
    data: data
  })
}

// 删除盘点记录
export function delInventory(id) {
  return request({
    url: '/web/stockin/inventory/' + id,
    method: 'delete'
  })
}

// 查询所有仓库
export function selectWarehouseName(query) {
  return request({
    url: '/web/base/warehouse/list',
    method: 'get',
    params: query
  })
}

// 查询所有库区
export function selectAreaList(query) {
  return request({
    url: '/web/base/area/list',
    method: 'get',
    params: query
  })
}

// 查询所有库位
export function selectLocationList(query) {
  return request({
    url: '/web/base/location/list',
    method: 'get',
    params: query
  })
}

// 查询所有库位
export function selectAllItem() {
  return request({
    url: '/web/base/item/selectAllItem',
    method: 'get'
  })
}

// 查询所有物料
export function listItem(data) {
  return request({
    url: '/web/stockin/inventory/listItem',
    method: 'get',
    params: data
  })
}

// 添加盘点数据
export function addItem(data) {
  return request({
    url: '/web/stockin/inventory/addItem',
    method: 'post',
    data: data
  })
}

