import request from '@/utils/request'

// 查询单位转换列表
export function listMap(query) {
  return request({
    url: '/web/base/unit/list',
    method: 'get',
    params: query
  })
}

// 查询单位转换详细
export function getMap(id) {
  return request({
    url: '/web/base/unit/' + id,
    method: 'get'
  })
}

// 新增单位转换
export function addMap(data) {
  return request({
    url: '/web/base/unit',
    method: 'post',
    data: data
  })
}

// 修改单位转换
export function updateMap(data) {
  return request({
    url: 'web/base/unit',
    method: 'put',
    data: data
  })
}

// 删除单位转换
export function delMap(id) {
  return request({
    url: '/web/base/unit/' + id,
    method: 'delete'
  })
}
