import request from '@/utils/request'

// 查询描述：合同明细列表
export function listContractdtl(query) {
  return request({
    url: '/web/contractdtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：合同明细详细
export function getContractdtl(id) {
  return request({
    url: '/web/contractdtl/' + id,
    method: 'get'
  })
}

// 新增描述：合同明细
export function addContractdtl(data) {
  return request({
    url: '/web/contractdtl',
    method: 'post',
    data: data
  })
}

// 修改描述：合同明细
export function updateContractdtl(data) {
  return request({
    url: '/web/contractdtl',
    method: 'put',
    data: data
  })
}

// 删除描述：合同明细
export function delContractdtl(id) {
  return request({
    url: '/web/contractdtl/' + id,
    method: 'delete'
  })
}
