import request from '@/utils/request'
import axios from "axios";

// 查询描述：生产订单申请列表
export function listOrder(query) {
  return request({
    url: '/web/apvl/order/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产订单申请详细
export function getOrder(id) {
  return request({
    url: '/web/apvl/order/' + id,
    method: 'get'
  })
}

// 新增描述：生产订单申请
export function addOrder(data) {
  return request({
    url: '/web/apvl/order',
    method: 'post',
    data: data
  })
}

// 修改描述：生产订单申请
export function updateOrder(data) {
  return request({
    url: '/web/apvl/order',
    method: 'put',
    data: data
  })
}

// 删除描述：生产订单申请
export function delOrder(id) {
  return request({
    url: '/web/apvl/order/' + id,
    method: 'delete'
  })
}

//生产订单号查询
export function OrderSelect(data) {
  return request({
    url: '/web/apvl/order/getPdOrderNo',
    method: 'get',
    data: data
  })
}

//客户查询
export function getCustomersData(query) {
  return request({
    url: '/web/contract/getCustomersData',
    method: 'post',
    data: query
  })
}
//客户查询
export function getCustomerBomData(data) {
  return request({
    url: '/web/contract/getCustomerBomData',
    method: 'post',
    data: data
  })
}

//客户查询
export function importData(url, data, headers) {
  return axios({
    url: url,
    method: 'post',
    headers: headers,
    data: data
  })
}
//客户查询
export function getContractVer(contractNo) {
  return request({
    url: '/web/apvl/order/getContractVer/' + contractNo,
    method: 'get',
  })
}
