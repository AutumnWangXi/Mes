import request from '@/utils/request'

// 查询已使用化妆品原料列表
export function listCosmeticMaterial(query) {
  return request({
    url: '/web/cosmeticMaterial/list',
    method: 'get',
    params: query
  })
}

// 查询已使用化妆品原料详细
export function getCosmeticMaterial(id) {
  return request({
    url: '/web/cosmeticMaterial/' + id,
    method: 'get'
  })
}

// 新增已使用化妆品原料
export function addCosmeticMaterial(data) {
  return request({
    url: '/web/cosmeticMaterial',
    method: 'post',
    data: data
  })
}

// 修改已使用化妆品原料
export function updateCosmeticMaterial(data) {
  return request({
    url: '/web/cosmeticMaterial',
    method: 'put',
    data: data
  })
}

// 删除已使用化妆品原料
export function delCosmeticMaterial(id) {
  return request({
    url: '/web/cosmeticMaterial/' + id,
    method: 'delete'
  })
}
