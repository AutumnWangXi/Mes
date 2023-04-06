import request from '@/utils/request'

// 查询描述：开线检查信息明细列表
export function listOpenlinecheckinfodtl(query) {
  return request({
    url: '/web/openlinecheckinfodtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：开线检查信息明细详细
export function getOpenlinecheckinfodtl(id) {
  return request({
    url: '/web/openlinecheckinfodtl/' + id,
    method: 'get'
  })
}

// 新增描述：开线检查信息明细
export function addOpenlinecheckinfodtl(data) {
  return request({
    url: '/web/openlinecheckinfodtl',
    method: 'post',
    data: data
  })
}

// 修改描述：开线检查信息明细
export function updateOpenlinecheckinfodtl(data) {
  return request({
    url: '/web/openlinecheckinfodtl',
    method: 'put',
    data: data
  })
}

// 删除描述：开线检查信息明细
export function delOpenlinecheckinfodtl(id) {
  return request({
    url: '/web/openlinecheckinfodtl/' + id,
    method: 'delete'
  })
}
