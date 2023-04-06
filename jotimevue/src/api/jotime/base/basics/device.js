import request from '@/utils/request'
import {praseStrEmpty} from "@/utils/ruoyi";
import axios from "axios";
import {getToken} from "@/utils/auth";


// 查询设备信息列表
export function listDevice(query) {
  return request({
    url: '/web/base/device/list',
    method: 'get',
    params: query
  })
}
// 查询设备信息列表
export function listDeviceVo(query) {
  return request({
    url: '/web/base/device/listVo',
    method: 'get',
    params: query
  })
}
// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/deviceLabel',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}
// 查询设备信息详细
export function getDevice(id) {
  return request({
    url: '/web/base/device/' + praseStrEmpty(id),
    method: 'get'
  })
}

// 新增设备信息
export function addDevice(data) {
  return request({
    url: '/web/base/device',
    method: 'post',
    data: data
  })
}

// 修改设备信息
export function updateDevice(data) {
  return request({
    url: '/web/base/device',
    method: 'put',
    data: data
  })
}

// 删除设备信息
export function delDevice(id) {
  return request({
    url: '/web/base/device/' + id,
    method: 'delete'
  })
}
