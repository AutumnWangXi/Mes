import request from '@/utils/request'

// 查询描述：入库质检列表
export function listQuality(query) {
  return request({
    url: '/web/stockin/quality/list',
    method: 'get',
    params: query
  })
}

// 查询描述：入库质检详细
export function getQuality(id) {
  return request({
    url: '/web/stockin/quality/' + id,
    method: 'get'
  })
}

// 新增描述：入库质检
export function addQuality(data) {
  return request({
    url: '/web/stockin/quality',
    method: 'post',
    data: data
  })
}

// 修改描述：入库质检
export function updateQuality(data) {
  return request({
    url: '/web/stockin/quality',
    method: 'put',
    data: data
  })
}

// 删除描述：入库质检
export function delQuality(id) {
  return request({
    url: '/web/stockin/quality/' + id,
    method: 'delete'
  })
}
