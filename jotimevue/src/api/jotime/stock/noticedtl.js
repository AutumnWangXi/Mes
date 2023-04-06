import request from '@/utils/request'

// 查询入库通知明细列表
export function listNoticedtl(query) {
  return request({
    url: '/web/stockin/noticedtl/list',
    method: 'get',
    params: query
  })
}

// 查询入库通知明细详细
export function getNoticedtl(id) {
  return request({
    url: '/web/stockin/noticedtl/' + id,
    method: 'get'
  })
}

// 新增入库通知明细
export function addNoticedtl(data) {
  return request({
    url: '/web/stockin/noticedtl',
    method: 'post',
    data: data
  })
}

// 修改入库通知明细
export function updateNoticedtl(data) {
  return request({
    url: '/web/stockin/noticedtl',
    method: 'put',
    data: data
  })
}

// 删除入库通知明细
export function delNoticedtl(id) {
  return request({
    url: '/web/stockin/noticedtl/' + id,
    method: 'delete'
  })
}
