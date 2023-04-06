import request from '@/utils/request'

// 查询实际生产投料列表
export function listactualFeeding(query) {
  return request({
    url: '/web/actualFeeding/list',
    method: 'get',
    params: query
  })
}

// 查询实际生产投料详细
export function getactualFeeding(id) {
  return request({
    url: '/web/actualFeeding/' + id,
    method: 'get'
  })
}

// 新增实际生产投料
export function addactualFeeding(data) {
  return request({
    url: '/web/actualFeeding',
    method: 'post',
    data: data
  })
}

// 修改实际生产投料
export function updateactualFeeding(data) {
  return request({
    url: '/web/actualFeeding',
    method: 'put',
    data: data
  })
}

// 删除实际生产投料
export function delactualFeeding(id) {
  return request({
    url: '/web/actualFeeding/' + id,
    method: 'delete'
  })
}
