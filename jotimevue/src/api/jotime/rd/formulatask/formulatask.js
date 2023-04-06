import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";

// 查询研发打样任务列表
export function listFormulatask(query) {
  return request({
    url: '/web/formulatask/list',
    method: 'Post',
    params: query
  })
}

// 查询研发打样任务详细
export function getFormulatask(id) {
  return request({
    url: '/web/formulatask/edit/' + id,
    method: 'get'
  })
}

// 新增研发打样任务
export function addFormulatask(data) {
  return request({
    url: '/web/formulatask',
    method: 'post',
    data: data
  })
}


// 删除研发打样任务
export function delFormulatask(id) {
  return request({
    url: '/web/formulatask/' + id,
    method: 'delete'
  })
}

// 删除研发打样任务
export function selectDept(data) {
  return request({
    url: '/system/dept/selectDept/103',
    method: 'Get'
  })
}

// 删除研发打样任务
export function saveDeptTask(data) {
  return request({
    url: '/web/deptFormulatask/saveDeptTask',
    method: 'Post',
    data: data
  })
}

// 修改打样单状态(取消)
export function updateTaskCancel(data) {
  return request({
    url: '/web/formulatask/taskcancel',
    method: 'Post',
    data: data
  })
}
// 修改部门打样单状态(取消)
export function updateTaskCancelDept(data) {
  return request({
    url: '/web/deptFormulatask/taskcancel',
    method: 'Post',
    data: data
  })
}
// 打样任务修改
export function updateFormulatask(data) {
  return request({
    url: '/web/formulatask/updateFormulatask',
    method: 'Post',
    data: data
  })
}

// 打样任务评估数据修改
export function updateAssessData(data) {
  return request({
    url: '/web/formulatask/updateAssess',
    method: 'Post',
    data: data
  })
}
// 分配部门
export function updateDistributionDept(data) {
  return request({
    url: '/web/formulatask/distributionDept',
    method: 'Post',
    data: data
  })
}

// 查询文件
export function formulataskFile(data) {
  return request({
    url: '/web/formulatask/formulataskFile',
    method: 'Post',
    data: data
  })
}

// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/deptFormulaDetails',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}
