import request from '@/utils/request'

// 查询微生物检测列表
export function listQcMicrobe(query) {
  return request({
    url: '/web/qcmicrobe/list',
    method: 'get',
    params: query
  })
}

// 查询微生物检测详细
export function getQcMicrobe(id) {
  return request({
    url: '/web/qcmicrobe/' + id,
    method: 'get'
  })
}

// 新增微生物检测
export function addQcMicrobe(data) {
  return request({
    url: '/web/qcmicrobe',
    method: 'post',
    data: data
  })
}

// 修改微生物检测
export function updateQcMicrobe(data) {
  return request({
    url: '/web/qcmicrobe',
    method: 'put',
    data: data
  })
}

// 删除微生物检测
export function delQcMicrobe(id) {
  return request({
    url: '/web/qcmicrobe/' + id,
    method: 'delete'
  })
}
