import request from '@/utils/request'

// 查询编码规则明细列表
export function listRuledtl(query) {
  return request({
    url: '/web/base/ruledtl/list',
    method: 'get',
    params: query
  })
}

// 查询编码规则明细详细
export function getRuledtl(id) {
  return request({
    url: '/web/base/ruledtl/' + id,
    method: 'get'
  })
}

// 新增编码规则明细
export function addRuledtl(data) {
  return request({
    url: '/web/base/ruledtl',
    method: 'post',
    data: data
  })
}

// 修改编码规则明细
export function updateRuledtl(data) {
  return request({
    url: '/web/base/ruledtl',
    method: 'put',
    data: data
  })
}

// 删除编码规则明细
export function delRuledtl(id) {
  return request({
    url: '/web/base/ruledtl/' + id,
    method: 'delete'
  })
}
