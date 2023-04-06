import request from '@/utils/request'

// 查询美国CIR审查安全使用的化妆品原料列表
export function listCir(query) {
  return request({
    url: '/web/cir/list',
    method: 'get',
    params: query
  })
}

// 查询美国CIR审查安全使用的化妆品原料详细
export function getCir(id) {
  return request({
    url: '/web/cir/' + id,
    method: 'get'
  })
}

// 新增美国CIR审查安全使用的化妆品原料
export function addCir(data) {
  return request({
    url: '/web/cir',
    method: 'post',
    data: data
  })
}

// 修改美国CIR审查安全使用的化妆品原料
export function updateCir(data) {
  return request({
    url: '/web/cir',
    method: 'put',
    data: data
  })
}

// 删除美国CIR审查安全使用的化妆品原料
export function delCir(id) {
  return request({
    url: '/web/cir/' + id,
    method: 'delete'
  })
}
