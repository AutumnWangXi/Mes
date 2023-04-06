import request from '@/utils/request'

// 查询描述：采购需求列表
export function listNeeds(query) {
  return request({
    url: '/web/purchase/needs/list',
    method: 'get',
    params: query
  })
}

// 查询描述：采购需求详细
export function getNeeds(id) {
  return request({
    url: '/web/purchase/needs/' + id,
    method: 'get'
  })
}

// 新增描述：采购需求
export function addNeeds(data) {
  return request({
    url: '/web/purchase/needs',
    method: 'post',
    data: data
  })
}

// 修改描述：采购需求
export function updateNeeds(data) {
  return request({
    url: '/web/purchase/needs',
    method: 'put',
    data: data
  })
}

// 删除描述：采购需求
export function delNeeds(id) {
  return request({
    url: '/web/purchase/needs/' + id,
    method: 'delete'
  })
}
