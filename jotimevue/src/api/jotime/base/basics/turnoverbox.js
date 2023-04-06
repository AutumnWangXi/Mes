import request from '@/utils/request'

// 查询周转箱列表
export function listBox(query) {
  return request({
    url: '/web/base/turnoverbox/list',
    method: 'get',
    params: query
  })
}

// 查询周转箱详细
export function getBox(id) {
  return request({
    url: '/web/base/turnoverbox/' + id,
    method: 'get'
  })
}

// 新增周转箱
export function addBox(data) {
  return request({
    url: '/web/base/turnoverbox',
    method: 'post',
    data: data
  })
}

// 修改周转箱
export function updateBox(data) {
  return request({
    url: '/web/base/turnoverbox',
    method: 'put',
    data: data
  })
}

// 删除周转箱
export function delBox(id) {
  return request({
    url: '/web/base/turnoverbox/' + id,
    method: 'delete'
  })
}
