import request from '@/utils/request'

// 查询流水线信息列表
export function listLine(query) {
  return request({
    url: '/web/line/list',
    method: 'get',
    params: query
  })
}
// 查询流水线信息列表
export function listLineVo(query) {
  return request({
    url: '/web/line/listVo',
    method: 'get',
    params: query
  })
}
// 查询流水线信息详细
export function getLine(id) {
  return request({
    url: '/web/line/' + id,
    method: 'get'
  })
}

// 新增流水线信息
export function addLine(data) {
  return request({
    url: '/web/line',
    method: 'post',
    data: data
  })
}

// 修改流水线信息
export function updateLine(data) {
  return request({
    url: '/web/line',
    method: 'put',
    data: data
  })
}

// 删除流水线信息
export function delLine(id) {
  return request({
    url: '/web/line/' + id,
    method: 'delete'
  })
}
