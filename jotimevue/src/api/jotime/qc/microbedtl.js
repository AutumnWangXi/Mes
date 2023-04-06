import request from '@/utils/request'

// 查询微生物检测内容列表
export function listQcMicrobedtl(query) {
  return request({
    url: '/web/qcmicrobedtl/list',
    method: 'get',
    params: query
  })
}

// 查询微生物检测内容详细
export function getQcMicrobedtl(id) {
  return request({
    url: '/web/qcmicrobedtl/' + id,
    method: 'get'
  })
}

// 新增微生物检测内容
export function addQcMicrobedtl(data) {
  return request({
    url: '/web/qcmicrobedtl',
    method: 'post',
    data: data
  })
}

// 修改微生物检测内容
export function updateQcMicrobedtl(data) {
  return request({
    url: '/web/qcmicrobedtl',
    method: 'put',
    data: data
  })
}

// 删除微生物检测内容
export function delQcMicrobedtl(id) {
  return request({
    url: '/web/qcmicrobedtl/' + id,
    method: 'delete'
  })
}
