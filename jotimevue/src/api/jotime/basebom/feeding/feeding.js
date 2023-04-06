import request from '@/utils/request'

// 查询描述：投料列表
export function listFeeding(query) {
  return request({
    url: '/web/feeding/list',
    method: 'get',
    params: query
  })
}

// 查询描述：投料详细
export function getFeeding(id) {
  return request({
    url: '/web/feeding/' + id,
    method: 'get'
  })
}

// 新增描述：投料
export function addFeeding(data) {
  return request({
    url: '/web/feeding',
    method: 'post',
    data: data
  })
}

// 修改描述：投料
export function updateFeeding(data) {
  return request({
    url: '/web/feeding',
    method: 'put',
    data: data
  })
}

// 删除描述：投料
export function delFeeding(id) {
  return request({
    url: '/web/feeding/' + id,
    method: 'delete'
  })
}
