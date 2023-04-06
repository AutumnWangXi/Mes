import request from '@/utils/request'

// 查询描述：缺料补料列表
export function listSupplementaries(query) {
  return request({
    url: '/web/supplementaries/list',
    method: 'get',
    params: query
  })
}
// 查询描述：缺料补料列表
export function listSupplementariesAndDtl(query) {
  return request({
    url: '/web/supplementaries/andDtllist',
    method: 'get',
    params: query
  })
}

// 查询描述：缺料补料详细
export function getSupplementaries(id) {
  return request({
    url: '/web/supplementaries/' + id,
    method: 'get'
  })
}
// 查询描述：缺料补料详细
export function getSupplementariesAndDtl(id) {
  return request({
    url: '/web/supplementaries/andDtl/' + id,
    method: 'get'
  })
}

// 新增描述：缺料补料
export function addSupplementaries(data) {
  return request({
    url: '/web/supplementaries',
    method: 'post',
    data: data
  })
}

// 修改描述：缺料补料
export function updateSupplementaries(data) {
  return request({
    url: '/web/supplementaries',
    method: 'put',
    data: data
  })
}
// 修改描述：缺料补料
export function updateSupplementariesAndDtl(data) {
  return request({
    url: '/web/supplementaries/editAndDtl',
    method: 'post',
    data: data
  })
}

// 删除描述：缺料补料
export function delSupplementaries(id) {
  return request({
    url: '/web/supplementaries/' + id,
    method: 'delete'
  })
}
//审核按钮操作
export function auditSupplementaries(row){
  return request({
    url: '/web/supplementaries/audit',
    method: 'put',
    data: row
  })
}
export function getActiveUser(){
  return request({
    url: '/web/supplementaries/getActiveUser',
    method: 'put',
  })
}

export function getActiveUserCode(){
  return request({
    url: '/web/supplementaries/getActiveUserCode',
    method: 'put',
  })
}
