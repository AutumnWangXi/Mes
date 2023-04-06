import request from '@/utils/request'

// 查询描述：缺料补料列表
export function listSupplementariesdtl(query) {
  return request({
    url: '/web/supplementariesdtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：缺料补料详细
export function getSupplementariesdtl(id) {
  return request({
    url: '/web/supplementariesdtl/' + id,
    method: 'get'
  })
}

// 新增描述：缺料补料
export function addSupplementariesdtl(data) {
  return request({
    url: '/web/supplementariesdtl',
    method: 'post',
    data: data
  })
}

// 修改描述：缺料补料
export function updateSupplementariesdtl(data) {
  return request({
    url: '/web/supplementariesdtl',
    method: 'put',
    data: data
  })
}

// 删除描述：缺料补料
export function delSupplementariesdtl(id) {
  return request({
    url: '/web/supplementariesdtl/' + id,
    method: 'delete'
  })
}
// 新增
export function addSupplies(data) {
  return request({
    url: '/web/supplementariesdtl/addSupplies',
    method: 'post',
    data: data
  })
}
