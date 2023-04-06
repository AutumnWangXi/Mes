import request from '@/utils/request'

// 查询描述：文件清单管理列表
export function listFileListManage(query) {
  return request({
    url: '/web/fileListManage/list',
    method: 'get',
    params: query
  })
}

// 查询描述：文件清单管理详细
export function getFileListManage(id) {
  return request({
    url: '/web/fileListManage/' + id,
    method: 'get'
  })
}

// 新增描述：文件清单管理
export function addFileListManage(data) {
  return request({
    url: '/web/fileListManage',
    method: 'post',
    data: data
  })
}

// 修改描述：文件清单管理
export function updateFileListManage(data) {
  return request({
    url: '/web/fileListManage',
    method: 'put',
    data: data
  })
}

// 删除描述：文件清单管理
export function delFileListManage(id) {
  return request({
    url: '/web/fileListManage/' + id,
    method: 'delete'
  })
}
