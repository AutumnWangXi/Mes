import request from '@/utils/request'

// 查询放行记录列表
export function listPrg(query) {
  return request({
    url: '/web/prg/list',
    method: 'get',
    params: query
  })
}

// 查询放行记录详细
export function getPrg(id) {
  return request({
    url: '/web/prg/' + id,
    method: 'get'
  })
}

// 新增放行记录
export function addPrg(data) {
  return request({
    url: '/web/prg',
    method: 'post',
    data: data
  })
}

// 修改放行记录
export function updatePrg(data) {
  return request({
    url: '/web/prg',
    method: 'put',
    data: data
  })
}

// 删除放行记录
export function delPrg(id) {
  return request({
    url: '/web/prg/' + id,
    method: 'delete'
  })
}
