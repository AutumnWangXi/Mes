import request from '@/utils/request'

// 查询微生物检测内容列表
export function listBaseMicrobedtl(query) {
  return request({
    url: '/web/basemicrobedtl/list',
    method: 'get',
    params: query
  })
}

// 查询微生物检测内容详细
export function getBaseMicrobedtl(id) {
  return request({
    url: '/web/basemicrobedtl/' + id,
    method: 'get'
  })
}

// 新增微生物检测内容
export function addBaseMicrobedtl(data) {
  return request({
    url: '/web/basemicrobedtl',
    method: 'post',
    data: data
  })
}

// 修改微生物检测内容
export function updateBaseMicrobedtl(data) {
  return request({
    url: '/web/basemicrobedtl',
    method: 'put',
    data: data
  })
}

// 删除微生物检测内容
export function delBaseMicrobedtl(id) {
  return request({
    url: '/web/basemicrobedtl/' + id,
    method: 'delete'
  })
}
