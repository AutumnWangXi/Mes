import request from '@/utils/request'

// 查询生产商品牌列表
export function listBrand(query) {
  return request({
    url: '/web/base/brand/list',
    method: 'get',
    params: query
  })
}

// 查询生产商品牌详细信息
export function getBrand(id) {
  return request({
    url: '/web/base/brand/' + id,
    method: 'get'
  })
}

// 新增生产商品牌
export function addBrand(data) {
  return request({
    url: '/web/base/brand',
    method: 'post',
    data: data
  })
}

// 修改生产商品牌信息
export function updateBrand(data) {
  return request({
    url: '/web/base/brand',
    method: 'put',
    data: data
  })
}

// 删除生产商品牌信息
export function delBrand(id) {
  return request({
    url: '/web/base/brand/' + id,
    method: 'delete'
  })
}

// 获取生产商信息
export function getMfrsInfo(status) {
  return request({
    url: '/web/base/mfrs/optionsList/' + status,
    method: 'get'
  })
}
