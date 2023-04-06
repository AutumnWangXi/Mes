import request from '@/utils/request'

// 查询描述：采购单申请明细列表
export function listPurchasedtl(query) {
  return request({
    url: '/web/apvl/stockPurchasedtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：采购单申请明细详细
export function getPurchasedtl(id) {
  return request({
    url: '/web/apvl/stockPurchasedtl/' + id,
    method: 'get'
  })
}

// 新增描述：采购单申请明细
export function addPurchasedtl(data) {
  return request({
    url: '/web/apvl/stockPurchasedtl',
    method: 'post',
    data: data
  })
}

// 修改描述：采购单申请明细
export function updatePurchasedtl(data) {
  return request({
    url: '/web/apvl/stockPurchasedtl',
    method: 'put',
    data: data
  })
}

// 删除描述：采购单申请明细
export function delPurchasedtl(id) {
  return request({
    url: '/web/apvl/stockPurchasedtl/' + id,
    method: 'delete'
  })
}
