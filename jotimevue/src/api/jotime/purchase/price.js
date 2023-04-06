import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listPrice(query) {
  return request({
    url: '/web/price/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getPrice(id) {
  return request({
    url: '/web/price/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addPrice(data) {
  return request({
    url: '/web/price',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updatePrice(data) {
  return request({
    url: '/web/price',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delPrice(id) {
  return request({
    url: '/web/price/' + id,
    method: 'delete'
  })
}
