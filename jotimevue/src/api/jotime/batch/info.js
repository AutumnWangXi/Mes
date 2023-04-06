import request from '@/utils/request'

// 查询描述：批次号列表
export function listInfo(query) {
  return request({
    url: '/web/info/list',
    method: 'get',
    params: query
  })
}

// 查询描述：批次号详细
export function getInfo(id) {
  return request({
    url: '/web/info/' + id,
    method: 'get'
  })
}

// 新增描述：批次号
export function addInfo(data) {
  return request({
    url: '/web/info',
    method: 'post',
    data: data
  })
}

// 修改描述：批次号
export function updateInfo(data) {
  return request({
    url: '/web/info',
    method: 'put',
    data: data
  })
}

// 删除描述：批次号
export function delInfo(id) {
  return request({
    url: '/web/info/' + id,
    method: 'delete'
  })
}
