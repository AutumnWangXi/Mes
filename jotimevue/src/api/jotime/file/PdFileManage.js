import request from '@/utils/request'

// 查询描述 生产文件管理列表
export function listManage(query) {
  return request({
    url: '/web/pd/manage/list',
    method: 'get',
    params: query
  })
}

// 查询描述 生产文件管理详细
export function getManage(id) {
  return request({
    url: '/web/pd/manage/' + id,
    method: 'get'
  })
}

// 新增描述 生产文件管理
export function addManage(data) {
  return request({
    url: '/web/pd/manage',
    method: 'post',
    data: data
  })
}

// 修改描述 生产文件管理
export function updateManage(data) {
  return request({
    url: '/web/pd/manage',
    method: 'put',
    data: data
  })
}

// 删除描述 生产文件管理
export function delManage(id) {
  return request({
    url: '/web/pd/manage/' + id,
    method: 'delete'
  })
}
