import request from '@/utils/request'

// 查询描述：生产工艺参数记录列表
export function listPPRecord(query) {
  return request({
    url: '/web/pprecord/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产工艺参数记录详细
export function getRecord(id) {
  return request({
    url: '/web/pprecord/' + id,
    method: 'get'
  })
}

// 新增描述：生产工艺参数记录
export function addRecord(data) {
  return request({
    url: '/web/pprecord',
    method: 'post',
    data: data
  })
}
// 删除描述：生产工艺参数记录
export function addRecordList(data) {
  return request({
    url: '/web/pprecord/addList',
    method: 'post',
    data: data
  })
}

// 修改描述：生产工艺参数记录
export function updateRecord(data) {
  return request({
    url: '/web/pprecord',
    method: 'put',
    data: data
  })
}

// 删除描述：生产工艺参数记录
export function delRecord(id) {
  return request({
    url: '/web/pprecord/' + id,
    method: 'delete'
  })
}
