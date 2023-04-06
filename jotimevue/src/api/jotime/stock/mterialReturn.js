import request from '@/utils/request'

// 查询描述：入库通知列表
export function listNotice(query) {
  return request({
    url: '/web/notice/mterialReturn/list',
    method: 'get',
    params: query
  })
}

// 查询描述：入库通知详细
export function getNotice(id) {
  return request({
    url: '/web/notice/mterialReturn/' + id,
    method: 'get'
  })
}
export function getNoticeM(id) {
  return request({
    url: '/web/notice/mterialReturn/getM/' + id,
    method: 'get'
  })
}

// 新增描述：入库通知
export function addNotice(data) {
  return request({
    url: '/web/notice/mterialReturn',
    method: 'post',
    data: data
  })
}
export function addNoticeM(data) {
  return request({
    url: '/web/notice/mterialReturn/addM',
    method: 'post',
    data: data
  })
}

// 修改描述：入库通知
export function updateNotice(data) {
  return request({
    url: '/web/notice/mterialReturn',
    method: 'put',
    data: data
  })
}
export function updateNoticeM(data) {
  return request({
    url: '/web/notice/mterialReturn/updateM',
    method: 'post',
    data: data
  })
}

// 删除描述：入库通知
export function delNotice(id) {
  return request({
    url: '/web/notice/mterialReturn/' + id,
    method: 'delete'
  })
}

// 查询描述：客户信息
export function getCustomer(id) {
  return request({
    url: '/web/notice/mterialReturn/customer' ,
    method: 'post',
    data: id
  })
}

export function getGoods(id) {
  return request({
    url: '/web/notice/mterialReturn/getGoods' ,
    method: 'post',
    data: id
  })
}

export function getGoodsM(id) {
  return request({
    url: '/web/notice/mterialReturn/getGoodsM' ,
    method: 'post',
    data: id
  })
}

// 查询所有班组生产任务编号
export function getGpOrdertaskNo() {
  return request({
    url: '/web/pd/ordertask/all',
    method: 'get',
  })
}

// 查询所有销售单号
export function getStockoutNoLists() {
  return request({
    url: '/web/notice/mterialReturn/getStockoutNoLists',
    method: 'get',
  })
}


// 格式
export function GS() {
  return request({
    url: '/web/notice/mterialReturn/GS',
    method: 'post'
  })
}

export function GSM() {
  return request({
    url: '/web/notice/mterialReturn/GSM',
    method: 'post'
  })
}


export function getstockoutNoList(stockoutNo) {
  return request({
    url: '/web/notice/mterialReturn/getStockoutNos',
    method: 'post',
    data: stockoutNo
  })
}
