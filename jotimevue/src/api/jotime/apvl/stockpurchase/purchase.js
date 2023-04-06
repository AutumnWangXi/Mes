import request from '@/utils/request'

// 查询描述：采购单申请列表
export function listPurchase(query) {
  return request({
    url: '/web/apvl/stockPurchase/list',
    method: 'get',
    params: query
  })
}

// 查询描述：采购单申请详细
export function getPurchase(id) {
  return request({
    url: '/web/apvl/stockPurchase/' + id,
    method: 'get'
  })
}

// 新增描述：采购单申请
export function addPurchase(data) {
  return request({
    url: '/web/apvl/stockPurchase/addSave',
    method: 'post',
    data: data
  })
}

// 修改描述：采购单申请
export function updatePurchase(data) {
  return request({
    url: '/web/apvl/stockPurchase',
    method: 'put',
    data: data
  })
}

// 删除描述：采购单申请
export function delPurchase(id) {
  return request({
    url: '/web/apvl/stockPurchase/' + id,
    method: 'delete'
  })
}

// 新增描述：订单采购列表展示
export function purchaseOrderList(query) {
  return request({
    url: '/web/purchase/needs/orderPurchaseDataDisplay',
    method: 'get',
    params: query
  })
}
// 新增描述：订单采购列表展示
export function closeRow(data) {
  return request({
    url: '/web/purchase/needs/closeRow',
    method: 'post',
    data:data
  })
}

//选择
export function okOption(data) {
  return request ({
    url:'/web/apvl/purchase/purchaseOrderSelection',
    method:'post',
    data:data
  })
}
//确认选择
export function Option(data) {
  return request ({
    url:'/web/apvl/purchase/confirmOrderPurchase',
    method:'post',
    data:data
  })
}

/**
 * 查询全部客户
 */
export function selectSupplier() {
  return request({
    url: '/web/base/supplier/selectSupplierName',
    method: 'get'
  })
}

/**
 * 查询全部客户
 */
export function getSupplierData(itemId) {
  return request({
    url: '/web/base/itemsupplier/getSupplierData/' + itemId,
    method: 'get'
  })
}
/**
 * 保存选择数据
 */
export function dataSaving(data) {
  return request({
    url: '/web/apvl/purchase/dataSaving',
    method: 'post',
    data:data
  })
}

