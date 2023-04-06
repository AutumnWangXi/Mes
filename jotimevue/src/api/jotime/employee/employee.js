import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";

// 查询员工信息列表
export function listInfo() {
  return request({
    url: '/web/employee/list',
    method: 'get'
  })
}
// 查询员工所在部门下的员工列表
export function getDeptEmployeeListInfo(query) {
  return request({
    url: '/web/employee/getInfoDeptList',
    method: 'post',
    params: query
  })
}

// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: { 'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8' },
    url: process.env.VUE_APP_BASE_API + '/print/pdf/employeeInfoLabel',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}
// 查询员工信息详细
export function getInfo(id) {
  return request({
    url: '/web/employee/' + id,
    method: 'get'
  })
}
// 查询所有员工列表
export function getInfoOptionsList() {
  return request({
    url: '/web/employee/getInfoOptionsList',
    method: 'get'
  })
}
// 新增员工信息
export function addInfo(data) {
  return request({
    url: '/web/employee/',
    method: 'post',
    data: data
  })
}

// 修改员工信息
export function updateInfo(data) {
  return request({
    url: '/web/employee',
    method: 'put',
    data: data
  })
}

// 删除员工信息
export function delInfo(id) {
  return request({
    url: '/web/employee/' + id,
    method: 'delete'
  })
}
// 删除文件
export function deleteFile(fileUrl) {
  return request({
    url: '/oss/deleteFile',
    data: fileUrl,
    method: 'Post'
  })
}
// 查询职务列表
export function getPostList() {
  return request({
    url: '/web/employee/selectPostList',
    method: 'get'
  })
}
