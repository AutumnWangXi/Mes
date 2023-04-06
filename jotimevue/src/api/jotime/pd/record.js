import request from '@/utils/request'

// 查询生产测试记录列表
export function listRecord(query) {
  return request({
    url: '/web/pdRecord/list',
    method: 'get',
    params: query
  })
}

// 查询生产测试记录详细
export function getRecord(id) {
  return request({
    url: '/web/pdRecord/' + id,
    method: 'get'
  })
}

// 新增生产测试记录
export function addRecord(data) {
  return request({
    url: '/web/pdRecord',
    method: 'post',
    data: data
  })
}

// 修改生产测试记录
export function updateRecord(data) {
  return request({
    url: '/web/pdRecord',
    method: 'put',
    data: data
  })
}

// 删除生产测试记录
export function delRecord(id) {
  return request({
    url: '/web/pdRecord/' + id,
    method: 'delete'
  })
}
