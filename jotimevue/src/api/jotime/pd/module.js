import request from '@/utils/request'

// 查询描述：生产流程名称列表
export function listModule(query) {
  return request({
    url: '/web/pd/module/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产流程名称列表
export function moduleDataList(query) {
  return request({
    url: '/web/pd/module/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产流程名称详细
export function getModule(id) {
  return request({
    url: '/web/pd/module/' + id,
    method: 'get'
  })
}

// 新增描述：生产流程名称
export function addModule(data) {
  return request({
    url: '/web/pd/module',
    method: 'post',
    data: data
  })
}

// 修改描述：生产流程名称
export function updateModule(data) {
  return request({
    url: '/web/pd/module',
    method: 'put',
    data: data
  })
}

// 删除描述：生产流程名称
export function delModule(id) {
  return request({
    url: '/web/pd/module/' + id,
    method: 'delete'
  })
}
