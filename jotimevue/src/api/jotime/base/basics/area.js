import request from '@/utils/request'

// 查询库区列列表
export function listArea(query) {
  return request({
    url: '/web/base/area/list',
    method: 'get',
    params: query
  })
}

// 查询库区列详细
export function getArea(id) {
  return request({
    url: '/web/base/area/' + id,
    method: 'get'
  })
}

// 新增库区列
export function addArea(data) {
  return request({
    url: '/web/base/area',
    method: 'post',
    data: data
  })
}

// 修改库区列
export function updateArea(data) {
  return request({
    url: '/web/base/area',
    method: 'put',
    data: data
  })
}

// 删除库区列
export function delArea(id) {
  return request({
    url: '/web/base/area/' + id,
    method: 'delete'
  })
}
