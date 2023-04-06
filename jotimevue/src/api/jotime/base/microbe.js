import request from '@/utils/request'

// 查询微生物检测列表
export function listBaseMicrobe(query) {
  return request({
    url: '/web/basemicrobe/list',
    method: 'get',
    params: query
  })
}

// 查询微生物检测详细
export function getBaseMicrobe(id) {
  return request({
    url: '/web/basemicrobe/' + id,
    method: 'get'
  })
}

// 新增微生物检测
export function addBaseMicrobe(data) {
  return request({
    url: '/web/basemicrobe',
    method: 'post',
    data: data
  })
}

// 修改微生物检测
export function updateBaseMicrobe(data) {
  return request({
    url: '/web/basemicrobe',
    method: 'put',
    data: data
  })
}

// 删除微生物检测
export function delBaseMicrobe(id) {
  return request({
    url: '/web/basemicrobe/' + id,
    method: 'delete'
  })
}
