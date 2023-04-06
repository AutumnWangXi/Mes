import request from '@/utils/request'

// 查询投料记录列表
export function listFeedingRecord(query) {
  return request({
    url: '/web/feedingrecord/list',
    method: 'get',
    params: query
  })
}

// 查询投料记录详细
export function getFeedingRecord(id) {
  return request({
    url: '/web/feedingrecord/' + id,
    method: 'get'
  })
}

// 新增投料记录
export function addFeedingRecord(data) {
  return request({
    url: '/web/feedingrecord',
    method: 'post',
    data: data
  })
}

// 修改投料记录
export function updateFeedingRecord(data) {
  return request({
    url: '/web/feedingrecord',
    method: 'put',
    data: data
  })
}

// 删除投料记录
export function delFeedingRecord(id) {
  return request({
    url: '/web/feedingrecord/' + id,
    method: 'delete'
  })
}
