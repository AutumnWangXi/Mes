import request from '@/utils/request'

// 查询描述 生产文件管理列表
export function listManage(query) {
  return request({
    url: '/web/rd/manage/list',
    method: 'get',
    params: query
  })
}

// 查询描述 生产文件管理详细
export function getManage(id) {
  return request({
    url: '/web/rd/manage/' + id,
    method: 'get'
  })
}

// 新增描述 生产文件管理
export function addManage(data) {
  return request({
    url: '/web/rd/manage',
    method: 'post',
    data: data
  })
}

// 修改描述 生产文件管理
export function updateManage(data) {
  return request({
    url: '/web/rd/manage',
    method: 'put',
    data: data
  })
}

// 删除描述 生产文件管理
export function delManage(id) {
  return request({
    url: '/web/rd/manage/' + id,
    method: 'delete'
  })
}
// 修改文件管理
export function updateFileManage(data) {
  return request({
    url: '/web/rd/manage/updateFileManage',
    method: 'post',
    data: data
  })
}

// 删除文件根据url
export function deleteFileByUrl(data) {
  return request({
    url: '/web/rd/manage/deleteFileByUrl',
    method: 'post',
    data: data
  })
}

// 删除文件根据url
export function deleteFileByUrlType(data) {
  return request({
    url: '/web/rd/manage/deleteFileByUrlType',
    method: 'post',
    data: data
  })
}
