import request from '@/utils/request'

// 查询质检文件管理列表
export function listManage(query) {
  return request({
    url: '/web/manage/list',
    method: 'get',
    params: query
  })
}

// 查询质检文件管理详细
export function getManage(id) {
  return request({
    url: '/web/manage/' + id,
    method: 'get'
  })
}

// 新增质检文件管理
export function addManage(data) {
  return request({
    url: '/web/manage',
    method: 'post',
    data: data
  })
}

// 修改质检文件管理
export function updateManage(data) {
  return request({
    url: '/web/manage',
    method: 'put',
    data: data
  })
}
// 修改文件管理
export function updateFileManage(data) {
  return request({
    url: '/web/manage/updateFileManage',
    method: 'post',
    data: data
  })
}
// 删除质检文件管理
export function delManage(id) {
  return request({
    url: '/web/manage/' + id,
    method: 'delete'
  })
}

// 删除质检文件管理
export function delManageTest(id) {
  return request({
    url: '/web/manage/delect/' + id,
    method: 'delete'
  })
}
