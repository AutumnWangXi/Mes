import request from '@/utils/request'
import axios from 'axios'
import {getToken} from '../../../../utils/auth'

// 查询审批共通列表
export function listCommon(query) {
  return request({
    // url: '/web/apvl/common/list',
    url: '/web/apvl/common/pendingIntegrationList',
    method: 'get',
    params: query
  })
}

//根据登录ID查询已处理审批数据
export function processedList(query) {
  return request({
    url: '/web/apvl/common/processedList',
    method: 'get',
    params: query
  })
}


// 查询审批共通详细
export function getCommon(id) {
  return request({
    url: '/web/apvl/common/getInFo/' + id,
    method: 'get'
  })
}

// 新增审批共通
export function addCommon(data) {
  return request({
    url: '/web/apvl/common',
    method: 'post',
    data: data
  })
}


// 修改审批共通
export function updateCommon(data) {
  return request({
    url: '/web/apvl/common',
    method: 'put',
    data: data
  })
}

// 删除审批共通
export function delCommon(data) {
  return request({
    url: '/web/apvl/common',
    method: 'delete',
    data: data
  })
}


// 审批页面弹窗
export function editDialog(id) {
  return request({
    url: '/web/common/getInFo/' + id,
    method: 'get'
  })
}


// 审批页面弹窗按钮
export function showDialog(apvlNo) {
  return request({
    url: '/web/apvl/common/showApvlDetails/'+ apvlNo,
    method: 'get'
  })
}

// 审批保存
export function approveSave(data) {
  return request({
    url: '/web/apvl/common/approveSave',
    method: 'put',
    data: data
  })
}

// 查询抄送人
export function sysUserList(query) {
  return request({
    url: '/web/apvl/common/sysUserList',
    method: 'get',
    params: query
  })
}


// 评论提交接口
export function commonList(data) {
  return request({
    url: '/web/apvl/common/saveComment',
    method: 'put',
    data: data
  })
}

// 我发起的
export function selectInitiatedList(query) {
  return request({
    url: '/web/apvl/common/selectInitiatedList',
    method: 'get',
    params: query
  })
}

// 我收到的
export function selectMyReceivedList(query) {
  return request({
    url: '/web/apvl/common/selectMyReceivedList',
    method: 'get',
    params: query
  })
}


// 待处理跳转
export function apvlTypeData(apvlType) {
  return request({
    url: '/web/apvl/common/pendingIntegrationList/' + apvlType,
    method: 'get',
  })
}

// 右上角记录数的接口
export function numberOf() {
  return request({
    url: '/web/apvl/common/numberOfBubblesList',
    method: 'get',
  })
}

// 抄送人接口
export function getCcTo(apvlNo) {
  return request({
    url: '/web/apvl/common/getCcTo/' + apvlNo,
    method: 'get',
  })
}

// 根据审批编号查询审批流程记录
export function getAllApvlProcessList(apvlNo) {
  return request({
    url: '/web/apvl/process/apvlProcessList/' + apvlNo,
    method: 'get',
  })
}

// 打印pdf
export function printPdf(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/approvalDetails',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}
