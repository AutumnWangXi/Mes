import request from '@/utils/request'

// 查询描述：bom管理明细列表
export function listBomdtl(query) {
  return request({
    url: '/web/bomdtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：bom管理明细详细
export function getBomdtl(id) {
  return request({
    url: '/web/bomdtl/' + id,
    method: 'get'
  })
}

// 新增描述：bom管理明细
export function addBomdtl(data) {
  return request({
    url: '/web/bomdtl',
    method: 'post',
    data: data
  })
}

// 修改描述：bom管理明细
export function updateBomdtl(data) {
  return request({
    url: '/web/bomdtl',
    method: 'put',
    data: data
  })
}

// 删除描述：bom管理明细
export function delBomdtl(id) {
  return request({
    url: '/web/bomdtl/' + id,
    method: 'delete'
  })
}
