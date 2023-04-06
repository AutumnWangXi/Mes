import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";

// 查询车间列表
export function listWorkshop(query) {
  return request({
    url: '/web/base/workshop/list',
    method: 'get',
    params: query
  })
}

// 查询车间详细
export function getWorkshop(id) {
  return request({
    url: '/web/base/workshop/' + id,
    method: 'get'
  })
}
// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/workshopLabel',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}
// 查询车间详细
export function getWorkShopList() {
  return request({
    url: '/web/base/workshop/getWorkShopList',
    method: 'get'
  })
}
// 新增车间
export function addWorkshop(data) {
  return request({
    url: '/web/base/workshop',
    method: 'post',
    data: data
  })
}

// 修改车间
export function updateWorkshop(data) {
  return request({
    url: '/web/base/workshop',
    method: 'put',
    data: data
  })
}

// 删除车间
export function delWorkshop(id) {
  return request({
    url: '/web/base/workshop/' + id,
    method: 'delete'
  })
}
// 根据当前用户角色查询车间列表
export function getRoleWorkShopList(data) {
  return request({
    url: '/web/base/workshop/getRoleWorkShopList',
    method: 'post',
    data: data
  })
}
