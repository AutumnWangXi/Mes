import request from '@/utils/request'

// 查询清线检查信息列表
export function listCheckinfo(query) {
  return request({
    url: '/web/closelinecheckinfo/list',
    method: 'get',
    params: query
  })
}
// 查询清线检查信息列表
export function listCheckinfoVo(query) {
  return request({
    url: '/web/closelinecheckinfo/listVo',
    method: 'get',
    params: query
  })
}
// 查询清线检查信息详细
export function getCheckinfo(id) {
  return request({
    url: '/web/closelinecheckinfo/' + id,
    method: 'get'
  })
}

// 新增清线检查信息
export function addCheckinfo(data) {
  return request({
    url: '/web/closelinecheckinfo',
    method: 'post',
    data: data
  })
}
// 新增清线检查信息
export function insertPdCloselineCheckinfoAndDtl(data) {
  return request({
    url: '/web/closelinecheckinfo/insertPdCloselineCheckinfoAndDtl',
    method: 'post',
    data: data
  })
}

// 修改清线检查信息
export function updateCheckinfo(data) {
  return request({
    url: '/web/closelinecheckinfo',
    method: 'put',
    data: data
  })
}

// 删除清线检查信息
export function delCheckinfo(id) {
  return request({
    url: '/web/closelinecheckinfo/' + id,
    method: 'delete'
  })
}
// 审核清线检查信息
export function auditCheckinfo(id) {
  return request({
    url: '/web/closelinecheckinfo/auditCheckinfo/'+id ,
    method: 'delete'
  })
}
