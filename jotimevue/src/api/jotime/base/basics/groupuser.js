import request from '@/utils/request'

// 查询班组人员管理列表
export function listGroupuser(query) {
  return request({
    url: '/admin/groupuser/list',
    method: 'get',
    params: query
  })
}
// 查询班组人员管理列表
export function listGroupuserVo(query) {
  return request({
    url: '/admin/groupuser/listVo',
    method: 'get',
    params: query
  })
}
// 查询班组人员管理详细
export function getGroupuser(id) {
  return request({
    url: '/admin/groupuser/' + id,
    method: 'get'
  })
}

// 新增班组人员管理
export function addGroupuser(data) {
  return request({
    url: '/admin/groupuser',
    method: 'post',
    data: data
  })
}

// 修改班组人员管理
export function updateGroupuser(data) {
  return request({
    url: '/admin/groupuser',
    method: 'put',
    data: data
  })
}

// 删除班组人员管理
export function delGroupuser(id) {
  return request({
    url: '/admin/groupuser/' + id,
    method: 'delete'
  })
}
