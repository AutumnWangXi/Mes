import request from '@/utils/request'

// 查询描述：采购单列表
export function listPurchase(query) {
  return request({
    url: '/web/purchase/listByStatus',
    method: 'get',
    params: query
  })
}

// 查询描述：采购单详细
export function getPurchase(id) {
  return request({
    url: '/web/purchase/' + id,
    method: 'get'
  })
}

// 新增描述：采购单
export function addPurchase(data) {
  return request({
    url: '/web/purchase',
    method: 'post',
    data: data
  })
}

// 修改描述：采购单
export function updatePurchase(data) {
  return request({
    url: '/web/purchase',
    method: 'put',
    data: data
  })
}

// 删除描述：采购单
export function delPurchase(id) {
  return request({
    url: '/web/purchase/' + id,
    method: 'delete'
  })
}


// 获取采购单号
export function getItemCodes(data) {
  return request({
    url: '/web/purchase/getItemCodes',
    method: 'get',
    params: data
  })
}

// 新增描述：获取详情
export function QueryById(data) {
  return request({
    url: '/web/purchase/QueryById',
    method: 'post',
    data: data
  })
}

// 新增描述：保存
export function AddDeliveryNote(data) {
  return request({
    url: '/web/stockin/notice/AddDeliveryNote',
    method: 'post',
    data: data
  })
}

// 新增描述：获取采购员
export function getUser(data) {
  return request({
    url: 'web/purchase/getUser',
    method: 'get'
  })
}

// 新增描述：获取仓库id
export function getWh() {
  return request({
    url: 'web/purchase/getWh',
    method: 'get'
  })
}

// 新增页面的复制接口
export function BatchNo() {
  return request({
    url: '/web/purchase/BatchNo',
    method: 'get'
  })
}

// 列表关闭按钮
export function closeTheTaskList(data) {
  return request({
    url: 'web/purchase/closeTheTaskList',
    method: 'put',
    data: data
  })
}

// 展开行列表关闭按钮
export function purchasedtlStatusRevise(data) {
  return request({
    url: '/web/purchasedtl/purchasedtlStatusRevise',
    method: 'put',
    data: data
  })
}
