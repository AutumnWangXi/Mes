import request from '@/utils/request'

// 查询生产测试记录列表
export function listRecord(query) {
  return request({
    url: '/web/pdTestRecord/list',
    method: 'get',
    params: query
  })
}

// 查询生产测试记录详细
export function getRecord(id) {
  return request({
    url: '/web/pdTestRecord/' + id,
    method: 'get'
  })
}

// 新增生产测试记录
export function addRecord(data) {
  return request({
    url: '/web/pdTestRecord',
    method: 'post',
    data: data
  })
}

// 修改生产测试记录
export function updateRecord(data) {
  return request({
    url: '/web/pdTestRecord',
    method: 'put',
    data: data
  })
}

// 删除生产测试记录
export function delRecord(id) {
  return request({
    url: '/web/pdTestRecord/' + id,
    method: 'delete'
  })
}
