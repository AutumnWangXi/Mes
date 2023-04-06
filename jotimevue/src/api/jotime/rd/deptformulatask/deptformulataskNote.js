import request from '@/utils/request'
import axios from "axios";
import {getToken} from "@/utils/auth";

// 查询描述：研发打样任务列表
export function selectNote(data) {
  return request({
    url: '/web/eeformula/selectNote',
    method: 'Post',
    data: data
  })
}

export function editEeFormula(data) {
  return request({
    url: '/web/eeformula',
    method: 'put',
    data: data
  })
}

export function saveEeFormuladtlTab(data) {
  return request({
    url: '/web/eeformuladtl/saveEeFormuladtl',
    method: 'post',
    data: data
  })
}

// 保存配方步骤信息
export function saveEeProcessstep(data) {
  return request({
    url: '/web/rd/processstep/saveEeProcessstep',
    method: 'post',
    data: data
  })
}

// 全部保存
export function savealldataee(query) {
  return request({
    url: '/web/eeformula/savealldataee',
    method: 'post',
    data: query
  })
}

// 打印pdf
export function noteDetails(data) {
  return axios({
    method: 'post',
    headers: {'Authorization': 'Bearer ' + getToken(), 'Content-Type': 'application/json;charset=UTF-8'},
    url: process.env.VUE_APP_BASE_API + '/print/pdf/noteDetails',
    data: data,
    responseType: 'blob' // 更改responseType类型为 blob

  })
}

// 全部保存
export function selectAll(query) {
  return request({
    url: '/web/eeformula/list',
    method: 'get',
    params: query
  })
}

// 升级
export function copy(data) {
  return request({
    url: '/web/eeformula/copyEeformula',
    method: 'post',
    data: data
  })
}

// 新建配方
export function addFormula(data) {
  return request({
    url: '/web/eeformula/addFormula',
    method: 'post',
    data: data
  })
}

// 取样操作
export function sampling(data) {
  return request({
    url: '/web/eeformula/sampling',
    method: 'post',
    data: data
  })
}
