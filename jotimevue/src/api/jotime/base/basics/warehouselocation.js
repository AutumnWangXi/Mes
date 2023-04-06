import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";

// 查询库位列列表
export function listLocation(query) {
  return request({
    url: '/web/base/location/list',
    method: 'get',
    params: query
  })
}
// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/warehouselocationLabel',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}
// 查询库位列详细
export function getLocation(id) {
  return request({
    url: '/web/base/location/' + id,
    method: 'get'
  })
}

// 新增库位列
export function addLocation(data) {
  return request({
    url: '/web/base/location',
    method: 'post',
    data: data
  })
}

// 修改库位列
export function updateLocation(data) {
  return request({
    url: '/web/base/location',
    method: 'put',
    data: data
  })
}

// 删除库位列
export function delLocation(id) {
  return request({
    url: '/web/base/location/' + id,
    method: 'delete'
  })
}
//查询库位根据库区
export function selectArea(id) {
  return request({
    url: '/web/base/location/selectByArea/' + id,
    method: 'get'
  })
}
//查询库位根据库区
export function selectAreaType(areaType, areaId) {
  return request({
    url: '/web/base/location/selectByAreaType/' + areaType + '/' + areaId,
    method: 'get'
  })
}
//改仓库库区
export function editWarehouses(data) {
  return request({
    url: '/web/base/location/editWarehouse',
    method: 'put',
    data: data
  })
}
