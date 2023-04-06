import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";

// 查询库区列列表
export function listArea(query) {
  return request({
    url: '/web/base/area/list',
    method: 'get',
    params: query
  })
}
// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/warehouseareaLabel',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}
// 查询库区列详细
export function getArea(id) {
  return request({
    url: '/web/base/area/' + id,
    method: 'get'
  })
}
export function getAreaList(warehouseId){
  return request({
    url: '/web/base/area/getAreaList/' + warehouseId,
    method: 'get'
  })
}
// 新增库区列
export function addArea(data) {
  return request({
    url: '/web/base/area',
    method: 'post',
    data: data
  })
}

// 修改库区列
export function updateArea(data) {
  return request({
    url: '/web/base/area',
    method: 'put',
    data: data
  })
}

// 删除库区列
export function delArea(id) {
  return request({
    url: '/web/base/area/' + id,
    method: 'delete'
  })
}
