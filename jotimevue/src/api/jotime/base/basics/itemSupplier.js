import request from '@/utils/request'

// 查询物料供应商列表
export function listSupplier(query) {
  return request({
    url: '/web/base/itemsupplier/list',
    method: 'get',
    params: query
  })
}

// 查询物料供应商详细
export function getSupplier(id) {
  return request({
    url: '/web/base/itemsupplier/' + id,
    method: 'get'
  })
}

// 新增物料供应商
export function addSupplier(data) {
  return request({
    url: '/web/base/itemsupplier',
    method: 'post',
    data: data
  })
}

// 修改物料供应商
export function updateSupplier(data) {
  return request({
    url: '/web/base/itemsupplier',
    method: 'put',
    data: data
  })
}

// 删除物料供应商
export function delSupplier(id) {
  return request({
    url: '/web/base/itemsupplier/' + id,
    method: 'delete'
  })
}
