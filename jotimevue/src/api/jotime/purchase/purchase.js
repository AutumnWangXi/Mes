import request from '@/utils/request'

// 查询描述：采购单列表
export function listPurchase(query) {
  return request({
    url: '/web/purchase/list',
    method: 'get',
    params: query
  })
}

// 查询描述：采购单详细
export function getPurchase(id) {
  return request({
    url: '/web/purchase/' + id,
    method: 'get'
  })
}

// 新增描述：采购单
export function addPurchase(data) {
  return request({
    url: '/web/purchase',
    method: 'post',
    data: data
  })
}

// 修改描述：采购单
export function updatePurchase(data) {
  return request({
    url: '/web/purchase',
    method: 'put',
    data: data
  })
}

// 删除描述：采购单
export function delPurchase(id) {
  return request({
    url: '/web/purchase/' + id,
    method: 'delete'
  })
}


// 获取采购单号
export function getItemCodes(data) {
  return request({
    url: '/web/purchase/getItemCodes',
    method: 'get',
    params: data
  })
}
