import request from '@/utils/request'

// 查询描述：bom管理列表
export function listBom(query) {
  return request({
    url: '/web/bom/list',
    method: 'get',
    params: query
  })
}

// 查询描述：bom管理详细
export function getBom(id) {
  return request({
    url: '/web/bom/' + id,
    method: 'get'
  })
}

// 新增描述：bom管理
export function addBom(data) {
  return request({
    url: '/web/bom',
    method: 'post',
    data: data
  })
}

// 修改描述：bom管理
export function updateBom(data) {
  return request({
    url: '/web/bom',
    method: 'put',
    data: data
  })
}

// 删除描述：bom管理
export function delBom(id) {
  return request({
    url: '/web/bom/' + id,
    method: 'delete'
  })
}
