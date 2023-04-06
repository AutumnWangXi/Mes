import request from '@/utils/request'

// 查询仓库列列表
export function listWarehouse(query) {
  return request({
    url: '/web/base/warehouse/list',
    method: 'get',
    params: query
  })
}
//获取仓库列表
export function  getWarehouseList(){
  return request({
    url: '/web/base/warehouse/getWarehouseList',
    method: 'get'
  })
}
// 查询仓库列详细
export function getWarehouse(id) {
  return request({
    url: '/web/base/warehouse/' + id,
    method: 'get'
  })
}

// 新增仓库列
export function addWarehouse(data) {
  return request({
    url: '/web/base/warehouse',
    method: 'post',
    data: data
  })
}

// 修改仓库列
export function updateWarehouse(data) {
  return request({
    url: '/web/base/warehouse',
    method: 'put',
    data: data
  })
}

// 删除仓库列
export function delWarehouse(id) {
  return request({
    url: '/web/base/warehouse/' + id,
    method: 'delete'
  })
}
