import request from '@/utils/request'

// 查询清线检查列表
export function listCloseline(query) {
  return request({
    url: '/web/closeline/list',
    method: 'get',
    params: query
  })
}// 查询清线检查列表
export function listAndDtl(query) {
  return request({
    url: '/web/closeline/listAndDtl',
    method: 'get',
    params: query
  })
}

// 查询清线检查详细
export function getCloseline(id) {
  return request({
    url: '/web/closeline/' + id,
    method: 'get'
  })
}
// 查询开线检查详细和对应dtl
export function getCloselineAndDtl(id) {
  return request({
    url: '/web/closeline/closelineAndDtl/' + id,
    method: 'get'
  })
}
// 新增清线检查
export function addCloseline(data) {
  return request({
    url: '/web/closeline',
    method: 'post',
    data: data
  })
}
// 新增清线检查和对应dtl
export function addCloselineAndDtl(data) {
  return request({
    url: '/web/closeline/addCloselineAndDtl',
    method: 'post',
    data: data
  })
}

// 修改清线检查
export function updateCloseline(data) {
  return request({
    url: '/web/closeline',
    method: 'put',
    data: data
  })
}
// 修改清线检查
export function updateCloselineAndDtl(data) {
  return request({
    url: '/web/closeline/editCloselineAndDtl',
    method: 'put',
    data: data
  })
}

// 删除清线检查
export function delCloseline(id) {
  return request({
    url: '/web/closeline/' + id,
    method: 'delete'
  })
}
