import request from '@/utils/request'
import axios from 'axios'
import { getToken } from '@/utils/auth'

// 查询销售子出库订单列表
export function listOrder(query) {
  return request({
    url: '/web/sell/subOrder/list',
    method: 'get',
    params: query
  })
}

// 查询销售子出库订单详细
export function getOrder(id) {
  return request({
    url: '/web/sell/subOrder/' + id,
    method: 'get'
  })
}

// 新增销售子出库订单
export function addOrder(data) {
  return request({
    url: '/web/sell/subOrder',
    method: 'post',
    data: data
  })
}

// 修改销售子出库订单
export function updateOrder(data) {
  return request({
    url: '/web/sell/subOrder',
    method: 'put',
    data: data
  })
}

// 删除销售子出库订单
export function delOrder(id) {
  return request({
    url: '/web/sell/subOrder/' + id,
    method: 'delete'
  })
}

// 出库指示单
export function outboundInstructions(data) {
  return request({
    url: '/web/sell/subOrder/outboundInstructions',
    method: 'put',
    data: data
  })
}

// 出库指示单查询
export function accordingStatusList(data) {
  return request({
    url: 'web/stockout/item/accordingStatusList',
    method: 'get',
    params: data
  })
}

// 出库指示确认
export function saveTemporaryInformation(data) {
  return request({
    url: 'web/temp/order/saveTemporaryInformation',
    method: 'put',
    data: data
  })
}

// 出库指示确认(车间领料)
export function saveTemporaryInformation1(data) {
  return request({
    url: 'web/temp/order/saveTemporaryInformation1',
    method: 'put',
    data: data
  })
}


// 打印pdf
export function printPdfByShortageDndReplenishment(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/shortageDndReplenishment',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 打印pdf
export function printPdfByProductionDelivery(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/printPdfByProductionDelivery',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/finishedProductProductionPickingList',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}
