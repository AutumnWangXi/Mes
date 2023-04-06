import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";
// 查询巡检记录列表
export function listTest(query) {
  return request({
    url: '/web/ipqctest/list',
    method: 'get',
    params: query
  })
}
// 查询巡检记录列表
export function listIpqcTest(query) {
  return request({
    url: '/web/ipqctest/list',
    method: 'get',
    params: query
  })
}
// 查询巡检记录详细
export function getIpqcTest(id) {
  return request({
    url: '/web/ipqctest/' + id,
    method: 'get'
  })
}
// 查询巡检记录详细
export function getTest(id) {
  return request({
    url: '/web/ipqctest/' + id,
    method: 'get'
  })
}

// 新增巡检记录
export function addTest(data) {
  return request({
    url: '/web/ipqctest',
    method: 'post',
    data: data
  })
}
// 修改巡检记录
export function updateIpqcTest(data) {
  return request({
    url: '/web/ipqctest',
    method: 'put',
    data: data
  })
}
// 修改巡检记录
export function updateTest(data) {
  return request({
    url: '/web/ipqctest',
    method: 'put',
    data: data
  })
}

// 删除巡检记录
export function delTest(id) {
  return request({
    url: '/web/ipqctest/' + id,
    method: 'delete'
  })
}
// 查询巡检记录列表
export function getTestDatalist(query) {
  return request({
    url: '/web/ipqcdata/testlist',
    method: 'get',
    params: query
  })
}


// 巡检打印
export function print(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/patrolPrinting',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob
  })
}


// 根据班组任务号查询巡检模板
export function getIpqcTemplates(data) {
  return request({
    url: '/web/ipqctest/getIpqcTemplates',
    method: 'post',
    data: data
  })
}
