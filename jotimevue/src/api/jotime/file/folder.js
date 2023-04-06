import request from '@/utils/request'

// 查询文件夹名列表
export function listFolder(query) {
  return request({
    url: '/web/folder/list',
    method: 'get',
    params: query
  })
}

// 查询文件夹名列表
export function getTree(query) {
  return request({
    url: '/web/folder/getTree',
    method: 'get',
    params: query
  })
}

// 查询文件夹名详细
export function getFolder(id) {
  return request({
    url: '/web/folder/' + id,
    method: 'get'
  })
}

// 新增文件夹名
export function addFolder(data) {
  return request({
    url: '/web/folder',
    method: 'post',
    data: data
  })
}

// 修改文件夹名
export function updateFolder(data) {
  return request({
    url: '/web/folder',
    method: 'put',
    data: data
  })
}

// 删除文件夹名
export function delFolder(id) {
  return request({
    url: '/web/folder/' + id,
    method: 'delete'
  })
}
