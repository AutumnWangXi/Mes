import request from '@/utils/request'

// 查询描述：生产节点所属车间列表
export function listWorkshop(query) {
  return request({
    url: '/web/pd/workshop/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产节点所属车间列表
export function dataList(query) {
  return request({
    url: '/web/pd/workshop/dataList',
    method: 'get',
    params: query
  })
}

// 查询描述：生产节点所属车间详细
export function getWorkshop(id) {
  return request({
    url: '/web/pd/workshop/' + id,
    method: 'get'
  })
}

// 新增描述：生产节点所属车间
export function addWorkshop(data) {
  return request({
    url: '/web/pd/workshop',
    method: 'post',
    data: data
  })
}

// 修改描述：生产节点所属车间
export function updateWorkshop(data) {
  return request({
    url: '/web/pd/workshop',
    method: 'put',
    data: data
  })
}

// 删除描述：生产节点所属车间
export function delWorkshop(id) {
  return request({
    url: '/web/pd/workshop/' + id,
    method: 'delete'
  })
}
