import request from '@/utils/request'
import axios from 'axios'
import { getToken } from '@/utils/auth'

// 查询描述：入库通知列表
export function listNotice(query) {
  return request({
    url: '/web/stockin/notice/list',
    method: 'get',
    params: query
  })
}

// 查询描述：入库通知详细
export function getNotice(id) {
  return request({
    url: '/web/stockin/notice/' + id,
    method: 'get'
  })
}

// 新增描述：入库通知
export function addNotice(data) {
  return request({
    url: '/web/stockin/notice',
    method: 'post',
    data: data
  })
}

// 修改描述：入库通知
export function updateNotice(data) {
  return request({
    url: '/web/stockin/notice/generalInventory',
    method: 'put',
    data: data
  })
}

// 删除描述：入库通知
export function delNotice(id) {
  return request({
    url: '/web/stockin/notice/' + id,
    method: 'delete'
  })
}

// 查询描述：入库通知列表
export function listPrint(query) {
  return request({
    url: '/web/stockin/notice/printList',
    method: 'get',
    params: query
  })
}

// 查询描述：入库通知列表
export function inventory(data) {
  return request({
    url: '/web/stockin/notice/inventory',
    method: 'put',
    data: data
  })
}

// 查询描述：入库通知列表
export function listByPrintData(data) {
  return request({
    url: '/web/stockin/itempkg/listByPrintData',
    method: 'post',
    data: data
  })
}

// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/purchaseWarehousing',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 重打pdf
export function redoPrintPdf(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/redo',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 打印pdf
export function selectPrintHistory(data) {
  return request({
    url: '/print/history/selectPrintHistory',
    method: 'post',
    data: data
  })
}

// 查询入库通知单
export function getStockinNoticeInfo(data) {
  return request({
    url: '/web/stockin/notice/getStockinNoticeInfo',
    method: 'post',
    data: data
  })
}
