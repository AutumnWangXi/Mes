import request from '@/utils/request'

// 查询站内信消息内容列表
export function listMessage(query) {
  return request({
    url: '/web/message/list',
    method: 'get',
    params: query
  })
}
// 查询站内信消息内容列表
export function listCount(query) {
  return request({
    url: '/web/message/listCount',
    method: 'get',
    params: query
  })
}


// 查询站内信消息内容详细
export function getMessage(id) {
  return request({
    url: '/web/message/' + id,
    method: 'get'
  })
}

// 新增站内信消息内容
export function addMessage(data) {
  return request({
    url: '/web/message',
    method: 'post',
    data: data
  })
}

// 修改站内信消息内容
export function updateMessage(data) {
  return request({
    url: '/web/message',
    method: 'put',
    data: data
  })
}

// 删除站内信消息内容
export function delMessage(id) {
  return request({
    url: '/web/message/' + id,
    method: 'delete'
  })
}
