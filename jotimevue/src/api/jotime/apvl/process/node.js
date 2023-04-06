import request from '@/utils/request'


// 查询审批流程节点列表
export function listNode(query) {
  return request({
    url: '/admin/node/list',
    method: 'get',
    params: query
  })
}
// 查询流程对应节点列表
export function getNodeList(val1,val2) {
  return request({
    url: '/admin/node/getNodeList/'+val1+'/'+val2,
    method: 'get'
  })
}
// 查询审批流程节点详细
export function getNode(id) {
  return request({
    url: '/admin/node/'+ id,
    method: 'get'
  })
}

// 新增审批流程节点
export function addNode(data) {
  return request({
    url: '/admin/node',
    method: 'post',
    data: data
  })
}

// 修改审批流程节点
export function updateNode(data) {
  return request({
    url: '/admin/node',
    method: 'put',
    data: data
  })
}

// 删除审批流程节点
export function delNode(id) {
  return request({
    url: '/admin/node/' + id,
    method: 'delete'
  })
}
