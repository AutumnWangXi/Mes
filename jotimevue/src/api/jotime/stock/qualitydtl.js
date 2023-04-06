import request from '@/utils/request'

// 查询描述：入库质检明细列表
export function listQualitydtl(query) {
  return request({
    url: '/web/stockin/qualitydtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：入库质检明细详细
export function getQualitydtl(id) {
  return request({
    url: '/web/stockin/qualitydtl/' + id,
    method: 'get'
  })
}

// 新增描述：入库质检明细
export function addQualitydtl(data) {
  return request({
    url: '/web/stockin/qualitydtl',
    method: 'post',
    data: data
  })
}

// 修改描述：入库质检明细
export function updateQualitydtl(data) {
  return request({
    url: '/web/stockin/qualitydtl',
    method: 'put',
    data: data
  })
}

// 删除描述：入库质检明细
export function delQualitydtl(id) {
  return request({
    url: '/web/stockin/qualitydtl/' + id,
    method: 'delete'
  })
}
