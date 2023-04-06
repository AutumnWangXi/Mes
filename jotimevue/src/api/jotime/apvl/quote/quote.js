import request from '@/utils/request'

// 查询描述：报价申请列表
export function listQuote(query) {
  return request({
    url: '/admin/quote/list',
    method: 'get',
    params: query
  })
}

// 查询描述：报价申请详细
export function getQuote(id) {
  return request({
    url: '/admin/quote/' + id,
    method: 'get'
  })
}

// 新增描述：报价申请
export function addQuote(data) {
  return request({
    url: '/admin/quote',
    method: 'post',
    data: data
  })
}

// 修改描述：报价申请
export function updateQuote(data) {
  return request({
    url: '/admin/quote',
    method: 'put',
    data: data
  })
}

// 删除描述：报价申请
export function delQuote(id) {
  return request({
    url: '/admin/quote/' + id,
    method: 'delete'
  })
}
