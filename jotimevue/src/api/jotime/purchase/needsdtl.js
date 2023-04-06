import request from '@/utils/request'

// 查询描述：采购需求明细列表
export function listNeedsdtl(query) {
  return request({
    url: '/web/purchase/purchase/needsdtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：采购需求明细详细
export function getNeedsdtl(id) {
  return request({
    url: '/web/purchase/purchase/needsdtl/' + id,
    method: 'get'
  })
}

// 新增描述：采购需求明细
export function addNeedsdtl(data) {
  return request({
    url: '/web/purchase/needsdtl',
    method: 'post',
    data: data
  })
}

// 修改描述：采购需求明细
export function updateNeedsdtl(data) {
  return request({
    url: '/web/purchase/needsdtl',
    method: 'put',
    data: data
  })
}

// 删除描述：采购需求明细
export function delNeedsdtl(id) {
  return request({
    url: '/web/purchase/needsdtl/' + id,
    method: 'delete'
  })
}
