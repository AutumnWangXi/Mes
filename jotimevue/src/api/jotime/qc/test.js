import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";
// 查询质检记录列表
export function listTest(query) {
  return request({
    url: '/web/test/list',
    method: 'get',
    params: query
  })
}

// 查询质检记录详细
export function getTest(id) {
  return request({
    url: '/web/test/' + id,
    method: 'get'
  })
}

// 新增质检记录
export function addTest(data) {
  return request({
    url: '/web/test',
    method: 'post',
    data: data
  })
}

// 修改质检记录
export function updateTest(data) {
  return request({
    url: '/web/test',
    method: 'put',
    data: data
  })
}

// 删除质检记录
export function delTest(id) {
  return request({
    url: '/web/test/' + id,
    method: 'delete'
  })
}

export function getQcTestDtl(query) {
  return request({
    url: '/web/test/getQcTestDtl',
    method: 'get',
    params: query
  })
}

// 质检打印
export function print(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/qcPrinting',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob
  })
}
// 修改质检记录
export function updateTestDataList(data) {
  return request({
    url: '/web/test/updateTestDataList',
    method: 'post',
    data: data
  })
}
