import request from '@/utils/request'

// 查询制造商列表
export function listMfrs(query) {
  return request({
    url: '/web/base/mfrs/list',
    method: 'get',
    params: query
  })
}

// 查询制造商详细
export function getMfrs(id) {
  return request({
    url: '/web/base/mfrs/' + id,
    method: 'get'
  })
}

// 新增制造商
export function addMfrs(data) {
  return request({
    url: '/web/base/mfrs',
    method: 'post',
    data: data
  })
}

// 修改制造商
export function updateMfrs(data) {
  return request({
    url: '/web/base/mfrs',
    method: 'put',
    data: data
  })
}

// 删除制造商
export function delMfrs(id) {
  return request({
    url: '/web/base/mfrs/' + id,
    method: 'delete'
  })
}
