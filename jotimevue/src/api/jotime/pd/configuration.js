import request from '@/utils/request'

// 查询描述：生产流程配置列表
export function listConfiguration(query) {
  return request({
    url: '/web/pd/configuration/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产流程配置列表
export function dataList(query) {
  return request({
    url: '/web/pd/configuration/dataList',
    method: 'get',
    params: query
  })
}

// 查询描述：生产流程配置详细
export function getConfiguration(id) {
  return request({
    url: '/web/pd/configuration/' + id,
    method: 'get'
  })
}

// 新增描述：生产流程配置
export function addConfiguration(data) {
  return request({
    url: '/web/pd/configuration',
    method: 'post',
    data: data
  })
}

// 修改描述：生产流程配置
export function updateConfiguration(data) {
  return request({
    url: '/web/pd/configuration',
    method: 'put',
    data: data
  })
}

// 删除描述：生产流程配置
export function delConfiguration(id) {
  return request({
    url: '/web/pd/configuration/' + id,
    method: 'delete'
  })
}
