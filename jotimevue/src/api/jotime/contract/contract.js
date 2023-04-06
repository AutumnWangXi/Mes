import request from '@/utils/request'

// 查询描述：合同列表
export function listContract(query) {
  return request({
    url: '/web/contract/list',
    method: 'get',
    params: query
  })
}

// 查询描述：合同详细
export function getContract(id) {
  return request({
    url: '/web/contract/' + id,
    method: 'get'
  })
}

// 新增描述：合同
export function addContract(data) {
  return request({
    url: '/web/contract',
    method: 'post',
    data: data
  })
}

// 修改描述：合同
export function updateContract(data) {
  return request({
    url: '/web/contract',
    method: 'put',
    data: data
  })
}

// 删除描述：合同
export function delContract(id) {
  return request({
    url: '/web/contract/' + id,
    method: 'delete'
  })
}
