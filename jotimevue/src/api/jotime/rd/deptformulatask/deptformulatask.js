import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";

// 查询描述：研发打样任务列表
export function listDeptFormulatask(query) {
  return request({
    url: '/web/deptFormulatask/list/work',
    method: 'Post',
    params: query
  })
}

// 班组任务列表
export function listGroupFormulatask(query) {
  return request({
    url: '/rd/group/formulatask/list/addEe',
    method: 'get',
    params: query
  })
}

// 查询对应部门员工
export function getDeptEmployee(depttaskNo, deptId, formulaNo, version) {
  return request({
    url: '/web/employee/deptEmployees/',
    method: 'Get',
    params: {
      'depttaskNo': depttaskNo,
      'deptId' : deptId,
      'formulaNo': formulaNo,
      'version' : version
    }
  })
}

// 查询对应班组员工
export function getGroupEmployee(data) {
  return request({
    url: '/rd/group/formulatask/getGroupEmployee',
    method: 'post',
    data: data
  })
}

// 查询对应部门班组
export function getDeptGroup(depttaskNo, deptId) {
  return request({
    url: '/admin/group/deptGroup/',
    method: 'Get',
    params: {
      'depttaskNo': depttaskNo,
      'deptId' : deptId
    }
  })
}

// 分配到班组
export function updateDistributionGroup(data) {
  return request({
    url: '/admin/group/distributionGroup',
    method: 'post',
    data: data
  })
}

// 查询对应部门员工
export function saveWorkInfo(data) {
  return request({
    url: '/web/workinfo/saveWorkInfo',
    method: 'Post',
    data: data
  })
}

// 保存分配员工
export function saveWorkInfoGroup(data) {
  return request({
    url: '/web/workinfo/saveWorkInfoGroup',
    method: 'Post',
    data: data
  })
}

// 取消打样单
export function updateWorkInfoStatus(data) {
  return request({
    url: '/web/deptFormulatask/updateDeptTaskStatus',
    method: 'Post',
    data: data
  })
}

// 取消打样单
export function updateDeptTask(data) {
  return request({
    url: '/web/deptFormulatask/updateDeptTask',
    method: 'Post',
    data: data
  })
}

// 判断完成任务数，如果全部完成则进行流转
export function circulationStatus(data) {
  return request({
    url: '/web/deptFormulatask/circulationStatus',
    method: 'Post',
    data: data
  })
}
// 修改实验室评估信息
export function updateLabEvaluation(data) {
  return request({
    url: '/web/deptFormulatask/labEvaluation',
    method: 'Post',
    data: data
  })
}
// 修改业务评估信息
export function updateBusEvaluation(data) {
  return request({
    url: '/web/deptFormulatask/busEvaluation',
    method: 'Post',
    data: data
  })
}
// 修改部门打样单状态(取消)
export function updateTaskCancel(data) {
  return request({
    url: '/web/deptFormulatask/taskcancel',
    method: 'Post',
    data: data
  })
}

// 修改个人打样单状态(取消)
export function updateTaskCancelWork(data) {
  return request({
    url: '/web/workinfo/taskcancel',
    method: 'Post',
    data: data
  })
}

//打印标签
export function printLabel(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/printLabel',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}


