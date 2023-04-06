import request from '@/utils/request'

// 查询描述 生产文件管理列表
export function listManage(query) {
  return request({
    url: '/web/base/manage/list',
    method: 'get',
    params: query
  })
}

// 查询描述 生产文件管理详细
export function getManage(id) {
  return request({
    url: '/web/base/manage/' + id,
    method: 'get'
  })
}

// 新增描述 生产文件管理
export function addManage(data) {
  return request({
    url: '/web/base/manage',
    method: 'post',
    data: data
  })
}

// 修改描述 生产文件管理
export function updateManage(data) {
  return request({
    url: '/web/base/manage',
    method: 'put',
    data: data
  })
}
// 修改描述 生产文件管理
export function updateFileManage(data) {
  return request({
    url: '/web/base/manage/updateFileManage',
    method: 'post',
    data: data
  })
}

// 删除描述 生产文件管理
export function delManage(id) {
  return request({
    url: '/web/base/manage/' + id,
    method: 'delete'
  })
}
// 删除文件根据url
export function deleteFileByUrl(data) {
  return request({
    url: '/web/base/manage/deleteFileByUrl',
    method: 'post',
    data: data
  })
}
