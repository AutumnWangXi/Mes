import request from '@/utils/request'

// 查询班组生产任务列表(生产页面)
export function listByStatus(query) {
  return request({
    url: '/web/pd/ordertask/listByStatus',
    method: 'get',
    params: query
  })
}

// 查询描述：采购单详细
export function getOrdertask(id) {
  return request({
    url: '/web/pd/ordertask/' + id,
    method: 'get'
  })
}

// 新增描述：采购单
export function addPurchase(data) {
  return request({
    url: '/web/pd/ordertask',
    method: 'post',
    data: data
  })
}

// 修改描述：采购单
export function updatePurchase(data) {
  return request({
    url: '/web/pd/ordertask',
    method: 'put',
    data: data
  })
}

// 删除描述：采购单
export function delOrdertask(id) {
  return request({
    url: '/web/pd/ordertask/' + id,
    method: 'delete'
  })
}


// 获取采购单号
export function getItemCodes(data) {
  return request({
    url: '/web/pd/ordertask/getItemCodes',
    method: 'get',
    params: data
  })
}

// 新增描述：获取详情
export function QueryById(data) {
  return request({
    url: '/web/pd/ordertask/QueryById',
    method: 'post',
    data: data
  })
}

// 新增描述：保存
export function AddDeliveryNote(data) {
  return request({
    url: '/web/stockin/notice/AddDeliveryNotes',
    method: 'post',
    data: data
  })
}

// 新增描述：获取采购员
export function getUser(data) {
  return request({
    url: 'web/ordertask/getUser',
    method: 'get'
  })
}

// 新增描述：获取仓库id
export function getWh() {
  return request({
    url: 'web/ordertask/getWh',
    method: 'get'
  })
}

// 新增页面的复制接口
export function BatchNo() {
  return request({
    url: '/web/ordertask/BatchNo',
    method: 'get'
  })
}
