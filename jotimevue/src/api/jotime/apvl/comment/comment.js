import request from '@/utils/request'

// 查询审批评论列表
export function listComment(query) {
  return request({
    url: '/web/apvl/comment/list',
    method: 'get',
    params: query
  })
}

// 查询审批评论详细
export function getComment(id) {
  return request({
    url: '/web/apvl/comment/' + id,
    method: 'get'
  })
}

// 新增审批评论
export function addComment(data) {
  return request({
    url: '/web/apvl/comment',
    method: 'post',
    data: data
  })
}

// 修改审批评论
export function updateComment(data) {
  return request({
    url: '/web/apvl/comment',
    method: 'put',
    data: data
  })
}

// 删除审批评论
export function delComment(id) {
  return request({
    url: '/web/apvl/comment/' + id,
    method: 'delete'
  })
}
