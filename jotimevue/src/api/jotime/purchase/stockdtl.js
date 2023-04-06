import request from '@/utils/request'

// 查询描述：采购需求库存使用明细列表
export function listStockdtl(query) {
  return request({
    url: '/web/purchase/stockdtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：采购需求库存使用明细详细
export function getStockdtl(id) {
  return request({
    url: '/web/purchase/stockdtl/' + id,
    method: 'get'
  })
}

// 新增描述：采购需求库存使用明细
export function addStockdtl(data) {
  return request({
    url: '/web/purchase/stockdtl',
    method: 'post',
    data: data
  })
}

// 修改描述：采购需求库存使用明细
export function updateStockdtl(data) {
  return request({
    url: '/web/purchase/stockdtl',
    method: 'put',
    data: data
  })
}

// 删除描述：采购需求库存使用明细
export function delStockdtl(id) {
  return request({
    url: '/web/purchase/stockdtl/' + id,
    method: 'delete'
  })
}
