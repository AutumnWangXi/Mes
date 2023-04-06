import request from '@/utils/request'

// 查询描述：入库通知物料包明细列表
export function listItempkg(query) {
  return request({
    url: '/web/stockin/itempkg/list',
    method: 'get',
    params: query
  })
}

// 查询描述：入库通知物料包明细详细
export function getItempkg(id) {
  return request({
    url: '/web/stockin/itempkg/' + id,
    method: 'get'
  })
}

// 新增描述：入库通知物料包明细
export function addItempkg(data) {
  return request({
    url: '/web/stockin/itempkg',
    method: 'post',
    data: data
  })
}

// 修改描述：入库通知物料包明细
export function updateItempkg(data) {
  return request({
    url: '/web/stockin/itempkg',
    method: 'put',
    data: data
  })
}

// 删除描述：入库通知物料包明细
export function delItempkg(id) {
  return request({
    url: '/web/stockin/itempkg/' + id,
    method: 'delete'
  })
}
