import request from '@/utils/request'
import axios from 'axios'
import {getToken} from '@/utils/auth'

// 查询描述：入库通知列表
export function listNotice(query) {
  return request({
    url: '/web/stockin/notice/list',
    method: 'get',
    params: query
  })
}
// 查询描述：入库通知列表
export function getlistNotice(query) {
  return request({
    url: '/web/stockin/notice/listItempkgs',
    method: 'get',
    params: query
  })
}

// 查询描述：入库通知详细
export function getNotice(id, itemId,batchNo) {
  return request({
    url: '/web/stockin/notice/' + id + '/' + itemId+ '/' + batchNo,
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
    url: '/web/stockin/notice',
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

// 修改
export function update(data) {
  return request({
    url: '/web/stockin/notice',
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

// 查询描述：入库通知列表(半成品)
export function listBySemiManufactured(data) {
  return request({
    url: '/web/stockin/itempkg/listBySemiManufactured',
    method: 'post',
    data: data
  })
}

// 查询描述：入库通知列表(成品)
export function listByFinishedProduct(data) {
  return request({
    url: '/web/stockin/itempkg/listByFinishedProduct',
    method: 'post',
    data: data
  })
}

// 查询描述：入库通知列表(内料)
export function listByFabric(data) {
  return request({
    url: '/web/stockin/itempkg/listByFabric',
    method: 'post',
    data: data
  })
}

// 清点保存
export function generalInventory(data) {
  return request({
    url: '/web/stockin/notice/generalInventory',
    method: 'put',
    data: data
  })
}

// 清点提交
export function countSubmit(data) {
  return request({
    url: '/web/stockin/notice/count',
    method: 'put',
    data: data
  })
}

// 清点提交
export function listItempkgs(data) {
  return request({
    url: '/web/stockin/notice/listItempkgs',
    method: 'get',
    params: data
  })
}

// 半成品清点提交
export function semifinishedArticleScount(data) {
  return request({
    url: '/web/stockin/notice/semifinishedArticleScount',
    method: 'put',
    data: data
  })
}

// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/purchaseWarehousing',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 打印pdf(半成品)
export function printPdfSemiManufactured(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/listSemiManufactured',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 打印pdf(成品)
export function printPdfFinishedProduct(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/printingFinishedProducts',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 打印pdf(预处理料)
export function printPdfPretreatmentOfMaterial(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/listPretreatmentOfMaterial',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob
  })
}

// 打印pdf(内料)
export function printPdfFabric(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/listFabric',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob
  })
}

// 重打pdf
export function redoPrintPdf(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
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

// 查询称重列表
export function listWeight(data) {
  return request({
    url: '/stockout/weight/list',
    method: 'post',
    data: data
  })
}

// 查询入库称重列表
export function listWeightIn(data) {
  return request({
    url: '/stockout/weight/listIn',
    method: 'post',
    data: data
  })
}

// 完成称重操作
export function addWeight(data) {
  return request({
    url: '/stockout/weight/addWeighRecord',
    method: 'post',
    data: data
  })
}

// 完成入库称重操作
export function addWeightIn(data) {
  return request({
    url: '/stockout/weight/addWeighRecordIn',
    method: 'post',
    data: data
  })
}

// 称重记录
export function getWeighListRecord(query) {
  return request({
    url: '/stockout/weight/getWeighListRecord',
    method: 'post',
    params: query
  })
}

//打印
export function printWeight(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/labelAfterInternalMaterialWeighing',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 退货退料入库列表
export function retreat(data) {
  return request({
    url: '/web/stockin/notice/retreat',
    method: 'get',
    params: data
  })
}

// 内料入库列表
export function listFabric(data) {
  return request({
    url: '/web/stockin/notice/listFabric',
    method: 'get',
    params: data
  })
}

//物料上架
export function listsCommon(data) {
  return request({
    url: '/web/stockin/location/listsCommon',
    method: 'get',
    params: data
  })
}

// 内料入库 绑定库位列表
export function Fabriclist(data) {
  return request({
    url: '/web/stockin/location/listFabric',
    method: 'get',
    params: data

  })
}

// 预处理入库列表
export function listMaterial(data) {
  return request({
    url: '/web/stockin/notice/listPretreatmentOfMaterial',
    method: 'get',
    params: data
  })
}

// 预处理入库 绑定库位列表
export function listPretreatment(data) {
  return request({
    url: '/web/stockin/location/listPretreatmentOfMaterial',
    method: 'get',
    params: data

  })
}

// 半成品入库列表
export function listSemiManu(data) {
  return request({
    url: '/web/stockin/notice/listSemiManufactured',
    method: 'get',
    params: data
  })
}

// 半成品入库  绑定库位列表
export function listSemiManufactured(data) {
  return request({
    url: '/web/stockin/location/listSemiManufactured',
    method: 'get',
    params: data
  })
}

// 成品入库列表
export function listFinishedProduct(data) {
  return request({
    url: '/web/stockin/notice/listFinishedProduct',
    method: 'get',
    params: data
  })
}

// 成品入库 绑定库位列表
export function listFinished(data) {
  return request({
    url: '/web/stockin/location/listFinishedProduct',
    method: 'get',
    params: data

  })
}

// 根据任务编号和领料单号 查询物料称重信息
export function queryMaterialWeighing(data) {
  return request({
    url: '/stockout/weight/list',
    method: 'post',
    data: data
  })
}

// 根据生产单号查询pdOrder数据
export function getPdOrderInfo(data) {
  return request({
    url: '/web/order/getPdOrderInfo',
    method: 'get',
    params: data
  })
}

// 查询全库位
export function lists() {
  return request({
    url: '/web/base/location/lists',
    method: 'get'
  })
}

// 采购清点查询全库位
export function listsByareaType() {
  return request({
    url: '/web/base/location/listsByareaType',
    method: 'get'
  })
}

// 查询全生产单列表
export function weightList(query) {
  return request({
    url: '/stockout/weight/weightList',
    method: 'get',
    params: query
  })
}

// 来源仓库
export function wareChange(data) {
  return request({
    url: '/web/stockin/location/wareChange',
    method: 'put',
    data: data
  })
}

// 来源仓库
export function wareChanges(data) {
  return request({
    url: '/web/stockin/location/wareChanges',
    method: 'put',
    data: data
  })
}

// 查询入库称重列表
export function weightInList(query) {
  return request({
    url: '/stockout/weight/stockInWeighList',
    method: 'get',
    params: query
  })
}

// 清点弹框里打印按钮操作
export function getPdfListData(data) {
  return request({
    url: '/web/stockin/notice/getPdfListData',
    method: 'post',
    data: data
  })
}

// 生产领料 一次分拣
export function ontTimeSortinLibrary(data) {
  return request({
    url: '/web/merge/ontTimeSortinLibrary',
    method: 'put',
    data: data
  })
}

// 删除清点弹框里的物料包明细
export function delItempkg(id) {
  return request({
    url: '/web/stockin/itempkg/' + id,
    method: 'delete'
  })
}

// 称重打印标签
export function getPrintInfo(data) {
  return request({
    url: '/stockout/weight/getPrintInfo',
    method: 'post',
    data: data
  })
}
