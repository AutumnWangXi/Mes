import request from '@/utils/request'
import {getOrdertaskByNo} from "@/api/jotime/pd/ordertask";

// 查询班组生产任务列表
export function listOrdertask(query) {
  return request({
    url: '/web/pd/ordertask/lists',
    method: 'get',
    params: query
  })
}

// 扫描生产任务编号进行学习作业指导书操作
export function getorderTaskNo(ordertaskNo) {
  return request({
    url: '/web/pd/ordertask/orderTaskNo/' + ordertaskNo,
    method: 'get'
  })
}

// 全查操作
export function allCheck(ordertaskNo) {
  return request({
    url: '/web/pd/ordertask/allCheck/' + ordertaskNo,
    method: 'get'
  })
}

// 扫描员工编码进行学习作业指导书操作
export function ordertasks(data) {
  return request({
    url: '/web/pd/ordertask/' + data.getEmployeeCode +'/'+ data.gpOrdertaskNo,
    method: 'put'
  })
}

// 扫描员工编码进行学习作业指导书操作
export function codes(data) {
  return request({
    url: '/web/pd/ordertask/codes',
    method: 'post',
    data: data
  })
}

// 审核操作
export function audit(id) {
  return request({
    url: '/web/pd/ordertask/audit/' + id,
    method: 'get'
  })
}

// 查询班组生产任务详细
export function getOrdertask(id) {
  return request({
    url: '/web/ordertask/' + id,
    method: 'get'
  })
}

// 新增班组生产任务
export function addOrdertask(data) {
  return request({
    url: '/web/ordertask',
    method: 'post',
    data: data
  })
}

// 修改班组生产任务
export function updateOrdertask(data) {
  return request({
    url: '/web/pd/ordertask/editEmployeeInfo',
    method: 'put',
    data: data
  })
}

// 删除班组生产任务
export function delOrdertask(id) {
  return request({
    url: '/web/ordertask/' + id,
    method: 'delete'
  })
}
