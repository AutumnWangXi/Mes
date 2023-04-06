import request from '@/utils/request'

// 查询订单出库合并列表
export function listMerge(query) {
  return request({
    url: '/web/merge/list',
    method: 'get',
    params: query
  })
}

// 查询订单出库合并详细
export function getMerge(id) {
  return request({
    url: '/web/merge/' + id,
    method: 'get'
  })
}

// 新增订单出库合并
export function addMerge(data) {
  return request({
    url: '/web/merge',
    method: 'post',
    data: data
  })
}

// 修改订单出库合并
export function updateMerge(data) {
  return request({
    url: '/web/merge',
    method: 'put',
    data: data
  })
}

// 删除订单出库合并
export function delMerge(id) {
  return request({
    url: '/web/merge/' + id,
    method: 'delete'
  })
}

//出库指示
export function outboundInstructions(data) {
  return request({
    url: '/web/merge/outboundInstructions',
    method: 'put',
    data: data
  })
}
