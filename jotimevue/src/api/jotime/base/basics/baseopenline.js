import request from '@/utils/request'

// 查询开线检查列表
export function listBaseopenline(query) {
  return request({
    url: '/web/baseopenline/list',
    method: 'get',
    params: query
  })
}// 查询开线检查列表和dtl
export function listOpenlineAndDtl(query) {
  return request({
    url: '/web/baseopenline/listOpenline',
    method: 'get',
    params: query
  })
}

// 查询开线检查详细
export function getBaseopenline(id) {
  return request({
    url: '/web/baseopenline/' + id,
    method: 'get'
  })
}
// 查询开线检查详细和对应dtl
export function getOpenline(id) {
  return request({
    url: '/web/baseopenline/getOpenline/' + id,
    method: 'get'
  })
}

// 新增开线检查
export function addBaseopenline(data) {
  return request({
    url: '/web/baseopenline',
    method: 'post',
    data: data
  })
}
// 新增开线检查和对应dtl
export function addOpenline(data) {
  return request({
    url: '/web/baseopenline/addOpenlineVo',
    method: 'post',
    data: data
  })
}

// 修改开线检查
export function updateBaseopenline(data) {
  return request({
    url: '/web/baseopenline',
    method: 'put',
    data: data
  })
}
// 修改开线检查和对应dtl
export function updateOpenline(data) {
  return request({
    url: '/web/baseopenline/updateOpenline',
    method: 'put',
    data: data
  })
}

// 删除开线检查
export function delBaseopenline(id) {
  return request({
    url: '/web/baseopenline/' + id,
    method: 'delete'
  })
}
// 删除开线检查和对应的dtl
export function removeAndDtl(id) {
  return request({
    url: '/web/baseopenline/removeAndDtl/' + id,
    method: 'delete'
  })
}
