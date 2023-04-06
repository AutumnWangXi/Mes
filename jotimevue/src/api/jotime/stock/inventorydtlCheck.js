import request from '@/utils/request'

// 查询库存盘点明细列表
export function listInventorydtl(query) {
  return request({
    url: '/web/stockin/inventorydtl/list',
    method: 'get',
    params: query
  })
}

// 查询库存盘点明细详细
export function getInventorydtl(id) {
  return request({
    url: '/web/stockin/inventorydtl/' + id,
    method: 'get'
  })
}

// 新增库存盘点明细
export function addInventorydtl(data) {
  return request({
    url: '/web/stockin/inventorydtl',
    method: 'post',
    data: data
  })
}

// 修改库存盘点明细
export function updateInventorydtl(data) {
  return request({
    url: '/web/stockin/inventorydtl/editCheck',
    method: 'put',
    data: data
  })
}

// 删除库存盘点明细
export function delInventorydtl(id) {
  return request({
    url: '/web/stockin/inventorydtl/' + id,
    method: 'delete'
  })
}
