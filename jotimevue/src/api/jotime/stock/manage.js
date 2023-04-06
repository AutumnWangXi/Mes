import request from '@/utils/request'

// 查询库存管理列表
export function listManage(query) {
  return request({
    url: '/web/stockin/manage/list',
    method: 'get',
    params: query
  })
}

// 根据合同编号和版本号查询库存
export function selectStockManage(query) {
  return request({
    url: '/web/stockin/manage/selectStockManage',
    method: 'post',
    data: query
  })
}


// 查询库存管理列表
export function listManageUnrepeated(query) {
  return request({
    url: '/web/stockin/manage/listUnrepeated',
    method: 'get',
    params: query
  })
}

// 查询库存管理详细
export function getManage(id) {
  return request({
    url: '/web/stockin/manage/' + id,
    method: 'get'
  })
}

// 新增库存管理
export function addManage(data) {
  return request({
    url: '/web/stockin/manage',
    method: 'post',
    data: data
  })
}

// 修改库存管理
export function updateManage(data) {
  return request({
    url: '/web/stockin/manage',
    method: 'put',
    data: data
  })
}

// 删除库存管理
export function delManage(id) {
  return request({
    url: '/web/stockin/manage/' + id,
    method: 'delete'
  })
}

// 移库管理
export function moveManage(data) {
  return request({
    url: '/web/stockin/manage/move',
    method: 'put',
    data: data
  })
}

// 移库库位信息
export function getMoveManage(data) {
  return request({
    url: '/web/stockin/manage/move/code',
    method: 'post',
    data: data
  })
}
// 查询库存信息
export function getStockManage(query) {
  return request({
    url: '/web/stockin/manage/getStockManage',
    method: 'get',
    params: query
  })
}

//查询库位根据库区
export function selectStockManageData(data) {
  return request({
    url: '/web/stockin/manage/selectStockManageData',
    method: 'Post',
    data: data
  })
}
//根据物料查询仓库物料库存合计信息
export function getStockSumInfo(data) {
  return request({
    url: '/web/stockin/manage/stockSumInfo',
    method: 'get',
    params: data
  })
}
