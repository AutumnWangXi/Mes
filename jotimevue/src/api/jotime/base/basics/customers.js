import request from '@/utils/request'

// 查询客户集合列表
export function listCustomers(query, pageType) {
  return request({
    url: '/web/base/customers/list/' + pageType,
    method: 'get',
    params: query
  })
}

// 查询客户集合详细
export function getCustomers(id) {
  return request({
    url: '/web/base/customers/' + id,
    method: 'get'
  })
}

// 新增客户集合
export function addCustomers(data, pageType) {
  return request({
    url: '/web/base/customers/' + pageType,
    method: 'post',
    data: data
  })
}

// 修改客户集合
export function updateCustomers(data, pageType) {
  return request({
    url: '/web/base/customers/' + pageType,
    method: 'put',
    data: data
  })
}


// 删除客户集合
export function delCustomers(id) {
  return request({
    url: '/web/base/customers/' + id,
    method: 'delete'
  })
}

// 查询客户集合
export function selectCustomers() {
  return request({
    url: '/web/base/customers/selectCustomers',
    method: 'Get'
  })
}
