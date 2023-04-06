import request from '@/utils/request'

// 查询描述：生产订单申请bom列表
export function listBom(query) {
  return request({
    url: '/web/apvl/orderbom/list',
    method: 'get',
    params: query
  })
}

// 查询描述：生产订单申请bom详细
export function getBom(id) {
  return request({
    url: '/web/apvl/orderbom/' + id,
    method: 'get'
  })
}

// 新增描述：生产订单申请bom
export function addBom(data) {
  return request({
    url: '/web/apvl/orderbom',
    method: 'post',
    data: data
  })
}

// 修改描述：生产订单申请bom
export function updateBom(data) {
  return request({
    url: '/web/apvl/orderbom',
    method: 'put',
    data: data
  })
}

// 删除描述：生产订单申请bom
export function delBom(id) {
  return request({
    url: '/web/apvl/orderbom/' + id,
    method: 'delete'
  })
}
