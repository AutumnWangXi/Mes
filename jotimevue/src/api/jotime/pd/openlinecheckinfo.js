import request from '@/utils/request'

// 查询描述：开线检查信息列表
export function listOpenlinecheckinfo(query) {
  return request({
    url: '/web/openlinecheckinfo/list',
    method: 'get',
    params: query
  })
}
// 查询描述：开线检查信息列表
export function listOpenlinecheckinfoVo(query) {
  return request({
    url: '/web/openlinecheckinfo/listVo',
    method: 'get',
    params: query
  })
}
// 查询描述：生产任务信息列表
export function listOrdertask(query) {
  return request({
    url: '/web/ordertask/list',
    method: 'get',
    params: query
  })
}
// 查询描述：开线检查信息详细
export function getOpenlinecheckinfo(id) {
  return request({
    url: '/web/openlinecheckinfo/' + id,
    method: 'get'
  })
}

// 新增描述：开线检查信息
export function addOpenlinecheckinfo(data) {
  return request({
    url: '/web/openlinecheckinfo',
    method: 'post',
    data: data
  })
}
// 新增描述：开线检查信息
export function insertPdOpenlineCheckinfoAndDtl(data) {
  return request({
    url: '/web/openlinecheckinfo/insertPdOpenlineCheckinfoAndDtl',
    method: 'post',
    data: data
  })
}

// 修改描述：开线检查信息
export function updateOpenlinecheckinfo(data) {
  return request({
    url: '/web/openlinecheckinfo',
    method: 'put',
    data: data
  })
}

// 删除描述：开线检查信息
export function delOpenlinecheckinfo(id) {
  return request({
    url: '/web/openlinecheckinfo/' + id,
    method: 'delete'
  })
}
// 审核清线检查信息
export function auditCheckinfo(id) {
  return request({
    url: '/web/openlinecheckinfo/auditCheckinfo/'+id ,
    method: 'delete'
  })
}

// 查询描述：查询开线结果
export function getOpenlinecheckresult(query) {
  return request({
    url: '/web/openlinecheckinfo/openlinecheckresult',
    method: 'post',
    params: query
  })
}

// 开线班组列表
export function openLineList() {
  return request({
    url: '/web/pd/ordertask/openLineList',
    method: 'post',
  })
}
