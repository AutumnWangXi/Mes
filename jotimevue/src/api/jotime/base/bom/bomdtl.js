import request from '@/utils/request'

// 查询描述：bom管理明细列表
export function listBomdtl(query) {
  return request({
    url: '/admin/bomdtl/list',
    method: 'get',
    params: query
  })
}

// 查询所有bomNo
export function selectAllBaseBomdtl(id) {
  return request({
    url: '/web/bomdtl/selectAllBaseBomdtl/'+ id,
    method: 'get'
  })
}

// 查询描述：bom管理明细详细
export function getBomdtl(id) {
  return request({
    url: '/admin/bomdtl/' + id,
    method: 'get'
  })
}

// 新增描述：bom管理明细
export function addBomdtl(data) {
  return request({
    url: '/admin/bomdtl',
    method: 'post',
    data: data
  })
}

// 修改描述：bom管理明细
export function updateBomdtl(data) {
  return request({
    url: '/admin/bomdtl',
    method: 'put',
    data: data
  })
}

// 删除描述：bom管理明细
export function delBomdtl(id) {
  return request({
    url: '/admin/bomdtl/' + id,
    method: 'delete'
  })
}
