import request from '@/utils/request'

// 查询班组列表
export function listGroup(query) {
  return request({
    url: '/admin/group/list',
    method: 'get',
    params: query
  })
}
// 查询车间 班组列表
export function getWorkGroupList(workShopId) {
  return request({
    url: '/admin/group/getWorkGroupList/'+workShopId,
    method: 'get',
  })
}
// 查询班组详细
export function getGroup(id) {
  return request({
    url: '/admin/group/' + id,
    method: 'get'
  })
}
// 查询班组详细
export function getGroupVo(id) {
  return request({
    url: '/admin/group/getGroupVo/' + id,
    method: 'get'
  })
}

// 新增班组
export function addGroup(data) {
  return request({
    url: '/admin/group',
    method: 'post',
    data: data
  })
}

// 修改班组
export function updateGroup(data) {
  return request({
    url: '/admin/group',
    method: 'put',
    data: data
  })
}
// 修改班组和班组人员
export function updateGroupVo(data) {
  return request({
    url: '/admin/group/editAndGroupUser',
    method: 'put',
    data: data
  })
}

// 删除班组
export function delGroup(id) {
  return request({
    url: '/admin/group/' + id,
    method: 'delete'
  })
}
// 查询班组生产订单的班组的负责人
export function getGroupleader(gpOrdertaskNo) {
  return request({
    url: '/admin/group/selectGroupleader/' + gpOrdertaskNo,
    method: 'get'
  })
}
// 获取用户部门对应班组列表
export function getDeptWorkGroupList() {
  return request({
    url: '/admin/group/getDeptWorkGroupList',
    method: 'get'
  })
}
