import request from '@/utils/request'

// 查询移库记录列表
export function listRecord(query) {
  return request({
    url: '/web/stockin/record/list',
    method: 'get',
    params: query
  })
}

// 查询移库记录详细
export function getRecord(id) {
  return request({
    url: '/web/stockin/record/' + id,
    method: 'get'
  })
}

// 新增移库记录
export function addRecord(data) {
  return request({
    url: '/web/stockin/record',
    method: 'post',
    data: data
  })
}

// 修改移库记录
export function updateRecord(data) {
  return request({
    url: '/web/stockin/record',
    method: 'put',
    data: data
  })
}

// 删除移库记录
export function delRecord(id) {
  return request({
    url: '/web/stockin/record/' + id,
    method: 'delete'
  })
}
