import request from '@/utils/request'

// 查询清线检查信息明细列表
export function listCheckinfodtl(query) {
  return request({
    url: '/web/closelinecheckinfodtl/list',
    method: 'get',
    params: query
  })
}

// 查询清线检查信息明细详细
export function getCheckinfodtl(id) {
  return request({
    url: '/web/closelinecheckinfodtl/' + id,
    method: 'get'
  })
}

// 新增清线检查信息明细
export function addCheckinfodtl(data) {
  return request({
    url: '/web/closelinecheckinfodtl',
    method: 'post',
    data: data
  })
}

// 修改清线检查信息明细
export function updateCheckinfodtl(data) {
  return request({
    url: '/web/closelinecheckinfodtl',
    method: 'put',
    data: data
  })
}

// 删除清线检查信息明细
export function delCheckinfodtl(id) {
  return request({
    url: '/web/closelinecheckinfodtl/' + id,
    method: 'delete'
  })
}
