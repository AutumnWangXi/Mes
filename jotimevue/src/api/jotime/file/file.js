import request from '@/utils/request'

// 查询文件管理列表
export function listManage(query) {
  return request({
    url: '/admin/manage/list',
    method: 'get',
    params: query
  })
}

// 查询文件管理详细
export function getManage(id) {
  return request({
    url: '/admin/manage/' + id,
    method: 'get'
  })
}

// 新增文件管理
export function addManage(data) {
  return request({
    url: '/admin/manage/saveFile',
    method: 'post',
    data: data
  })
}

// 修改文件管理
export function updateManage(data) {
  return request({
    url: '/admin/manage',
    method: 'put',
    data: data
  })
}

// 修改文件管理
export function updateFileManage(data) {
  return request({
    url: '/admin/manage/updateFileManage',
    method: 'post',
    data: data
  })
}

// 删除文件管理
export function delManage(id) {
  return request({
    url: '/admin/manage/' + id,
    method: 'delete'
  })
}

// 删除文件根据url
export function deleteFileByUrl(data) {
  return request({
    url: '/admin/manage/deleteFileByUrl',
    method: 'post',
    data: data
  })
}

// 修改文件管理
export function removeFileManageData(data) {
  return request({
    url: '/admin/manage/removeFileManageData',
    method: 'post',
    data: data
  })
}
