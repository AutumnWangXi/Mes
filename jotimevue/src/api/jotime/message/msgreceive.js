import request from '@/utils/request'

// 查询站内信消息状态列表
export function listMsgreceive(query) {
  return request({
    url: '/web/msgreceive/list',
    method: 'get',
    params: query
  })
}

// 查询站内信消息状态详细
export function getMsgreceive(id) {
  return request({
    url: '/web/msgreceive/' + id,
    method: 'get'
  })
}

// 新增站内信消息状态
export function addMsgreceive(data) {
  return request({
    url: '/web/msgreceive',
    method: 'post',
    data: data
  })
}

// 修改站内信消息状态
export function updateMsgreceive(data) {
  return request({
    url: '/web/msgreceive',
    method: 'put',
    data: data
  })
}

// 删除站内信消息状态
export function delMsgreceive(id) {
  return request({
    url: '/web/msgreceive/' + id,
    method: 'delete'
  })
}
