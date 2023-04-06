import request from '@/utils/request'

// 查询描述：生产流程节点列表
export function listNode(query) {
  return request({
    url: '/web/pd/node/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产流程节点列表
export function nodeDataList(query) {
  return request({
    url: '/web/pd/node/dataList',
    method: 'get',
    params: query
  })
}

// 查询描述：生产流程节点详细
export function getNode(id) {
  return request({
    url: '/web/pd/node/' + id,
    method: 'get'
  })
}

// 新增描述：生产流程节点
export function addNode(data) {
  return request({
    url: '/web/pd/node',
    method: 'post',
    data: data
  })
}

// 修改描述：生产流程节点
export function updateNode(data) {
  return request({
    url: '/web/pd/node',
    method: 'put',
    data: data
  })
}

// 删除描述：生产流程节点
export function delNode(id) {
  return request({
    url: '/web/pd/node/' + id,
    method: 'delete'
  })
}
